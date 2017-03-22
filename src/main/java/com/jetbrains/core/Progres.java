package com.jetbrains.core;

/**
 * Created by lenart on 22. 02. 2017.
 */
public class Progres {
    public int id=0;
    public String ime = "";
    public double moč = 0;
    public double inteligenca = 0;
    public double kopensk_rank = 0;
    public double morski_rank = 0;
    public long totaldmg = 0;

    public Progres(int id, String ime, double moč, double inteligenca, double kopensk_rank, double pmrank, long ptotaldmg ){
        this.id = id;
        this.ime= ime;
        this.moč = moč;
        this.inteligenca = inteligenca;
        this.kopensk_rank = kopensk_rank;
        this.morski_rank = pmrank;
        this.totaldmg = ptotaldmg;
    }
    public int getId() {
        return id;
    }
    public String getIme() {
        return ime;
    }
    public double getMoč() {
        return moč;
    }public double getInteligenca() {
        return inteligenca;
    }
    public double getKopensk_rank() {
        return kopensk_rank;
    }
    public double getMorski_rank() {
        return morski_rank;
    }
    public long getTotaldmg() {
        return totaldmg;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    public void setId(int id){this.id=id;}
    public void setKopensk_rank(double kopensk_rank) {
        this.kopensk_rank = kopensk_rank;
    }
    public void setMoč(double moč) {
        this.moč = moč;
    }
    public void setMorski_rank(double morski_rank) {
        this.morski_rank = morski_rank;
    }
    public void setTotaldmg(long totaldmg) {
        this.totaldmg = totaldmg;
    }
    public void setInteligenca(double inteligenca) {
        this.inteligenca = inteligenca;
    }


    @Override
    public String toString() {
        return ("id:"+this.getId()+
                " ime: "+ this.getIme()+
                " Napredek moči "+ this.getMoč()+
                " Napredek iteligence "+ this.getInteligenca()+
                " Napredek v kopenskem ranku "+ this.getKopensk_rank()+
                " Napredek v pomorskem ranku "+ this.getMorski_rank()+
                " Napredk v skupni moči "+ this.getTotaldmg());
    }
}
