package com.jetbrains.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

/**
 * Created by lenart on 6. 02. 2017.
 */
public class DownloadPage {

    public static ArrayList povleci() throws IOException {

        // Make a URL to the web page
        URL url = new URL("https://www.erevollution.com/en/api/unit-members/87");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        String podatki = null;
        ArrayList<Clan> clanArr = new ArrayList<Clan>();
        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            podatki=podatki+line;
        }
        try {
            String[] clani = podatki.split("}");

            for (int i=0;i<clani.length;i++) {
                String[] clanitemp = clani[i].split(":");
                clanArr.add(new Clan(clanitemp));
                clanArr.get(i).setTotaldmg(dobiskoda(clanArr.get(i).id));
            }
        } catch (PatternSyntaxException ex) {
            //
        }
        return  clanArr;
    }
    public static long  dobiskoda(int id) throws IOException {
        // Make a URL to the web page
        String a = "https://www.erevollution.com/en/api/citizen/"+ id;
        URL url = new URL(a);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        String podatki = null;
        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            podatki=podatki+line;
        }
        String[] clan = podatki.split(",");

        String[] x= clan[10].split(":");
        return Long.parseLong(x[1]);
    }


}
