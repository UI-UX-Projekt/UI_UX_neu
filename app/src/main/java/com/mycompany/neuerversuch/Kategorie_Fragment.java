package com.mycompany.neuerversuch;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Kategorie_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Kategorie_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Kategorie_Fragment extends Fragment implements AbsListView.OnItemClickListener{
    private AbsListView mListView;


    private OnFragmentInteractionListener mListener;
    private KategorieAdapter mAdapter;

    private static MainActivity activity;

    public static Kategorie_Fragment newInstance(MainActivity act) {
        Kategorie_Fragment fragment = new Kategorie_Fragment();
        activity=act;
        return fragment;
    }

    public Kategorie_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         List<Kategorie> items = new ArrayList<Kategorie>();
        items.add(Kategorie.ESSEN);
        items.add(Kategorie.KULTUR);
        items.add(Kategorie.MESSE);
        items.add(Kategorie.MUSIK);
        items.add(Kategorie.NATUR);
        items.add(Kategorie.PARTY);
        items.add(Kategorie.SPORT);


        mAdapter = new KategorieAdapter(getActivity(),  items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.startseite_fragment_item, container, false);
        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EventList eventList=EventList.getAllEvents();
        switch(position){
            case 0:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.ESSEN)),getString(R.string.title_kategorie1));
                break;
            case 1:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.KULTUR)),getString(R.string.title_kategorie2));
                break;
            case 2:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.MESSE)),getString(R.string.title_kategorie3));
                break;
            case 3:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.MUSIK)),getString(R.string.title_kategorie4));
                break;
            case 4:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.NATUR)),getString(R.string.title_kategorie5));
                break;
            case 5:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.PARTY)),getString(R.string.title_kategorie6));
                break;
            case 6:
                activity.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(Kategorie.SPORT)),getString(R.string.title_kategorie7));
                break;
        }

    }

    public void setTitle(CharSequence title){
        activity.getActionBar().setTitle(title);
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
