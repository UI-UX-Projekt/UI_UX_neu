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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;



public class Detail_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private AbsListView mListView;
    private Event event;

    public static Detail_Fragment newInstance(Event event) {
        Detail_Fragment fragment = new Detail_Fragment();
        fragment.event = event;
        return fragment;
    }

    public Detail_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        final ProgressBar rating = (ProgressBar) view.findViewById(R.id.rating);
        rating.setProgress(event.getRanking());

        ToggleButton favorite = (ToggleButton) view.findViewById(R.id.favorite);
        favorite.setChecked(event.getIstFavorit());

        final Button rating_up = (Button) view.findViewById(R.id.DaumenHoch);
        final Button rating_down = (Button) view.findViewById(R.id.DaumenRunter);
        rating_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rating_up.isActivated()){
                    rating_up.setActivated(false);
                    rating_up.setBackgroundResource(R.mipmap.ic_thumps_up);
                    rating_down.setBackgroundResource(R.mipmap.ic_thumps_down);
                    event.setLikes(event.getLikes()-1);
                    rating.setProgress(event.getRanking());
                }else{
                    if(rating_down.isActivated()){
                        rating_down.setActivated(false);
                        rating_down.setBackgroundResource(R.mipmap.ic_thumps_down);
                        event.setDislikes(event.getDislikes()-1);
                    }
                    rating_up.setActivated(true);
                    rating_up.setBackgroundResource(R.drawable.ic_thumps_up_pressed);
                    event.setLikes(event.getLikes()+1);
                    rating.setProgress(event.getRanking());

                }
            }
        });


        rating_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rating_down.isActivated()){
                    rating_down.setActivated(false);
                    rating_down.setBackgroundResource(R.mipmap.ic_thumps_down);
                    event.setDislikes(event.getDislikes()-1);
                    rating.setProgress(event.getRanking());
                }else{
                    if(rating_up.isActivated()){
                        rating_up.setActivated(false);
                        rating_up.setBackgroundResource(R.mipmap.ic_thumps_up);
                        event.setLikes(event.getLikes()-1);
                    }
                    rating_down.setActivated(true);
                    rating_down.setBackgroundResource(R.drawable.ic_thumps_down_pressed);
                    event.setDislikes(event.getDislikes()+1);
                    rating.setProgress(event.getRanking());
                }
            }
        });

        favorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                event.setIstFavorit(isChecked);
            }
        });

        TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
        textDescription.setText(event.getDetailBeschreibung());
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



    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }


    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(String id);
    }

}
