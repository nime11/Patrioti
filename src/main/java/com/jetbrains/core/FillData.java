package com.jetbrains.core;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by lenart on 21. 02. 2017.
 */
public class FillData {
    public static void main (String[] args) throws IOException {
    povni();
    }
    public static void povni() throws IOException {
        Date dans = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        ArrayList<Clan> clanArr = DownloadPage.povleci();
        Connection conn = null;
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        PreparedStatement nov = null;
        int clansql = 1;
        try {
            // Open a connection

            conn = dbConn.getConnection();

            /* Create SQL statement */
            String SQL = String.format("INSERT INTO podatki(id_clana, moc,inteligenca,kopnsk_rank,stevilo_krank,morsk_rank,stevilo_mrank,dhit,kDmg1hit,mDmg1hit,totaldmg,date)\n" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            String novc = String.format("INSERT INTO clani (id_igralca,ime,avatar)\n" +
                    "VALUES(?,?,?)");


            // Create preparedStatemen
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SQL);
            nov = conn.prepareStatement(novc);
            stmt2 = conn.createStatement();

            // Set auto-commit to false
            conn.setAutoCommit(false);
            for (final Clan clan : clanArr) {
                String sqlClan = String.format("Select id from clani where id_igralca ="+clan.id);
                ResultSet res = stmt2.executeQuery(sqlClan);
                if (!res.isBeforeFirst()) {
                        System.out.println(clan.id);

                        nov.setInt(1, clan.id);
                        nov.setString(2, clan.ime);
                        nov.setInt(3, clan.avatar);
                        nov.addBatch();
                        // Create an int[] to hold returned values
                        int[] countC = nov.executeBatch();
                        System.out.println(countC);

                        //Explicitly commit statements to apply changes
                        conn.commit();

                }
            }

            for (final Clan clan : clanArr) {
                String sqlClan = String.format("Select id from clani where id_igralca =" + clan.id);
                ResultSet rs = stmt2.executeQuery(sqlClan);
                while (rs.next()) {
                    clansql = rs.getInt(1);
                }

                stmt.setInt(1, clansql);
                stmt.setDouble(2, clan.moč);
                stmt.setDouble(3, clan.inteligenca);
                stmt.setString(4, clan.kopnsk_rank);
                stmt.setDouble(5, clan.krank);
                stmt.setString(6, clan.morsk_rank);
                stmt.setDouble(7, clan.mrank);
                stmt.setDouble(8, clan.dhit);
                stmt.setDouble(9, clan.kDmg1hit);
                stmt.setDouble(10, clan.mDmg1hit);
                stmt.setLong(11, clan.totaldmg);
                stmt.setDate(12, dans);

                // Add it to the batch
                stmt.addBatch();
                // Create an int[] to hold returned values
                int[] count = stmt.executeBatch();
                System.out.println(count);

                //Explicitly commit statements to apply changes
                conn.commit();
            }


            // Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
                    stmt2.close();
                    nov.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}


