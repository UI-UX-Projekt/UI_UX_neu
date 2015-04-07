package com.mycompany.neuerversuch;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class Zentrale_Filterung_Fragment extends Fragment implements AbsListView.OnItemClickListener {

    private OnFragmentInteractionListener mListener;
    //EventList for central filtering
    private  EventList eventList;
    private AbsListView mListView;
    private EventAdapter mAdapter;
    private MainNavigationManager mainNavigationManager;

    public static Zentrale_Filterung_Fragment newInstance(EventList eventList,MainNavigationManager mainNavigationManager) {
        Zentrale_Filterung_Fragment fragment = new Zentrale_Filterung_Fragment();
        fragment.mainNavigationManager = mainNavigationManager;
        fragment.setEventList(eventList);
        return fragment;
    }

    public Zentrale_Filterung_Fragment() {

    }

    public void setEventList(EventList eventList){
        this.eventList=eventList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAdapter=new EventAdapter(getActivity(),eventList);

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

         Event event = mAdapter.getItem(position);
         mainNavigationManager.navigate( Detail_Fragment.newInstance(event),event.getTitel().toString());

    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String id);
    }

    public EventList getEventList() {
        return eventList;
    }

}
