package com.mycompany.neuerversuch;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;


import com.mycompany.neuerversuch.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class Detail_Fragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    private Event event;

    public static Detail_Fragment newInstance(Event event) {
        Detail_Fragment fragment = new Detail_Fragment();
        fragment.event = event;
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Detail_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details__event, container, false);

        TextView nameOfEvent = (TextView) view.findViewById(R.id.nameOfEvent);
        nameOfEvent.setText(event.getTitel());

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(event.getBild());

        TextView shortDescription = (TextView) view.findViewById(R.id.shortDescription);
        shortDescription.setText(event.getBeschreibung());

        TextView uhrzeit = (TextView) view.findViewById(R.id.uhrzeit);
        uhrzeit.setText(event.getUhrzeit());

        TextView webseite = (TextView) view.findViewById(R.id.webseite);
        webseite.setText(event.getWebseite());

        ProgressBar rating = (ProgressBar) view.findViewById(R.id.rating);
        rating.setProgress(event.getRanking());

        ToggleButton favorite = (ToggleButton) view.findViewById(R.id.favorite);
        favorite.setChecked(event.getIstFavorit());

        favorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                event.setIstFavorit(isChecked);
            }
        });

        TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
        textDescription.setText(event.getBeschreibung());//TODO: Lange Beschreibung verwenden?





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


    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
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
        public void onFragmentInteraction(String id);
    }

}
