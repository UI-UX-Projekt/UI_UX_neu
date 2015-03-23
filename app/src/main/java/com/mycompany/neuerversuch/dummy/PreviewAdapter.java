/*package com.mycompany.neuerversuch.dummy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.mycompany.neuerversuch.PreviewElements;
import com.mycompany.neuerversuch.R;

import java.util.ArrayList;

/**
 * Created by Philipp on 14.03.2015.
 */
/*
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
        LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        Button favorite = (Button) convertView.findViewById(R.id.favorite);
        Log.i("PHILIPP", "Listener geaddet");
        //TextView favorite =(TextView) convertView.findViewById(R.id.favorite);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button favorite = (Button) v;
                if (favorite.getText() == "♡") {
                    favorite.setText("♥");
                    favorite.setTextColor(Color.RED);
                } else {
                    favorite.setText("♡");
                    favorite.setTextColor(Color.GRAY);
                    favorite.setTypeface(null, Typeface.BOLD);
                }
                Log.i("PHILIPP", "Listener funktioniert");
            }
        });
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
*/
package com.mycompany.neuerversuch.dummy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

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
        ProgressBar rating = (ProgressBar) convertView.findViewById(R.id.rating);
        //RatingBar favorite = (RatingBar) convertView.findViewById(R.id.favorite);
        ToggleButton favorite = (ToggleButton) convertView.findViewById(R.id.favorite);
        // LayerDrawable stars = (LayerDrawable) favorite.getProgressDrawable();
        // stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        // favorite.setMax(1);
        Log.i("PHILIPP", "Listener geaddet");
        //TextView favorite =(TextView) convertView.findViewById(R.id.favorite);
        /*favorite.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               ToggleButton favorite = (ToggleButton) v;
               if (favorite.get) {
                   favorite.setRating(1);
               }else{
                   favorite.setRating(0);
               }
               Log.i("PHILIPP", "TouchListener funktioniert");
               return true;
           }
       });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/

        // Populate the data into the template view using the data object
        name.setText(element.name);
        iconEvent.setImageResource(element.image);
        shortDescription.setText(element.shortDescription);
        uhrzeit.setText(element.zeiten);
        webseite.setText(element.webseite);
        rating.setProgress(element.rating);
        rating.setProgressBackgroundTintMode(PorterDuff.Mode.SRC_OVER);
        /*if(element.favorite == true){
            favorite.setNumStars(1);
        }else{
            favorite.setRating(0);
        }
        */
        // Return the completed view to render on screen
        return convertView;
    }
}
