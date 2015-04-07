package com.mycompany.neuerversuch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class KategorieAdapter extends ArrayAdapter<Kategorie> {
    private final Context context;
    private final List<Kategorie> listKategorie;

    public KategorieAdapter(Context context) {
        super(context,R.layout.kategorie_list_item, Kategorie.getList());
        this.context=context;
        listKategorie = Kategorie.getList();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.kategorie_list_item,parent,false);

        //get icon & text Views
        ImageView imgView = (ImageView) rowView.findViewById(R.id.kategorie_icon);
        TextView txtView = (TextView)   rowView.findViewById(R.id.kategorie_title);

        //set text and icon
        imgView.setImageResource(listKategorie.get(position).getIcon());
        txtView.setText(listKategorie.get(position).getText());

        return rowView;

    }


}
