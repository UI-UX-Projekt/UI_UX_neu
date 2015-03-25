package com.mycompany.neuerversuch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class Filter_Suche_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private static MainActivity activity;
    private Spinner begleitung;
    private Button search;
    private Button clear;
    private Button btnMorgen;
    private Button btnMittag;
    private Button btnAbend;
    private String tageszeit="";

    TextView textViewBegleitung;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addSpinnerItems();

        final EditText standort = (EditText) this.getActivity().findViewById(R.id.standort_edit);
        final EditText datum = (EditText) this.getActivity().findViewById(R.id.datum_edit);
        final EditText minPreis = (EditText) this.getActivity().findViewById(R.id.min_preis);
        final EditText maxPreis = (EditText) this.getActivity().findViewById(R.id.max_preis);
        final CheckBox cbEssen =(CheckBox) this.getActivity().findViewById(R.id.check_essen);
        final CheckBox cbKultur =(CheckBox) this.getActivity().findViewById(R.id.check_kultur);
        final CheckBox cbMesse =(CheckBox) this.getActivity().findViewById(R.id.check_messe);
        final CheckBox cbMusik =(CheckBox) this.getActivity().findViewById(R.id.check_musik);
        final CheckBox cbNatur =(CheckBox) this.getActivity().findViewById(R.id.check_natur);
        final CheckBox cbParty =(CheckBox) this.getActivity().findViewById(R.id.check_party);
        final CheckBox cbSport =(CheckBox) this.getActivity().findViewById(R.id.check_sport);


        Button btnClear = (Button) this.getActivity().findViewById(R.id.btnClear);

        begleitung = (Spinner) this.getActivity().findViewById(R.id.spinnerBegleitung);
        begleitung.setOnItemSelectedListener(new SelectingItem());

        search=(Button)this.getActivity().findViewById(R.id.btnSearch);
        clear=(Button)this.getActivity().findViewById(R.id.btnClear);
        btnMorgen=(Button)this.getActivity().findViewById(R.id.btnMorgen);
        btnMittag=(Button)this.getActivity().findViewById(R.id.btnMittag);
        btnAbend=(Button)this.getActivity().findViewById(R.id.btnAbend);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventList eventList = EventList.getAllEvents();
                List<Kategorie> listKategorie = null;
                if(cbEssen.isChecked()){
                    listKategorie.add(Kategorie.ESSEN);
                }

                if(cbKultur.isChecked()){
                    listKategorie.add(Kategorie.KULTUR);
                }

                if(cbMesse.isChecked()){
                    listKategorie.add(Kategorie.MESSE);
                }

                if(cbMusik.isChecked()){
                    listKategorie.add(Kategorie.MUSIK);
                }

                if(cbNatur.isChecked()){
                    listKategorie.add(Kategorie.NATUR);
                }

                if(cbParty.isChecked()){
                    listKategorie.add(Kategorie.PARTY);
                }

                if(cbSport.isChecked()){
                    listKategorie.add(Kategorie.SPORT);
                }

                if(listKategorie!=null) {
                    eventList.filteredByKategorie(listKategorie);
                }

                if(!standort.getText().toString().equals("")){
                    eventList.filteredByOrt(standort.getText().toString());
                }

                if(!datum.getText().toString().equals("")){
                    eventList.filteredByDatum(datum.getText().toString());
                }

                if(!tageszeit.equals("")){
                    eventList.filteredByTageszeit(tageszeit);
                }

                if(!(minPreis.getText().toString().equals("")&& maxPreis.getText().toString().equals(""))){
                    double preisuntergrenze=Double.parseDouble(minPreis.getText().toString());
                    double preisobergrenze=Double.parseDouble(maxPreis.getText().toString());
                    eventList.filteredByPreis(preisuntergrenze,preisobergrenze);

                }

                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList),getString(R.string.filter_Suche));   }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                standort.setText("");
                datum.setText("");
                minPreis.setText("");
                maxPreis.setText("");
                begleitung.setSelection(0);
                cbEssen.setChecked(false);
                cbKultur.setChecked(false);
                cbMesse.setChecked(false);
                cbMusik.setChecked(false);
                cbNatur.setChecked(false);
                cbParty.setChecked(false);
                cbSport.setChecked(false);
                btnMorgen.setActivated(false);
                btnMittag.setActivated(false);
                btnAbend.setActivated(false);
            }
        });

        btnMorgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tageszeit="morgens";
                btnMorgen.setActivated(true);
            }
        });

        btnMittag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tageszeit="mittags";
                btnMittag.setActivated(true);
            }
        });

        btnAbend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tageszeit="abends";
                btnAbend.setActivated(true);
            }
        });

    }

    public void addSpinnerItems(){
        begleitung = (Spinner) this.getActivity().findViewById(R.id.spinnerBegleitung);
        List<String> list = new ArrayList<String>();
        list.add("Bitte auswählen");
        list.add("Alleine");
        list.add("Familie");
        list.add("Freunde");
        list.add("Partner");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        begleitung.setAdapter(dataAdapter);

    }

    public void fillElements(View v){
        String[] dropdown = {"Alleine","Familie","Freunde","Partner"};
        Spinner begleitung = (Spinner) this.getActivity().findViewById(R.id.spinnerBegleitung);
        ArrayAdapter<String> itemsAdapter =  new ArrayAdapter<String>(v.getContext(), R.layout.support_simple_spinner_dropdown_item, dropdown);
        begleitung.setAdapter(itemsAdapter);
    }

    public static Filter_Suche_Fragment newInstance(MainActivity act) {
        Filter_Suche_Fragment fragment = new Filter_Suche_Fragment();
        activity=act;
        return fragment;
    }

    public Filter_Suche_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_suche, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
