package com.mycompany.neuerversuch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by D060610 on 24.03.2015.
 */
public class Gruppe  {
    public static final Gruppe NOT_SELECTED = new Gruppe("Bitte wählen");
    public static final Gruppe ALLEINE = new Gruppe("Alleine");
    public static final Gruppe FAMILIE = new Gruppe("Familie");
    public static final Gruppe FREUNDE = new Gruppe("Freunde");
    public static final Gruppe PARTNER = new Gruppe("Partner");

    private static List<Gruppe> all;
    public static List<Gruppe> getAll(){
       if(all == null){
           all = new ArrayList<Gruppe>();
           all.add(NOT_SELECTED);
           all.add(ALLEINE);
           all.add(FAMILIE);
           all.add(FREUNDE);
           all.add(PARTNER);
       }
        return all;
    }

    private String displayText;

    public Gruppe(String text) {
        displayText = text;
    }

    public String getDisplayText() {
        return displayText;
    }

    @Override
    public String toString() {
        return displayText;
    }

}
