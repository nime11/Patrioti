package com.jetbrains.core;

/**
 * Created by lenart on 17. 02. 2017.
 */
public class Clan {
    public int id = 0;
    public String ime= "";
    public int avatar = 0;
    public double moč = 0;
    public double inteligenca = 0;
    public double nazadje_viden = 0;
    public double energija = 0;
    public String kopnsk_rank= "";
    public double krank = 0;
    public String morsk_rank= "";
    public double mrank = 0;
    public double dhit = 0;
    public double kDmg1hit = 0;
    public double mDmg1hit = 0;
    public long totaldmg = 0;

    public void setTotaldmg(long totaldmg){
        this.totaldmg= totaldmg;
    }

    public static String Locis (String[] ime, int i){
        String a= ime[1+i].substring(0, ime[1+i].indexOf(","));
        return a;
    }
    public static int Lociint(String[] ime, int i){
        int a = Integer.parseInt( ime[1+i].substring(0, ime[1+i].indexOf(",")));
        return a;
    }

    public static double Locidoub(String[] ime, int i){
        double a = Double.parseDouble( ime[1+i].substring(0, ime[1+i].indexOf(",")));
        return a;
    }
    @Override
    public String toString() {
        return ("Id:"+this.getId()+
                " ime "+ this.getIme());

    }

    //constructor
    public Clan(String[] baza)  {
        this.id = Lociint(baza,1);
        this.ime = Locis(baza,2) ;
        this.avatar = Lociint(baza,3);
        this.moč = Locidoub(baza,4);
        this.inteligenca = Locidoub(baza,5);
        this.nazadje_viden = Locidoub(baza,6);
        this.energija = Locidoub(baza,7) ;
        this.kopnsk_rank = Locis(baza,8);
        this.krank= Locidoub(baza,9);
        this.morsk_rank= Locis(baza,10);
        this.mrank= Locidoub(baza,11);
        this.dhit= Locidoub(baza,12);
        this.kDmg1hit= Locidoub(baza,13);

    }

    public Clan(int id, String ime, int avatar, double moč, double inteligenca, String kopnsk_rank, double krank,
                String morsk_rank, double mrank, double dhit, double kDmg1hit, double mDmg1hit, long totaldmg) {
        this.id = id;
        this.ime= ime;
        this.avatar= avatar;
        this.moč= moč;
        this.inteligenca= inteligenca;
        this.kopnsk_rank = kopnsk_rank;
        this.krank= krank;
        this.morsk_rank= morsk_rank;
        this.mrank= mrank;
        this.dhit= dhit;
        this.kDmg1hit= kDmg1hit;
        this.mDmg1hit= mDmg1hit;
        this.totaldmg= totaldmg;
    }
    public Clan(int id, String ime, int avatar){
        this.id = id;
        this.ime= ime;
        this.avatar= avatar;
    }

    public  int getId(){
        return  id;
    }
    public  String getIme(){
        return  ime;
    }
    public double getEnergija() {
        return energija;
    }
    public double getInteligenca() {
        return inteligenca;
    }
    public double getMoč() {
        return moč;
    }
    public double getKrank() {
        return krank;
    }
    public double getNazadje_viden() {
        return nazadje_viden;
    }
    public int getAvatar() {
        return avatar;
    }
    public String getKopnsk_rank() {
        return kopnsk_rank;
    }
    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
    public double getDhit() {
        return dhit;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getMorsk_rank() {
        return morsk_rank;
    }
    public void setEnergija(double energija) {
        this.energija = energija;
    }
    public double getMrank() {
        return mrank;
    }
    public void setInteligenca(double inteligenca) {
        this.inteligenca = inteligenca;
    }
    public void setKopnsk_rank(String kopnsk_rank) {
        this.kopnsk_rank = kopnsk_rank;
    }
    public void setKrank(double krank) {
        this.krank = krank;
    }
    public void setMoč(double moč) {
        this.moč = moč;
    }
    public void setMorsk_rank(String morsk_rank) {
        this.morsk_rank = morsk_rank;
    }
    public void setDhit(double dhit) {
        this.dhit = dhit;
    }
    public void setMrank(double mrank) {
        this.mrank = mrank;
    }
    public void setNazadje_viden(double nazadje_viden) {
        this.nazadje_viden = nazadje_viden;
    }
    public double getkDmg1hit() {
        return kDmg1hit;
    }
    public double getmDmg1hit() {
        return mDmg1hit;
    }
    public long getTotaldmg() {
        return totaldmg;
    }
    public void setkDmg1hit(double kDmg1hit) {
        this.kDmg1hit = kDmg1hit;
    }
    public void setmDmg1hit(double mDmg1hit) {
        this.mDmg1hit = mDmg1hit;
    }

}
