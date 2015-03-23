package com.mycompany.neuerversuch;

import java.util.Date;

/**
 * Created by D060610 on 22.03.2015.
 */
public class Event {
    private int bild;
    private String titel;
    private Date datum;
    private String ort;
    private String beschreibung;
    private String webseite;
    private int likes;
    private int dislikes;
    private Kategorie kategorie;
    double preis;


    public Event(int bild, String titel, Date datum, String ort, String beschreibung, String webseite, int likes, int dislikes, Kategorie kategorie, double preis){
        this.bild=bild;
        this.titel=titel;
        this.datum=datum;
        this.ort=ort;
        this.beschreibung=beschreibung;
        this.webseite=webseite;
        this.likes=likes;
        this.dislikes=dislikes;
        this.kategorie=kategorie;
        this.preis=preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getOrt() {
        return ort;
    }

    public Date getDatum() {
        return datum;
    }

    public int getBild() {
        return bild;
    }

    public String getTitel() {
        return titel;
    }

    public int getRanking(){
        if((likes + dislikes) > 0) {
            double res = (likes * 100) / (likes + dislikes);
            return (int) res;
        }
        else {
            return 50;
        }
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public String getWebseite() {
        return webseite;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public double getPreis() {
        return preis;
    }
}

