package com.mycompany.neuerversuch;


public class Tageszeit {
    public static Tageszeit MORGENS = new Tageszeit("morgens");
    public static Tageszeit MITTAGS = new Tageszeit("mittags");
    public static Tageszeit ABENDS = new Tageszeit("abends");
    public static Tageszeit GANZTAGS = new Tageszeit("ganztags");

    private String text;
    public Tageszeit(String text) {
        this.text = text;
    }


    public boolean isValidFor(Tageszeit tageszeit) {
        if( this == GANZTAGS || tageszeit == GANZTAGS){
            return true;
        }else {
            return this == tageszeit;
        }
    }
}
