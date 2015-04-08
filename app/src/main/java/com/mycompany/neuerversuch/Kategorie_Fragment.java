package com.mycompany.neuerversuch;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;



public class Kategorie_Fragment extends Fragment implements AbsListView.OnItemClickListener{
    private AbsListView mListView;


    private OnFragmentInteractionListener mListener;
    private KategorieAdapter mAdapter;

    private MainNavigationManager mainNavigationManager;

    public static Kategorie_Fragment newInstance( MainNavigationManager mainNavigationManager) {
        Kategorie_Fragment fragment = new Kategorie_Fragment();
        fragment.mainNavigationManager = mainNavigationManager;
        return fragment;
    }

    public Kategorie_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mAdapter = new KategorieAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.zentrale_filterung_fragment_list, container, false);

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
        Kategorie selectedKategorie = Kategorie.getList().get(position);
        mainNavigationManager.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByKategorie(selectedKategorie),mainNavigationManager), selectedKategorie.getText());
    }



    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
