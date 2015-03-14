package com.mycompany.neuerversuch.dummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mycompany.neuerversuch.PreviewElements;
import com.mycompany.neuerversuch.R;

import java.util.ArrayList;

/**
 * Created by Philipp on 14.03.2015.
 */
public class PreviewAdapter extends ArrayAdapter<PreviewElements>{



    public PreviewAdapter(Context context, ArrayList<PreviewElements> elemente ) {
        super(context, 0, elemente);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PreviewElements element = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sample_view_preview_element, parent, false);
        }
        // Get Reference to Elements in View
        TextView name = (TextView) convertView.findViewById(R.id.nameOfEvent);
        ImageView iconEvent = (ImageView) convertView.findViewById(R.id.imageView);
        TextView shortDescription = (TextView) convertView.findViewById(R.id.shortDescription);
        TextView uhrzeit = (TextView) convertView.findViewById(R.id.uhrzeit);
        TextView webseite = (TextView) convertView.findViewById(R.id.webseite);
        RatingBar rating = (RatingBar) convertView.findViewById(R.id.ratingBar);
        Button favorite = (Button) convertView.findViewById(R.id.favorite);

        // Populate the data into the template view using the data object
        name.setText(element.name);
        iconEvent.setImageResource(element.image);
        shortDescription.setText(element.shortDescription);
        uhrzeit.setText(element.zeiten);
        webseite.setText(element.webseite);
        rating.setRating(element.rating);
        if(element.favorite == true){
            favorite.setText("❤");
        }else{
            favorite.setText("♡");
        }
        // Return the completed view to render on screen
        return convertView;
    }
}
