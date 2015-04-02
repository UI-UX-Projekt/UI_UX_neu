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
                fill(Gruppe.FREUNDE, Gruppe.PARTNER), //listGruppe
                "Alles in allem wird deutlich, dass die Zukunft große Chancen bereithält - sie enthält aber auch Fallstricke. Der Trick ist, den Fallstricken aus dem Weg zu gehen, die Chancen zu ergreifen und bis sechs Uhr wieder zu Hause zu sein.Welche Tricks hält der Samstagabend denn für euch bereit? Helft euch selbst, in dem ihr dem Fallstrick aus dem Weg geht und eure Chance ergreift euch mit Musik von Nicolas Westermann & Friends  bis in die Morgenstunden den Abend zu versüßen auch wenn ihr nicht um sechs zuhause seid. "
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
                fill(Gruppe.PARTNER,Gruppe.FAMILIE), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
                "Die einzigartige Kombination des Zoologischen Stadtgartens Karlsruhe aus Tiergarten und Parklandschaft zieht jährlich über eine Million Besucherinnen und Besucher in ihren Bann. Mitten in der Stadt gelegen, lädt die grüne Oase mit historischem Baumbestand, farben­frohen Blütenarrangements, Themen­gär­ten und Wasserflächen ein, die Natur zu erleben und eine Vielzahl an Tierarten aus allen Erdteilen zu entdecken und kennen zu lernen."
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
                fill(Gruppe.FREUNDE,Gruppe.PARTNER), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
                "Das Derdinger Horn ist ein bezaubernder Aussichtsplatz mit Grillmöglichkeit. Man kann einen gemütlichen Tag zu zweit oder mit Freunden verbringen. Ebenfalls eignet sich das Derdinger Horn als guten Platz für ein Date."
         ));

        eventListe.add(new Event(
                R.drawable.ic_baggersee_weingarten, // bild
                "Baggersee", //titel
                "", //datum 01.05.-30.09
                "09:00-18:00", //uhrzeit
                "Weingarten", //ort
                "Der Baggersee Weingarten liegt im Freizeitgebiet Breitheide, in dem man im Sommer auch Grillmöglichkeiten an eigens dafür errichteten Grillstellen vorfindet",
                " http://www.karlsruhe-tourismus.de/Media/Attraktionen/BaggerseeWeingarten",//webseite
                102, //likes
                15, //dislikes
                Kategorie.NATUR, //Kategorie
                0.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FREUNDE, Gruppe.PARTNER), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
                "Der Baggersee Weingarten liegt im Freizeitgebiet Breitheide, in dem man im Sommer auch Grillmöglichkeiten an eigens dafür errichteten Grillstellen vorfindet. Die Entfernung von Karlsruhe (Stadtmitte) beträgt ca. 18 km. Der Eintritt ist frei und es stehen gebührenpflichtige Parkmöglichkeiten zur Verfügung. "
         ));

        eventListe.add(new Event(
                R.drawable.ic_guenther_klotz_anlage, // bild
                "Günther Klotz Anlage", //titel
                "", //datum
                "00:00-23:59", //uhrzeit
                "Karlsruhe", //ort
                "Die Günther-Klotz-Anlage ist eine wunderschön gelegene Grünanlage zwischen Südweststadt und Grünwinkel, die im Volksmund liebevoll „Klotze“ genannt wird.", //beschreibung
                " http://www.karlsruhe-tourismus.de/erleben/natur-und-entspannung/gaerten-undparks/Guenther-Klotz-Anlage",
                28, //likes
                10, //dislikes
                Kategorie.NATUR, //Kategorie
                0.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.GANZTAGS, //tageszeit
                fill(Gruppe.FREUNDE, Gruppe.PARTNER), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
                "Die Günther-Klotz-Anlage ist eine Grünanlage und wurde nach dem ehemaligen Karlsruher Oberbürgermeister Günther Klotz benannt. Sie befindet sich zwischen den Stadtteilen Grünwinkel, Mühlburg, Weststadt, Südweststadt und Beiertheim-Bulach und dient als wichtiges Naherholungsgebiet für die Bewohner dieser Stadtteile. Da die Anlage dem Verlauf der Alb folgt, bildet sie für viele Radfahrer und Inlineskater den Ausgangspunkt für kleinere Touren in Richtung Rhein oder Ettlingen entlang der Alb."
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
                fill(Gruppe.FAMILIE,Gruppe.FREUNDE), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                "Liebe Besucher, Sie wollen Tieren richtig nahe sein? Dann sind Sie bei uns richtig! Sobald Sie das Eingangstor hinter sich gelassen haben, kann es losgehen. An manchen Tagen erwarten Sie bereits hier die ersten Tiere. Frei in verschiedenen begehbaren Gehegen sind bei uns die: Kängurus, Nandus, Damhirsche, Alpakas, Ziegen, Schafe, Esel, Schweine und zeitweise die Ponys. Die übrigen Tiere wie: Nasenbären, Zebras, Yaks, Kaninchen, Lamas, Vögel und Meerschweinchen sind in nicht begehbaren Gehegen untergebracht. Dennoch kann man auch hier gut Kontakt aufnehmen, sowie streicheln und füttern."
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
                fill(Gruppe.FREUNDE), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER
                "Der AZUR Campingpark Turmbergblick in Karlsruhe-Durlach zeichnet sich nicht nur durch seine ideale Lage unweit der Autobahn A5 zwischen Frankfurt und Baden-Baden aus, sondern ist auch nur wenige Kilometer von der Pfalz, dem Nord-Schwarzwald und dem Rheintal entfernt."
        ));

        eventListe.add(new Event(
                R.drawable.ic_schlossgarten, // bild
                "Picknick im Schlossgarten", //titel
                "", //datum
                "00:00-23:59", //uhrzeit
                "Karlsruhe", //ort
                "CeBIT - Die IT-Messe für Deutschland", //beschreibung
                "http://www.cebit.de/", //webseite
                60, //likes
                3, //dislikes
                Kategorie.MESSE, //Kategorie
                30.00, //preis
                false, //istFavorit
                false, //istEmpfehlung
                Tageszeit.MITTAGS, //tageszeit
                fill(Gruppe.PARTNER, Gruppe.FREUNDE, Gruppe.FAMILIE), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                "Jenseits des Schlosses zum Hardtwald hin liegt der Schlossgarten mit dem alten Botanischen Garten im Westen und dem Fasanengarten im Osten. Der Schlossgarten wurde unter Markgraf Karl Wilhelm durch den Hofgärtner Christian Thran 1731 bis 1746 im französischen Barockstil angelegt. Sein Nachfolger Großherzog Karl Friedrich ließ Bereiche des Gartens durch die Hofgärtner Saul und Müller und schließlich ab 1787 durch den aus England berufenen Garteninspektor Friedrich Schweickardt nach englischen Vorbildern umgestal­ten. Anlässlich der Bundesgartenschau 1967 wurde der Schlossgarten im Stil eines englischen Landschaftsparks erneuert und weiterentwickelt. Plastiken vom Barock bis zur Moderne, Denkmäler, Brunnen aus den verschiedenen Epochen und der große See beleben und akzentuieren die Grünflächen."
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
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER), //listGruppe
                "Der heutige Park der Wilhelma gehört zum historischen Erbe des Landes Baden-Württemberg. Der Park vollzog eine Wandlung vom rein privaten Rückzugsort eines Königs zu einem Zoologisch-Botanischen Garten mit rund 2 Millionen Besuchern jährlich."
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
                fill(Gruppe.ALLEINE, Gruppe.FREUNDE),
                "Für alle Fußballbegeisterte und Fans der Vereine Karlruher SC und VfB Stuttgart ein Besuch wert. "
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
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER),
                "Der Markt gehört ganz klaren Gesetzen. Wir realisieren nur ein Konzept, mit dem wir die Bedürfnisse einer ausreichend großen, an dem Standort anzutreffenden Zielgruppe, erfüllen. Die Zielgruppe OXFORD-Cafe ist klar definiert: Studenten. OXFORD-Cafe steht für die Überzeugung, dass es darauf ankommt, für unsere Zielgruppe authentisch zu wirken – Qualität zum fairen Preis und darüber hinaus von der breiten Masse abheben. Das OXFORD-Cafe stillt Durst und Hunger von Studenten, wir bieten einen Anlaufpunkt bei dem sie sich morgens, mittags und abends nit Freunden treffen. Studenten verknüpfen Ausgehen mit einer Vielzahl von Erwartungen. Wie diese auch immer aussehen, sie haben stets mit Emotionen und Begegnungen zu tun. Heutzutage setzen viele Studenten auf Lebensqualität, Gesundheit, Sport und Wellness…"
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
                fill(Gruppe.FAMILIE, Gruppe.FREUNDE, Gruppe.PARTNER),//listGruppe
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."));

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
                fill(Gruppe.ALLEINE), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                "Die CeBIT (Akronym für Centrum für Büroautomation, Informationstechnologie und Telekommunikation, ursprünglich Centrum der Büro- und Informationstechnik) ist die weltweit größte Messe für Informationstechnik und findet seit 1986 jedes Frühjahr auf dem Messegelände Hannover statt. Veranstalter der CeBIT ist die Deutsche Messe AG (DMAG)."
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
                fill(Gruppe.ALLEINE, Gruppe.FREUNDE, Gruppe.PARTNER,Gruppe.FAMILIE),
                "Zum Luftkurort Feldberg gehört der höchste Gipfel des Schwarzwaldes: der 1493 Meter hohe Feldberg. Genießen Sie auf und rund um den Feldberg idyllische Pfade und grandiose Panoramen. Als Startpunkt zu den schönsten Touren durch das Höhenwandergebiet empfiehlt sich die Bergstation der Feldbergbahn auf 1450 Metern."
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
                fill(Gruppe.ALLEINE,Gruppe.FREUNDE,Gruppe.PARTNER,Gruppe.FAMILIE), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                "Ob große Familien- oder Firmenfeier in der Veranstaltungsebene, rustikales Rittermahl im Gewölbekeller, gut bürgerliche Küche im Boulevard oder feine Cocktails in der ALLVITALIS Cocktailbar; das BADISCH BRAUHAUS bietet eine Vielfalt unter einem Dach, die in Karlsruhe ihresgleichen sucht!"
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
                fill(Gruppe.ALLEINE,Gruppe.FREUNDE,Gruppe.PARTNER), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                "Wir sind Mexico!Wir sind Tequila! Neben den leckersten Speisen aus dem Land der Maya und Azteken sowie einer großen Auswahl an exotischen Cocktails, bieten wir Dir außerdem 400 unterschiedlichste Tequila."
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
                fill(Gruppe.ALLEINE, Gruppe.FREUNDE),
                "Für alle Fußballbegeisterte und Fans der Vereine Karlruher SC und VfB Stuttgart ein Besuch wert. "
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
                fill(Gruppe.ALLEINE,Gruppe.FREUNDE,Gruppe.PARTNER), //listGruppe Gruppe.FREUNDE, Gruppe.PARTNER Gruppe.FAMILIE
                "Das Stamm-Nest aller Ur-Vögel und zentrale Feuchtigkeitsaufnahmestelle des Homo Vogelbräuensis - seit 1985 aus dem Stadtbild Karlsruhes nicht mehr wegzudenken. Häufig können Sie verklärt grinsende Vogel-Liebhaber auf der Kapellenstraße beobachten, wie sie sich in Scharen ihrem beliebten Feuchtbiotop nähern."
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
