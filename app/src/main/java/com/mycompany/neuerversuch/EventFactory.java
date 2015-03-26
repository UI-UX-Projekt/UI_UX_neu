package com.mycompany.neuerversuch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D060610 on 26.03.2015.
 */
public class EventFactory {
    
    public static  EventList createAllEvents(){
        EventList eventListe=new EventList();
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
                "abends",  //tageszeit
                fill(Gruppe.FREUNDE, Gruppe.PARTNER) //listGruppe

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
                "ganztags",  //tageszeit
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER) //listGruppe
        ));

        eventListe.add(new Event (R.drawbale.ic_oxford, //https://www.facebook.com/267165350015397/photos/a.267168930015039.65403.267165350015397/403382409727023/?type=1&theater
                "Oxford Café",
                "",
                "10:00-02:00",
                "Karlsruhe",
                "Die Studentenkneipe in Karlsruhe",
                "http://www-oxford-cafe.de",
                10,
                2,
                Kategorie.ESSEN,
                0.00,
                true,
                true,
                "ganztags",
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER) //listGruppe
        ));

        eventListe.add(new Event(
                R.drawable.ic_badisches_staatstheater,
                "Dantons Tod",
                "31.05.2015",
                "20:00-22:00",
                "Karlsruhe",
                "Dantons Tod im Badischen Staatstheater",
                "http://www.staatstheater.karlsruhe.de",
                2,
                20,
                Kategorie.KULTUR,
                30.00,
                false,
                false,
                "abends",
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER))); //listGruppe

        eventListe.add(new Event(
                R.drawable.ic_com15,
                "COM15",
                "13.04.2015-16.04.2015",
                "09:00-18:00",
                "Messe Karlsruhe / dm-arena",
                "COM15, die Messe der Fiducia",
                0,
                0,
                Kategorie.MESSE,
                50.00,
                false,
                false,
                "ganztags",
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER))); //listGruppe

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
                "abends",
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER //listGruppe
                )));

        return  eventListe;
    }


   private static List<Gruppe> fill(Gruppe gruppe){
        List<Gruppe> listGruppe = new ArrayList<Gruppe>();
        listGruppe.add(gruppe);
        return listGruppe;
    }

    private static List<Gruppe> fill(Gruppe gruppe_1, Gruppe gruppe_2){
        List<Gruppe> listGruppe = new ArrayList<Gruppe>();
        listGruppe.add(gruppe_1);
        listGruppe.add(gruppe_2);
        return listGruppe;
    }

    private static List<Gruppe> fill(Gruppe gruppe_1, Gruppe gruppe_2, Gruppe gruppe_3){
        List<Gruppe> listGruppe = new ArrayList<Gruppe>();
        listGruppe.add(gruppe_1);
        listGruppe.add(gruppe_2);
        listGruppe.add(gruppe_3);
        return listGruppe;
    }

    private static List<Gruppe> fill(Gruppe gruppe_1, Gruppe gruppe_2, Gruppe gruppe_3, Gruppe gruppe_4){
        List<Gruppe> listGruppe = new ArrayList<Gruppe>();
        listGruppe.add(gruppe_1);
        listGruppe.add(gruppe_2);
        listGruppe.add(gruppe_3);
        listGruppe.add(gruppe_4);
        return listGruppe;
    }
}
