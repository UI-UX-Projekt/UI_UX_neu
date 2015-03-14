package com.mycompany.neuerversuch;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Philipp on 14.03.2015.
 */
public class PreviewElements {
    public String name = "AppClub|StudyApp";
    public String shortDescription = "Happy Hour bis 24 Uhr";
    public String zeiten = "13.3.15 23:00 -05:00";
    public String webseite = "www.appclub.de";
    public int rating = 4;
    public boolean favorite = false;
    public int image = R.mipmap.icon_app_club;
    public PreviewElements(String name, String shortDescription, String zeiten, String webseite, int rating, boolean favorite, int image){
        /*Commented out because of testing purposes
        this.name = name;
        this.shortDescription = shortDescription;
        this.zeiten = zeiten;
        this.webseite = webseite;
        this.rating = rating;
        this.favorite = favorite;
        this.image = image;

         */
    }
}
