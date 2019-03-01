package com.annushkaproject.programmerscalculator.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.annushkaproject.programmerscalculator.fragments.ProgrammerFragment;
import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.fragments.StandardFragment;
import com.annushkaproject.programmerscalculator.fragments.ThemesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            //Open standard fragment when start the app for the first time.
            StandardFragment standardFragment = new StandardFragment();
            standardFragment.setupFragment(getPackageName());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, standardFragment).commit();
            navigationView.setCheckedItem(R.id.nav_standard_mode);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_standard_mode) {
            StandardFragment standardFragment = new StandardFragment();
            standardFragment.setupFragment(getPackageName());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, standardFragment).commit();
        } else if (id == R.id.nav_programmer_mode) {
            ProgrammerFragment programmerFragment = new ProgrammerFragment();
            programmerFragment.setupFragment(getPackageName());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, programmerFragment).commit();
        } else if (id == R.id.nav_themes) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThemesFragment()).commit();
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Share this app with friends!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_about) {
            Toast.makeText(this, "Developed for you by Annushka Project", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
