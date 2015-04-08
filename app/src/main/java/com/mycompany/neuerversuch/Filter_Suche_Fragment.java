package com.mycompany.neuerversuch;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class Filter_Suche_Fragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    private OnFragmentInteractionListener mListener;
    private MainNavigationManager mainNavigationManager;
    private Spinner begleitung;
    private Button search;
    private Button clear;
    private ImageButton btn_datum;
    private Button btnMorgen;
    private Button btnMittag;
    private Button btnAbend;
    private Tageszeit tageszeit=Tageszeit.GANZTAGS;
    private TextView datum;
    private ImageButton btn_remove;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addSpinnerItems();

        final EditText standort = (EditText) this.getActivity().findViewById(R.id.standort_edit);
        datum = (TextView) this.getActivity().findViewById(R.id.datum_edit);
        final EditText minPreis = (EditText) this.getActivity().findViewById(R.id.min_preis);
        final EditText maxPreis = (EditText) this.getActivity().findViewById(R.id.max_preis);
        final CheckBox cbEssen =(CheckBox) this.getActivity().findViewById(R.id.check_essen);
        final CheckBox cbKultur =(CheckBox) this.getActivity().findViewById(R.id.check_kultur);
        final CheckBox cbMesse =(CheckBox) this.getActivity().findViewById(R.id.check_messe);
        final CheckBox cbMusik =(CheckBox) this.getActivity().findViewById(R.id.check_musik);
        final CheckBox cbNatur =(CheckBox) this.getActivity().findViewById(R.id.check_natur);
        final CheckBox cbParty =(CheckBox) this.getActivity().findViewById(R.id.check_party);
        final CheckBox cbSport =(CheckBox) this.getActivity().findViewById(R.id.check_sport);

        begleitung = (Spinner) this.getActivity().findViewById(R.id.spinnerBegleitung);
        begleitung.setOnItemSelectedListener(new SelectingItem());
        search=(Button)this.getActivity().findViewById(R.id.btnSearch);
        clear=(Button)this.getActivity().findViewById(R.id.btnClear);
        btnMorgen=(Button)this.getActivity().findViewById(R.id.btnMorgen);
        btnMittag=(Button)this.getActivity().findViewById(R.id.btnMittag);
        btnAbend=(Button)this.getActivity().findViewById(R.id.btnAbend);
        btn_datum=(ImageButton)this.getActivity().findViewById(R.id.button_datum);
        btn_remove=(ImageButton)this.getActivity().findViewById(R.id.button_remove);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventList eventList = EventList.getAllEvents();
                List<Kategorie> listKategorie = new ArrayList<Kategorie>();
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

                if(listKategorie.size()>0) {
                    eventList=eventList.filteredByKategorie(listKategorie);
                }

                if(!standort.getText().toString().equals("")){
                    eventList=eventList.filteredByOrt(standort.getText().toString());
                }

                if(!datum.getText().toString().equals("")){
                    eventList=eventList.filteredByDatum(datum.getText().toString());
                }

                if(tageszeit != Tageszeit.GANZTAGS){
                    eventList=eventList.filteredByTageszeit(tageszeit);
                }

                if(!(minPreis.getText().toString().equals("")&& maxPreis.getText().toString().equals(""))){
                    double preisuntergrenze;
                    double preisobergrenze;
                    if(minPreis.getText().toString().equals("")){
                        preisuntergrenze=0;
                    }else {
                        preisuntergrenze=Double.parseDouble(minPreis.getText().toString());
                    }

                    if(maxPreis.getText().toString().equals("")){
                        preisobergrenze= Double.MAX_VALUE;
                    }else{
                        preisobergrenze=Double.parseDouble(maxPreis.getText().toString());
                    }


                    eventList=eventList.filteredByPreis(preisuntergrenze,preisobergrenze);

                }
                if(begleitung.getSelectedItemPosition() > 0){
                    Gruppe gruppe = Gruppe.getAll().get(begleitung.getSelectedItemPosition());
                    eventList=eventList.filteredByGruppe(gruppe);
                }
                if(eventList.size()<=0){
                    mainNavigationManager.confirmMessage();
                    clear.callOnClick();
                }else {
                    mainNavigationManager.navigate(Zentrale_Filterung_Fragment.newInstance(eventList, mainNavigationManager), getString(R.string.filter_Suche));
                }
            }

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
                tageszeit = Tageszeit.GANZTAGS;
                updateTageszeitButtons();
                btn_remove.setVisibility(View.INVISIBLE);
            }
        });
        final Filter_Suche_Fragment that=this;
        btnMorgen.setOnClickListener(new TageszeitClickListener(Tageszeit.MORGENS));
        btnMittag.setOnClickListener(new TageszeitClickListener(Tageszeit.MITTAGS));
        btnAbend.setOnClickListener(new TageszeitClickListener(Tageszeit.ABENDS));
        btn_datum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar act_date = Calendar.getInstance();
                DatePickerDialog datePickerDialog= new DatePickerDialog(getActivity(),that,act_date.get(Calendar.YEAR),act_date.get(Calendar.MONTH),act_date.get(Calendar.DAY_OF_MONTH) );
                datePickerDialog.show();
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datum.setText("");
                btn_remove.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void updateTageszeitButtons(){
        btnMorgen.setActivated(tageszeit == Tageszeit.MORGENS);
        btnMittag.setActivated(tageszeit == Tageszeit.MITTAGS);
        btnAbend.setActivated(tageszeit == Tageszeit.ABENDS);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        int month=monthOfYear +1;
        datum.setText(dayOfMonth + "." + month + "." + year);
        btn_remove.setVisibility(View.VISIBLE);
    }

    public class TageszeitClickListener implements View.OnClickListener{
        private Tageszeit tageszeitOfListener;
        public TageszeitClickListener(Tageszeit tageszeit){
            tageszeitOfListener = tageszeit;
        }
        @Override
        public void onClick(View v) {
            if(tageszeit == tageszeitOfListener) {
                tageszeit = Tageszeit.GANZTAGS;
            }else{
                tageszeit = tageszeitOfListener;
            }
            updateTageszeitButtons();
        }
    }

    public void addSpinnerItems(){
        begleitung = (Spinner) this.getActivity().findViewById(R.id.spinnerBegleitung);
        GruppeAdapter dataAdapter = new GruppeAdapter(getActivity());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        begleitung.setAdapter(dataAdapter);

    }

    public static Filter_Suche_Fragment newInstance(MainNavigationManager mainNavigationManager) {
        Filter_Suche_Fragment fragment = new Filter_Suche_Fragment();
        fragment.mainNavigationManager = mainNavigationManager;
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
