package com.mycompany.neuerversuch;

/**
 * Created by D060610 on 22.03.2015.
 */
public class Kategorie {
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
