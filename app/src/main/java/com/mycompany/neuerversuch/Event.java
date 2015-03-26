package com.mycompany.neuerversuch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by D060610 on 22.03.2015.
 */
public class Event {
    private int bild;
    private String titel;
    private String datum;
    private String uhrzeit;
    private String ort;
    private String beschreibung;
    private String webseite;
    private int likes;
    private int dislikes;
    private Kategorie kategorie;
    private double preis;
    private boolean istFavorit;
    private boolean istEmpfehlung;
    private Tageszeit tageszeit;
    private List<Gruppe> listGruppe;



    public Event(int bild, String titel, String datum,String uhrzeit, String ort, String beschreibung, String webseite, int likes, int dislikes, Kategorie kategorie, double preis, boolean istFavorit, boolean istEmpfehlung, Tageszeit tageszeit, List<Gruppe> listGruppe){
        this.bild=bild;
        this.titel=titel;
        this.datum=datum;
        this.uhrzeit=uhrzeit;
        this.ort=ort;
        this.beschreibung=beschreibung;
        this.webseite=webseite;
        this.likes=likes;
        this.dislikes=dislikes;
        this.kategorie=kategorie;
        this.preis=preis;
        this.istFavorit=istFavorit;
        this.istEmpfehlung=istEmpfehlung;
        this.tageszeit=tageszeit;
        this.listGruppe=listGruppe;

    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getOrt() {
        return ort;
    }

    public String getDatum() {
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

    public boolean getIstFavorit() {
        return istFavorit;
    }

    public boolean getIstEmpfehlung() {
        return istEmpfehlung;
    }

    public boolean istInGruppe(Gruppe gruppe){
        return listGruppe.contains(gruppe);
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public Tageszeit getTageszeit() {
        return tageszeit;
    }

    public void setIstFavorit(boolean istFavorit) {
        this.istFavorit = istFavorit;
    }
}

