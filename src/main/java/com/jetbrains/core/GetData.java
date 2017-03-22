package com.jetbrains.core;

import java.sql.Connection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by lenart on 21. 02. 2017.
 */
public class GetData {

    public  static  ArrayList GetArry(Date time){
        ArrayList<Clan> clanArr = new ArrayList<Clan>();

        try {
            Connection conn = dbConn.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery( "SELECT *\n" +
                    "FROM podatki\n" +
                            "INNER JOIN clani\n" +
                            "ON podatki.id_clana=clani.id\n" +
                            "where date =   \" "+ time +"\"" );
            if(!rs.isBeforeFirst()){
                System.out.println("No data");
            }
            while ( rs.next() ) {

                int id_igralca=rs.getInt("id_igralca");
                String ime =rs.getString("ime");
                int avatar = rs.getInt("avatar");
                int moc = rs.getInt("moc");
                int iteligenca =rs.getInt("inteligenca");
                String kopnsk_rank =rs.getString("kopnsk_rank");
                double stevilo_krank =rs.getDouble("stevilo_krank");
                String morsk_rank =rs.getString("morsk_rank");
                double stevilo_mrank= rs.getDouble("stevilo_mrank");
                double dhit=rs.getDouble("dhit");
                double kDmg1hit=rs.getDouble("kDmg1hit");
                double mDmg1hit=rs.getDouble("mDmg1hit");
                long totaldmg=rs.getLong("totaldmg");
                clanArr.add(new Clan(id_igralca,ime,avatar,moc,iteligenca,kopnsk_rank,stevilo_krank,morsk_rank,stevilo_mrank,dhit,kDmg1hit,mDmg1hit,totaldmg));

            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return clanArr;
    }
}
