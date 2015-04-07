package com.mycompany.neuerversuch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class NavigationAdapter extends ArrayAdapter<NavigationItem> {
    private final Context context;
    private final List<NavigationItem> listNavigation;

    public NavigationAdapter(Context context, List<NavigationItem> listNavigation) {
        super(context,R.layout.navigation_list_item, listNavigation);
        this.context=context;
        this.listNavigation=listNavigation;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.navigation_list_item,parent,false);

        //get icon & text Views
        ImageView imgView = (ImageView) rowView.findViewById(R.id.kategorie_icon);
        TextView txtView = (TextView)   rowView.findViewById(R.id.kategorie_title);

        //set text and icon
        imgView.setImageResource(listNavigation.get(position).getIcon());
        txtView.setText(listNavigation.get(position).getText());

        return rowView;

    }
}
