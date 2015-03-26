package com.mycompany.neuerversuch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

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
                    "11.04.15",    //datum
                    "22:00",    //uhrzeit
                    "Karlsruhe",      //ort
                    "House, Electro meets Charts // mit Nicolas Westermann & Mike - the guitar Hero",   //beschreibung
                    "http://www.envogue-nightclub.de",  //webseite
                    4,  //likes
                    1,   //dislikes
                    Kategorie.PARTY, //Kategorie
                    8.00,  //preis
                    true,    //istFavorit
                    false,     //istEmpfehlung
                    "abends"    //tageszeit
            ));

            eventListe.add(new Event(
                    R.drawable.ic_wilhelma, // bild
                    "Wilhelma",  //titel
                    "",    //datum
                    "09:00-18:00", //uhrzeit
                    "Stuttgart",      //ort
                    "Wilhelma - zoologischer Garten..",   //beschreibung
                    "http://www.wilhelma.de",  //webseite
                    6,  //likes
                    3,   //dislikes
                    Kategorie.NATUR, //Kategorie
                    16.00,  //preis
                    false,    //istFavorit
                    false,     //istEmpfehlung
                    "ganztags"  //tageszeit
            ));
            eventListe.add(new Event (R.drawbale.ic_oxford, //https://www.facebook.com/267165350015397/photos/a.267168930015039.65403.267165350015397/403382409727023/?type=1&theater
"Oxford Café",
"",
"10:00-02:00"
"Karlsruhe",
"Die Studentenkneipe in Karlsruhe",
"http://www-oxford-cafe.de",
10,
2,
Kategorie.ESSEN,
0.00,
true,
true,
ganztags
));

eventListe.add(new Event(
R.drawable.ic_badisches_staatstheater,
"Dantons Tod"
"31.05.2015",
"20:00-22:00",
"Karlsruhe"
"Dantons Tod im Badischen Staatstheater
"http://www.staatstheater.karlsruhe.de",
2,
20,
Kategorie.KULTUR,
30.00,
false,
false,
"abends"));

eventListe.add(new Event(
R.drawable.ic_com15,
"COM15",
"13.04.2015-16.04.2015",
"09:00-18:00",
"Messe Karlsruhe / dm-arena",
"COM15, die Messe der Fiducia"
0,
0,
Kategorie.MESSE,
50.00,
false,
false,
ganztags));

eventListe.add(new Event(
R.drawable.ic_the_australian_pink_floyd,
"The Australian Pink Floyd",
"02.05.2015",
"20:30",
"Schwarzwaldhalle Karlsruhe",
"Die weltweit erfolgreichste Pink Floyd Tribute-Band kommt 2015 erneut auf große Tour!",
"http://www.ticketonline.de/the-australian-pink-floyd-show-tickets-karlsruhe.html?affiliate=2TO&doc=artistPages/tickets&fun=artist&action=tickets&key=1135535$4055434",
"99",
"1",
Kategorie.MUSIK,
60.54,
false,
true,
"abends"));




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

    public EventList filteredByKategorie(List<Kategorie> listKategorie){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(listKategorie.contains(event.getKategorie())){
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
            if(event.getOrt().equalsIgnoreCase(ort)){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByDatum(String datum){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if(event.getDatum().equals(datum) || event.getDatum().equals("")){
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByTageszeit(String tageszeit) {
        EventList matchedEventList = new EventList();
        for (Event event : this) {
            if (event.getTageszeit().equalsIgnoreCase(tageszeit)) {
                matchedEventList.add(event);
            }
        }
        return matchedEventList;
    }

    public EventList filteredByText(String newText) {
        String[] parts = newText.trim().split(" ");
        final HashMap<Event,Double> matchedEvents = new HashMap<Event,Double>();


        for (Event event : this) {
            double power = 0.0;
            for(String text : parts) {
                power = calcPowerForMatches(power,event.getTitel(),text,2.0);
                power = calcPowerForMatches(power,event.getBeschreibung(),text,1.0);
                power = calcPowerForMatches(power,event.getWebseite(),text,0.75);
                power = calcPowerForMatches(power,event.getOrt(),text,0.5);
                power = calcPowerForMatches(power,event.getKategorie().getText(),text,0.25);
            }
            if(power > 0.0){
                matchedEvents.put(event,power);
            }
        }

        EventList matchedEventList = new EventList();
        Comparator<Event> bvc =  new EventComparator(matchedEvents);
        TreeMap<Event,Double> sorted_map = new TreeMap<Event,Double>(bvc);
        sorted_map.putAll(matchedEvents);
        matchedEventList.addAll(sorted_map.keySet());
        return matchedEventList;
    }
    private double calcPowerForMatches(double power,String original, String searchPart, double modifier){
        if (original.equals(searchPart)) {
            return power + (searchPart.length()*5*modifier);
        }else if (original.contains(searchPart)) {
            return power + (searchPart.length()*2*modifier);
        }else if (original.toLowerCase().contains(searchPart.toLowerCase())) {
            return power + (searchPart.length()*modifier);
        }
         return power;
    }
}
