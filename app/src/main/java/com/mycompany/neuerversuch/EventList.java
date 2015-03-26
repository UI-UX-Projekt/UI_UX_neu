package com.mycompany.neuerversuch;

import java.util.ArrayList;
import java.util.Arrays;
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
           eventListe = EventFactory.createAllEvents();
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


    public EventList filteredByGruppe(Gruppe gruppe){
        EventList matchedEventList = new EventList();
        for(Event event : this){
            if (event.istInGruppe(gruppe)) {
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

    public EventList filteredByTageszeit(Tageszeit tageszeit) {
        EventList matchedEventList = new EventList();
        for (Event event : this) {
            if (event.getTageszeit().isValidFor(tageszeit)) {
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
