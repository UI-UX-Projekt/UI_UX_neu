package com.mycompany.neuerversuch;

/**
 * Created by D060610 on 24.03.2015.
 */
public class NavigationItem {
    public static  final  NavigationItem STARTSEITE = new NavigationItem(R.drawable.ic_startseite, "Startseite");
    public static  final  NavigationItem FILTER_SUCHE = new NavigationItem(R.drawable.ic_filter, "Filter Suche");
    public static  final  NavigationItem KATEGORIEN = new NavigationItem(R.drawable.ic_kategorie, "Kategorien");
    public static  final  NavigationItem EIGENE_FAVORITEN  = new NavigationItem(R.drawable.ic_favoriten,"Eigene Favoriten");
    public static  final  NavigationItem EMPFEHLUNGEN = new NavigationItem(R.drawable.ic_empfehlungen, "Empfehlungen");
    public static  final  NavigationItem HILFE = new NavigationItem(R.drawable.ic_hilfe, "Hilfe");
    public static  final  NavigationItem EINSTELLUNGEN= new NavigationItem(R.drawable.ic_optionen, "Einstellungen");

    private int icon;
    private String text;

    public NavigationItem(int icon, String text){
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
