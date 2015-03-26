package com.mycompany.neuerversuch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GruppeAdapter extends ArrayAdapter<Gruppe> {
   private Context context;
    public GruppeAdapter(Context context) {
        super(context, android.R.layout.simple_spinner_item, Gruppe.getAll());
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_spinner_item,parent,false);

        //get icon & text Views
        TextView txtView = (TextView) rowView.findViewById( android.R.id.text1);

        //set text and icon
        txtView.setText(Gruppe.getAll().get(position).getDisplayText());

        return rowView;

    }
}
