package com.mycompany.neuerversuch;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import java.util.LinkedList;



public class MainNavigationManager {

    private FragmentManager fragmentManager;
    private MainActivity activity;
    private LinkedList<HistoricalFragment> historyList = new LinkedList<HistoricalFragment>();

    public MainNavigationManager(MainActivity activity){
        this.activity = activity;
        this.fragmentManager = activity.getSupportFragmentManager();
    }

    public void navigate( Fragment fragment,String title){
        _navigate(fragment, title,  true);
    }

    public void navigateWithoutHistory( Fragment fragment,String title){
        _navigate(fragment,title, false);

    }

    private void _navigate(Fragment fragment, String title ,boolean history){
        fragmentManager.beginTransaction()
                .replace(R.id.container,fragment)
                .commit();
        activity.setTitle(title);
        if(history){
            historyList.add(new HistoricalFragment(fragment,title));
        }
    }


    public void back() {
        if(historyList.size() > 1){
            HistoricalFragment active = historyList.removeLast();
            HistoricalFragment last = historyList.getLast();

            _navigate(last.getOriginalFragment(), last.getTitle(), false);
        }else{
            activity.finish();
        }
    }

    public void confirmMessage() {
        DialogFragment newFragment = new MessageDialog();
        newFragment.show(activity.getSupportFragmentManager(), "info");
    }

 }
