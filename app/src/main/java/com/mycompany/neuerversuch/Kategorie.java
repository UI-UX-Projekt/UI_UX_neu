package com.mycompany.neuerversuch;

/**
 * Created by D060610 on 22.03.2015.
 */
public class Kategorie {

    public static  final  Kategorie ESSEN = new Kategorie(R.drawable.ic_essen, "Essen und Trinken");
    public static  final  Kategorie KULTUR= new Kategorie(R.drawable.ic_kultur, "Kultur");
    public static  final  Kategorie MESSE = new Kategorie(R.drawable.ic_messe, "Messe");
    public static  final  Kategorie MUSIK = new Kategorie(R.drawable.ic_musik,"Musik");
    public static  final  Kategorie NATUR = new Kategorie(R.drawable.ic_natur, "Natur");
    public static  final  Kategorie PARTY = new Kategorie(R.drawable.ic_party, "Party");
    public static  final  Kategorie SPORT = new Kategorie(R.drawable.ic_sport, "Sport");

    private int icon;
    private String text;

    public Kategorie(int icon, String text){
        this.icon=icon;
        this.text=text;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

}
