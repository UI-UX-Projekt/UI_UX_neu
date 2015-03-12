package com.mycompany.neuerversuch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import static com.mycompany.neuerversuch.R.*;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
                   Pers_Suche_Fragment.OnFragmentInteractionListener,
                   AnmeldenFragment.OnFragmentInteractionListener,
                   EmpfehlungenFragment.OnFragmentInteractionListener,
                   ErgebnisFragment.OnFragmentInteractionListener,
                   FavoritenFragment.OnFragmentInteractionListener,
                   KategorieFragment.OnFragmentInteractionListener,
                   StartseiteFragment.OnFragmentInteractionListener{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private AbsListView mDrawerList;
    private android.support.v4.widget.DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                id.navigation_drawer,
                (DrawerLayout) findViewById(id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(position){
            case 0:
                    fragmentManager.beginTransaction()
                            .replace(id.container, StartseiteFragment.newInstance("test1","test2"))
                            .commit();
                    break;


            case 1:
                    fragmentManager.beginTransaction()
                            .replace(id.container, Pers_Suche_Fragment.newInstance("test1","test2"))
                            .commit();
                            break;
            case 2:
                    fragmentManager.beginTransaction()
                            .replace(id.container, KategorieFragment.newInstance("test1","test2"))
                            .commit();
                    break;
            case 3:
                fragmentManager.beginTransaction()
                        .replace(id.container, FavoritenFragment.newInstance("test1","test2"))
                        .commit();
                break;
            case 4:
                fragmentManager.beginTransaction()
                        .replace(id.container, EmpfehlungenFragment.newInstance("test1","test2"))
                        .commit();
                break;
            case 5:
                fragmentManager.beginTransaction()
                        .replace(id.container, AnmeldenFragment.newInstance("test1","test2"))
                        .commit();
                break;
            default:
                fragmentManager.beginTransaction()
                        .replace(id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
                break;
        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(string.title_section1);
                break;
            case 2:
                mTitle = getString(string.title_section2);
                break;
            case 3:
                mTitle = getString(string.title_section3);
                break;
            case 4:
                mTitle = getString(string.title_section4);
                break;
            case 5:
                mTitle = getString(string.title_section5);
                break;
            case 6:
                mTitle = getString(string.title_section6);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        MenuItem searchItem = menu.findItem(id.action_search);
        if(searchItem != null) {
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


            MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem menuItem) {
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    return true;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


 /*   public class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }


        private void selectItem(int position) {
            // Create a new fragment and specify the planet to show based on position
            android.app.Fragment fragment = new Pers_Suche_Fragment();
            Bundle args = new Bundle();
            //   args.putInt(Pers_Suche_Fragment.ARG_PLANET_NUMBER, position);
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

            // Highlight the selected item, update the title, and close the drawer
            mDrawerList.setItemChecked(position, true);
            setTitle("Suche");
            mDrawerLayout.closeDrawer(mDrawerList);
        }

         public void setTitle(CharSequence title) {
            mTitle = title;
            getActionBar().setTitle(mTitle);
        }
    }*/

}
