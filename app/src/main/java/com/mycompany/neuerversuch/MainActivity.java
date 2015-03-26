package com.mycompany.neuerversuch;

import android.net.Uri;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.AbsListView;
import android.widget.SearchView;

import static com.mycompany.neuerversuch.R.*;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
                   Filter_Suche_Fragment.OnFragmentInteractionListener,
                   Detail_Fragment.OnFragmentInteractionListener,
                   Zentrale_Filterung_Fragment.OnFragmentInteractionListener,
                   Kategorie_Fragment.OnFragmentInteractionListener,
                   Startseite_Fragment.OnFragmentInteractionListener,
                   Faq_Fragment.OnFragmentInteractionListener,
                   Optionen_Fragment.OnFragmentInteractionListener
                   {


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
    private Fragment fragmentBeforeSearch;
    private Zentrale_Filterung_Fragment searchFragment;
    private MainNavigationManager mainNavigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainNavigationManager = new MainNavigationManager(this);

        setContentView(layout.activity_main);



        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(id.navigation_drawer);
           mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                id.navigation_drawer,
                (DrawerLayout) findViewById(id.drawer_layout));
    }

    public Fragment getActiveFragment(){
        return getSupportFragmentManager().findFragmentById(id.container);
    }

    @Override
    public void onBackPressed() {
        mainNavigationManager.back();
    }

   @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        EventList eventList = EventList.getAllEvents();
        switch (position) {
            case 0:
                mainNavigationManager.navigate(Zentrale_Filterung_Fragment.newInstance(eventList,mainNavigationManager),getString(string.title_section1));
                break;
            case 1:
                mainNavigationManager.navigate(Filter_Suche_Fragment.newInstance(mainNavigationManager), getString(string.title_section2));
                break;
            case 2:
                mainNavigationManager.navigate(Kategorie_Fragment.newInstance(mainNavigationManager), getString(string.title_section3));
                break;
            case 3:
                mainNavigationManager.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByIstFavorit(),mainNavigationManager), getString(string.title_section4));
                break;
            case 4:
                mainNavigationManager.navigate(Zentrale_Filterung_Fragment.newInstance(eventList.filteredByIstEmpfehlung(),mainNavigationManager), getString(string.title_section5));
                break;
            case 5:
                mainNavigationManager.navigate(Optionen_Fragment.newInstance("test1", "test2"), getString(string.title_section7));
                break;
            case 6:
                mainNavigationManager.navigate(Faq_Fragment.newInstance("test1", "test2"), getString(string.title_section6));
                break;
            default:
                mainNavigationManager.navigate(Startseite_Fragment.newInstance("test1", "test2"), getString(string.title_section1));
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
            MenuItem searchItem = menu.findItem(id.action_search);
            if (searchItem != null) {
                final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
                searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                    @Override
                    public boolean onClose() {
                       return onSearchClose();
                    }
                });
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return onSearch(query);
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return onSearch(newText);
                    }
                });
                MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionExpand(MenuItem menuItem) {return true;}

                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem menuItem) {return true;}
                });
            }


            return true;
        }
        MenuItem searchItem = menu.findItem(id.action_search);
        if (searchItem != null) {
            final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem menuItem) {return true;}

                @Override
                public boolean onMenuItemActionCollapse(MenuItem menuItem) {return true;}
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    public boolean onSearch(String searchString){

        if(searchFragment == null){
            fragmentBeforeSearch = getActiveFragment();
        }
        EventList eventList = EventList.getAllEvents();
        searchFragment = Zentrale_Filterung_Fragment.newInstance(eventList.filteredByText(searchString),mainNavigationManager);
        mainNavigationManager.navigateWithoutHistory(searchFragment, getSupportActionBar().getTitle().toString());

        return eventList.size() > 0;
    }
    public boolean onSearchClose(){
        searchFragment = null;
        if(fragmentBeforeSearch != null){
            mainNavigationManager.navigateWithoutHistory(fragmentBeforeSearch, getSupportActionBar().getTitle().toString());
        }else {
            mainNavigationManager.navigateWithoutHistory(Startseite_Fragment.newInstance("test1", "test2"), getString(string.title_section1));
        }
        return false;
    }

}
