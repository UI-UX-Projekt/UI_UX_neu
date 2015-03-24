package com.mycompany.neuerversuch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by D060610 on 22.03.2015.
 */
public class EventAdapter extends ArrayAdapter<Event> {



        public EventAdapter(Context context, EventList eventList ) {
                super(context, 0, eventList);
                }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                // Get the data item for this position
                final Event event = getItem(position);
                // Check if an existing view is being reused, otherwise inflate the view
                if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_item, parent, false);
                }
                // Get Reference to Elements in View
                TextView name = (TextView) convertView.findViewById(R.id.nameOfEvent);
                ImageView iconEvent = (ImageView) convertView.findViewById(R.id.imageView);
                TextView shortDescription = (TextView) convertView.findViewById(R.id.shortDescription);
                TextView uhrzeit = (TextView) convertView.findViewById(R.id.uhrzeit);
                TextView webseite = (TextView) convertView.findViewById(R.id.webseite);
                ProgressBar rating = (ProgressBar) convertView.findViewById(R.id.rating);
                ToggleButton favorite = (ToggleButton) convertView.findViewById(R.id.favorite);

                // Populate the data into the template view using the data object
                name.setText(event.getTitel());
                iconEvent.setImageResource(event.getBild());
                shortDescription.setText(event.getBeschreibung());
                uhrzeit.setText(event.getDatum());
                webseite.setText(event.getWebseite());
                rating.setProgress(event.getRanking());
                favorite.setChecked(event.getIstFavorit());

                favorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        event.setIstFavorit(isChecked);
                    }
                });

                // Return the completed view to render on screen
                return convertView;
        }
}
