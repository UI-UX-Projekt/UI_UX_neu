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
                "11.4.15",    //datum
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
                Tageszeit.ABENDS,  //tageszeit
                fill(Gruppe.FREUNDE, Gruppe.PARTNER) //listGruppe

        ));

        eventListe.add(new Event(
                R.drawable.ic_zoologischer_garten, // bild
                "Zoologischer Stadtgarten", //titel
                "", //datum
                "08:00-18:00", //uhrzeit
                "Karlsruhe", //ort
                " Der Zoologische Stadtgarten Karlsruhe ist ein Stadtgarten mit Zoo in der Südweststadt von Karlsruhe.",
                " http://www.karlsruhe.de/b3/freizeit/zoo/stadtgarten.de", //webseite
                15, //likes
                7, //dislikes
                Kategorie.NATUR, //Kategorie
                8.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.PARTNER,Gruppe.FAMILIE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
                ));

        eventListe.add(new Event(
                R.drawable.ic_derdinger_horn, // bild
                "Derdinger Horn", //titel
                "", //datum
                "00:00-23:59", //uhrzeit
                "Oberderdingen", //ort
                " Aussichtsplatz und Grillplatz im schönen Kraigau", //beschreibung
                "http://www.oberderdingen.de/website/de/gemeinde/ortsbeschreibung/rundgang/derdinger_horn",//webseite
                50, //likes
                6, //dislikes
                Kategorie.NATUR, //Kategorie
                0.00, //preis
                true, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FREUNDE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
         ));
        eventListe.add(new Event(
                R.drawable.ic_baggersee_weingarten, // bild
                "Baggersee", //titel
                "", //datum 01.05.-30.09
                "09:00-18:00", //uhrzeit
                "Weingarten", //ort
                " Der Baggersee Weingarten liegt im Freizeitgebiet Breitheide, in dem man im Sommer auch Grillmöglichkeiten an eigens dafür errichteten Grillstellen vorfindet",
                " http://www.karlsruhe-tourismus.de/Media/Attraktionen/BaggerseeWeingarten",//webseite
                102, //likes
                15, //dislikes
                Kategorie.NATUR, //Kategorie
                0.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FREUNDE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
         ));
        eventListe.add(new Event(
                R.drawable.ic_guenther_klotz_anlage, // bild
                "Günther Klotz Anlage", //titel
                "", //datum
                "00:00-23:59", //uhrzeit
                "Karlsruhe", //ort
                " Die Günther-Klotz-Anlage ist eine wunderschön gelegene Grünanlage zwischen Südweststadt und Grünwinkel, die im Volksmund liebevoll „Klotze“ genannt wird.", //beschreibung
                " http://www.karlsruhe-tourismus.de/erleben/natur-und-entspannung/gaerten-undparks/Guenther-Klotz-Anlage",
                28, //likes
                10, //dislikes
                Kategorie.NATUR, //Kategorie
                0.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FREUNDE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
        ));

        eventListe.add(new Event(
                R.drawable.ic_tierpark_bretten, // bild
                "Tierpark", //titel
                "", //datum 01.03-30.11
                "09:00-18:00", //uhrzeit
                "Bretten", //ort
                "Von Hasen bis zu Ziegen können hier alle Tiere gestreichelt und gefüttert werden.",
                " http://www.tierpark-bretten.de", //webseite
                43, //likes
                5, //dislikes
                Kategorie.NATUR, //Kategorie
                4.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FAMILIE,Gruppe.FREUNDE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
         ));

        eventListe.add(new Event(
                 R.drawable.ic_azur_camping_turmbergblick, // bild
                "AZUR Camping Turmbergblick", //titel
                "", //datum 01.04.-14.10.
                "00:00-23:59", //uhrzeit
                "Durlach", //ort
                "Ideale Lage in Mitten der Natur.", //beschreibung
                "http://www.camping.info/deutschland/baden-württemberg/azur-campingturmbergblick-18932",
                78, //likes
                12, //dislikes
                Kategorie.NATUR, //Kategorie
                32.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FREUNDE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
        ));

        eventListe.add(new Event(
                R.drawable.ic_schlossgarten, // bild
                "Picknick im Schlossgarten", //titel
                "", //datum
                "00:00-23:59", //uhrzeit
                "KArlsruhe", //ort
                "CeBIT - Die IT-Messe für Deutschland", //beschreibung
                "http://www.cebit.de/", //webseite
                60, //likes
                3, //dislikes
                Kategorie.MESSE, //Kategorie
                30.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.MITTAGS, //tageszeit
                fill(Gruppe.PARTNER) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
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
                Tageszeit.GANZTAGS,  //tageszeit
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER) //listGruppe
        ));

        eventListe.add(new Event(
                R.drawable.ic_vfb_ksc, // bild
                "Relegationsspiel VfB vs. KSC ", //titel
                "28.5.2016", //datum
                "18:00-21:00", //uhrzeit
                "Stuttgart, Mercedes-Benz Arena", //ort
                "Hinspiel Relegation 1. Bundesliga VfB Stuttgart gegen KSC", //beschreibung
                "http://www.vfb.de/", //webseite
                600, //likes
                3, //dislikes
                Kategorie.SPORT, //Kategorie
                13.00, //preis
                false, //istFavorit
                true, //istEmpfehlung
                Tageszeit.ABENDS, //tageszeit
                fill(Gruppe.ALLEINE, Gruppe.FREUNDE)
        ));

        eventListe.add(new Event (R.drawable.ic_oxford,
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
                Tageszeit.GANZTAGS,
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER) //listGruppe
        ));

        eventListe.add(new Event(
                R.drawable.ic_badisches_staatstheater,
                "Dantons Tod",
                "31.5.2015",
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
                Tageszeit.ABENDS,
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER))); //listGruppe

        eventListe.add(new Event(
                R.drawable.ic_cebit, // bild
                "CeBIT", //titel
                "16.3.2016", //datum
                "09:00-18:00", //uhrzeit
                "Hannover", //ort
                "CeBIT - Die IT-Messe für Deutschland", //beschreibung
                "http://www.cebit.de/", //webseite
                60, //likes
                3, //dislikes
                Kategorie.MESSE, //Kategorie
                30.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.ALLEINE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
        ));

        eventListe.add(new Event(
                R.drawable.ic_feldberg,
                "Feldberg Masters",
                "11.4.2015",
                "14:00",
                "Feldberg, Seebuck",
                "Abschluss-Skirennen auf dem Feldberg. Jeder kann mitmachen!!!",
                "http://www.liftverbund-feldberg.de/Wintererlebnisse/Events/Feldberg-Masters",
                100,
                50,
                Kategorie.SPORT,
                0.00,
                true,
                false,
                Tageszeit.MITTAGS,
                fill(Gruppe.ALLEINE, Gruppe.FREUNDE, Gruppe.PARTNER,Gruppe.FAMILIE)
        ));

        eventListe.add(new Event(
                 R.drawable.ic_badisch_brauhaus, // bild
                "Badisch Brauhaus", //titel
                "",
                "Öffnungszeiten siehe Homepage", //uhrzeit
                "Stephanienstraße 38 – 40, Karlsruhe", //ort
                "Das Badisch Brauhaus ist eine gut bürgerliche Gaststätte mit überwiegend badischenGerichten. ", //beschreibung
                "http://www.badisch-brauhaus.de/", //webseite
                100, //likes
                12, //dislikes
                Kategorie.ESSEN, //Kategorie
                20.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.ALLEINE,Gruppe.FREUNDE,Gruppe.PARTNER,Gruppe.FAMILIE) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
        ));

        eventListe.add(new Event(
                 R.drawable.ic_enchilada, // bild
                "Enchilada", //titel
                "",
                "Öffnungszeiten siehe Homepage", //uhrzeit
                "Waldstraße 63, Karlsruhe", //ort
                "Das Enchilada ist eine Mischung aus mexikanischem Restaurant und einer mexikanischen Bar. Sehr beliebt ist das Cocktail-Casino, das jeden Montag ist. ", //beschreibung
                "http://www.enchilada.de/karlsruhe", //webseite
                71, //likes
                28, //dislikes
                Kategorie.ESSEN, //Kategorie
                15.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.ALLEINE,Gruppe.FREUNDE,Gruppe.PARTNER) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                ));

        eventListe.add(new Event(
                R.drawable.ic_vfb_ksc, // bild
                "Relegationsspiel KSC vs. VfB ", //titel
                "2.6.2015", //datum
                "19:00-22:00", //uhrzeit
                "Karlsruhe, Wildparkstadion", //ort
                "Rückspiel Relegation 1. Bundesliga KSC gegen VfB Stuttgart", //beschreibung
                "http://www.ksc.de/", //webseite
                550, //likes
                7, //dislikes
                Kategorie.SPORT, //Kategorie
                11.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.ABENDS, //tageszeit
                fill(Gruppe.ALLEINE, Gruppe.FREUNDE)
        ));
        eventListe.add(new Event(
                R.drawable.ic_vogelbraeu, // bild
                "Vogelbräu", //titel
                "",
                "Öffnungszeiten siehe Homepage", //uhrzeit
                "Kapellenstraße 50, Karlsruhe", //ort
                "Der Vogelbräu ist eine traditionsreiche Kneipe, die wegen ihres selbstgebrauten Bieres sehr beliebt ist. ", //beschreibung
                "http://www.vogelbraeu.de/startseite.html", //webseite
                49, //likes
                7, //dislikes
                Kategorie.ESSEN, //Kategorie
                10.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.ALLEINE,Gruppe.FREUNDE,Gruppe.PARTNER) //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
        ));




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
