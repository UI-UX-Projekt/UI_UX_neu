package com.mycompany.neuerversuch;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AbsListView;
import android.widget.SearchView;

import static com.mycompany.neuerversuch.R.*;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
                   Filter_Suche_Fragment.OnFragmentInteractionListener,
                   EmpfehlungenFragment.OnFragmentInteractionListener,
                   Detail_Fragment.OnFragmentInteractionListener,
                   Zentrale_Filterung_Fragment.OnFragmentInteractionListener,
                   Kategorie_Fragment.OnFragmentInteractionListener,
                   Startseite_Fragment.OnFragmentInteractionListener,
                   Faq_Fragment.OnFragmentInteractionListener,
                   Optionen_Fragment.OnFragmentInteractionListener,
                   Element_Preview.OnFragmentInteractionListener {


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

    public void navigate( Fragment fragment, String title){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(id.container,fragment)
                .commit();
        setTitle(title);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        EventList eventList = EventList.getAllEvents();
        switch (position) {
            case 0:
                navigate(Startseite_Fragment.newInstance("test1", "test2"),getString(string.title_section1));
                break;
            case 1:
                navigate( Filter_Suche_Fragment.newInstance("test1", "test2"),getString(string.title_section2));
                break;
            case 2:
                navigate(Kategorie_Fragment.newInstance( this),getString(string.title_section3));
                break;
            case 3:
                navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByIstFavorit()),getString(string.title_section4));
                break;
            case 4:
                navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByIstEmpfehlung()),getString(string.title_section5));
                break;
            case 5:
                navigate(Faq_Fragment.newInstance("test1", "test2"),getString(string.title_section6));
                break;
            case 6:
               navigate(Optionen_Fragment.newInstance("test1", "test2"),getString(string.title_section7));
                break;

            default:
                navigate(Startseite_Fragment.newInstance("test1", "test2"),getString(string.title_section1));
                break;
        }

    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);

    }

    public void setTitle(CharSequence title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
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
        if (searchItem != null) {
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
        private static final String ARG_SECTION_NUMBER = "section_number";


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
        }


    }
}
