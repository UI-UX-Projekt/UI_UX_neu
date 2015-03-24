package com.mycompany.neuerversuch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by D060610 on 22.03.2015.
 */
public class EventList extends ArrayList<Event>{
    public static EventList eventListe;

    public static EventList getAllEvents(){
        if(eventListe==null){
            eventListe=new EventList();
            eventListe.add(new Event(
                    R.drawable.ic_en_vogue, // bild
                    "House, Electro meets Charts",  //titel
                    new Date(450484752),    //datum
                    "Karlsruhe",      //ort
                    "House, Electro meets Charts // mit Nicolas Westermann & Mike - the guitar Hero",   //beschreibung
                    "http://www.envogue-nightclub.de",  //webseite
                    4,  //likes
                    1,   //dislikes
                    Kategorie.PARTY, //Kategorie
                    8.00,  //preis
                    false,    //istFavorit
                    false     //istEmpfehlung
            ));

            eventListe.add(new Event(
                    R.drawable.ic_wilhelma, // bild
                    "Wilhelma",  //titel
                    new Date(450484752),    //datum
                    "Stuttgart",      //ort
                    "Wilhelma - zoologischer Garten..",   //beschreibung
                    "http://www.wilhelma.de",  //webseite
                    6,  //likes
                    3,   //dislikes
                    Kategorie.NATUR, //Kategorie
                    16.00,  //preis
                    false,    //istFavorit
                    false     //istEmpfehlung
            ));
        }

        return eventListe;
    }

    public EventList filteredByKategorie(Kategorie kategorie){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(event.getKategorie()==kategorie){
                matchedEventList.add(event);
            }
        }

        return matchedEventList;
    }

    public EventList filteredByIstFavorit(){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(event.getIstFavorit()){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByIstEmpfehlung(){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(event.getIstEmpfehlung()){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByPreis(double preisuntergrenze, double preisobergrenze){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(preisuntergrenze <= event.getPreis() && event.getPreis()<= preisobergrenze){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByOrt(String ort){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(event.getOrt()==ort){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByDatum(Date datum){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(event.getDatum()==datum){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }


}
