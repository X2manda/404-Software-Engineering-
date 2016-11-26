package com.berstek.uhacpayso.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.fragments.AccountFragment;
import com.berstek.uhacpayso.fragments.AddTransactionFragment;
import com.berstek.uhacpayso.fragments.CashManagementFragment;
import com.berstek.uhacpayso.fragments.HistoryFragment;
import com.berstek.uhacpayso.fragments.NoCycleFragment;
import com.berstek.uhacpayso.fragments.StatsFragment;
import com.berstek.uhacpayso.model.AppSettings;
import com.berstek.uhacpayso.model.CycleBuilder;
import com.berstek.uhacpayso.model.CycleData;
import com.berstek.uhacpayso.model.DatabaseBuilder;
import com.berstek.uhacpayso.utils.CycleUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseBuilder databaseBuilder = new DatabaseBuilder(this);
        AppSettings appSettings = new AppSettings(this);

        launch();
    }

    @Override
    public void onBackPressed() {
        AddTransactionFragment fragment = (AddTransactionFragment)getFragmentManager().findFragmentByTag("TRANSACTION");
        if(fragment != null && fragment.isVisible()) {
            cashManagementFragment.getFab().setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fn = getFragmentManager();
        FragmentTransaction ft = fn.beginTransaction();

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            CashManagementFragment cashManagementFragment = new CashManagementFragment();
            ft.replace(R.id.fragment_main_fragment, cashManagementFragment);
            ft.commit();
        }
        else if (id == R.id.nav_account) {
            Fragment accountFragment = new AccountFragment();
            ft.replace(R.id.fragment_main_fragment, accountFragment);
            ft.commit();
        }
        else if (id == R.id.nav_stats) {
            Fragment statsFragment = new StatsFragment();
            ft.replace(R.id.fragment_main_fragment, statsFragment);
            ft.commit();
        }
        else if (id == R.id.nav_history) {
            Fragment historyFragment = new HistoryFragment();
            ft.replace(R.id.fragment_main_fragment, historyFragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private CashManagementFragment cashManagementFragment;
    private void launch() {
        //Create database and necessary tables if non-existent.
        DatabaseBuilder databaseBuild = new DatabaseBuilder(this);
        //Kapag 0, ibig sabihin, hindi pa nia tapos ung setup. Mareredirect sya sa Initial Setup Activity
        AppSettings appSettings = new AppSettings(this);
        if(appSettings.getSetupStatus() == 0) {
            Intent intent = new Intent(this, WelcomePagerActivity.class);
            startActivity(intent);
        }
        else {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CycleData data = new CycleData(this);
            if(data.hasActiveCycle()) {
                cashManagementFragment = new CashManagementFragment();
                fragmentTransaction.replace(R.id.fragment_main_fragment, cashManagementFragment);
                fragmentTransaction.commit();

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                drawer.setDrawerListener(toggle);
                toggle.syncState();

                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);

            } else {
                //This code segment is reached if user selects to start a cycle at a later date and there is no active cycle
                NoCycleFragment noCycleFragment = new NoCycleFragment();
                fragmentTransaction.replace(R.id.fragment_main_fragment, noCycleFragment);
                fragmentTransaction.commit();
            }
        }
        if (CycleUtils.getCurrentDay().equals(appSettings.getCycleStart()) && appSettings.getSetupStatus() == 1){
            try {
                CycleBuilder cycleBuilder = new CycleBuilder(this);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(null, "DATABASE ALREADY EXISTS");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        launch();

    }
}
