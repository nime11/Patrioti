package com.jetbrains.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by lenart on 22. 02. 2017.
 */
public class Calc {
    public static void main (String[] args) {
      ArrayList<Progres> test = Napr();
        System.out.println(test.get(0).toString());

    }

    public  static  ArrayList Napr(){
        Date dans = Date.valueOf("2017-02-11");
        Date now = Date.valueOf("2017-03-19");


        Calendar c = Calendar.getInstance();
        c.setTime(dans);
        c.add(Calendar.DATE, 0);
        Date beforeevent = new java.sql.Date( c.getTime().getTime());
        Calendar o = Calendar.getInstance();
        o.setTime(now);
        o.add(Calendar.DATE, 0);
        Date ofevent = new java.sql.Date((o.getTime().getTime()));
        System.out.println(beforeevent);

        ArrayList<Clan> clanArrTODAY = GetData.GetArry(ofevent);
        ArrayList<Clan> clanArrBefore = GetData.GetArry(beforeevent);
        ArrayList<Progres> progArr = new ArrayList<Progres>();


        for (int i=0; i<clanArrTODAY.size(); i++) {
            for (int x=0;x < clanArrBefore.size(); x++){
                if(clanArrTODAY.get(i).id==clanArrBefore.get(x).id){
                    int id=  clanArrTODAY.get(i).id;
                    String ime = clanArrTODAY.get(i).ime;
                    double pmoc = clanArrTODAY.get(i).moč-clanArrBefore.get(x).moč;
                    double pinteligenca = clanArrTODAY.get(i).inteligenca - clanArrBefore.get(x).inteligenca;
                    double pkrank = clanArrTODAY.get(i).krank - clanArrBefore.get(x).krank;
                    double pmrank = clanArrTODAY.get(i).mrank-  clanArrBefore.get(x).mrank;
                    long ptotaldmg = clanArrTODAY.get(i).totaldmg - clanArrBefore.get(x).totaldmg;
                    progArr.add(new Progres(id,ime, pmoc, pinteligenca, pkrank,pmrank,ptotaldmg));
                }
            }

        }

        return  progArr;
    }


}
