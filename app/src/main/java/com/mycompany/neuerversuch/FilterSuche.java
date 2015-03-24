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
import android.app.Fragment;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilterSuche.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilterSuche#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterSuche extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilterSuche.
     */
    // TODO: Rename and change types and number of parameters


    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * {@link #setRetainInstance(boolean)} to retain their instance,
     * as this callback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after {@link #onCreateView}
     * and before {@link #onViewStateRestored(android.os.Bundle)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
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
        //standort des systems auslesen (de.wikibooks.org/wiki/Googles_Android/_Positionsbestimmung
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
        //tageszeit.setText(String.valueOf(date.getHours()) + ":" String.valueOf(date.getMinutes()));
        //datum.setText(""+ date.getDay() + "." + String.valueOf(date.getMonth() + 1) + String.valueOf(date.getYear()));
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
    public static FilterSuche newInstance(String param1, String param2) {
        FilterSuche fragment = new FilterSuche();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FilterSuche() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_suche, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
