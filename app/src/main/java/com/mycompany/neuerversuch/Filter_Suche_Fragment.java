package com.mycompany.neuerversuch;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class Filter_Suche_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Elemente der gui referenzieren
        EditText standort = (EditText) this.getActivity().findViewById(R.id.standort);
        EditText umkreis = (EditText) this.getActivity().findViewById(R.id.umkreis);
        EditText tageszeit = (EditText) this.getActivity().findViewById(R.id.tageszeit);
        EditText datum = (EditText) this.getActivity().findViewById(R.id.datum);
        Spinner begleitung = (Spinner) this.getActivity().findViewById(R.id.spinnerBegleitung); //alleine, freunde, partner, familie
        EditText minPreis = (EditText) this.getActivity().findViewById(R.id.minPreis);
        EditText maxPreis = (EditText) this.getActivity().findViewById(R.id.maxPreis);
        Button btnClear = (Button) this.getActivity().findViewById(R.id.btnClear);
        Button btnStart = (Button) this.getActivity().findViewById(R.id.btnStart);

        //listener auf buttons hinzufügen
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillElements(v);


            }
        });

    }
    public static void fillElements(View v){
        //Referenzieren
        EditText standort = (EditText) v.findViewById(R.id.standort);
        EditText umkreis = (EditText) v.findViewById(R.id.umkreis);
        EditText tageszeit = (EditText) v.findViewById(R.id.tageszeit);
        EditText datum = (EditText) v.findViewById(R.id.datum);
        Spinner begleitung = (Spinner) v.findViewById(R.id.spinnerBegleitung);
        EditText minPreis = (EditText) v.findViewById(R.id.minPreis);
        EditText maxPreis = (EditText) v.findViewById(R.id.maxPreis);
        //StandortDaten auslesen
        //standort des systems auslesen
        LocationManager locationManager = (LocationManager)   v.getContext().getSystemService(Context.LOCATION_SERVICE);
        //Adresse auslesen
        Geocoder gc = new Geocoder(v.getContext());
        List<Address> addressList=null;
        try {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            addressList = gc.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            //handle exception
        }
        Address address = addressList.get(0);
        String plz = address.getPostalCode();
        //aktuelle Zeit + Datum auslesen
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        //elemente der gui mit default-Text füllen
        standort.setText(plz);
        umkreis.setText("5");
        tageszeit.setText("00:00");
        datum.setText("01.01.2015");

        minPreis.setText("");
        maxPreis.setText("");
        String[] items = new String[4];
        items[0] ="Alleine";
        items[1] ="Freunde";
        items[2] ="Familie";
        items[3] ="Partner";
        ArrayAdapter<String> itemsAdapter =  new ArrayAdapter<String>(v.getContext(), R.layout.support_simple_spinner_dropdown_item, items);
        begleitung.setAdapter(itemsAdapter);
    }
    public static Filter_Suche_Fragment newInstance() {
        Filter_Suche_Fragment fragment = new Filter_Suche_Fragment();
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
