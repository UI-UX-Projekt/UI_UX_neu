package com.mycompany.neuerversuch;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.animation.Animation;

public class HistoricalFragment {

    private final Fragment originalFragment;
    private final String title;

    public HistoricalFragment(Fragment originalFragment,String title){
        this.originalFragment = originalFragment;
        this.title = title;

    }

    public Fragment getOriginalFragment() {
        return originalFragment;
    }

    public String getTitle() {
        return title;
    }

}
