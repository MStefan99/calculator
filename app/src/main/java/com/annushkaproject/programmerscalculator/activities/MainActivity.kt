package com.annushkaproject.programmerscalculator.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.annushkaproject.programmerscalculator.R
import com.annushkaproject.programmerscalculator.fragments.ProgrammerFragment
import com.annushkaproject.programmerscalculator.fragments.StandardFragment
import com.annushkaproject.programmerscalculator.fragments.ThemesFragment
import com.annushkaproject.programmerscalculator.model.ThemeSetting.Companion.getThemeStyleByThemeSetting
import com.annushkaproject.programmerscalculator.utils.SharedPreferencesUtil
import io.realm.Realm

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        val prefUtil = SharedPreferencesUtil(this)
        setTheme(getThemeStyleByThemeSetting(prefUtil.loadThemeSetting()))
        super.onCreate(savedInstanceState)
        Realm.init(this)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View?>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val drawer = findViewById<View?>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<View?>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        //        if (savedInstanceState == null) {
//            //Open standard fragment when start the app for the first time.
//            StandardFragment standardFragment = new StandardFragment();
//            standardFragment.setupFragment(getPackageName());
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, standardFragment).commit();
//            navigationView.setCheckedItem(R.id.nav_standard_mode);
//        }
        if (savedInstanceState == null) {
            //Open programmer fragment when start the app for the first time.
            val programmer_fragment = ProgrammerFragment()
            programmer_fragment.setupFragment(packageName)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, programmer_fragment).commit()
            navigationView.setCheckedItem(R.id.nav_programmer_mode)
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<View?>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem?): Boolean {
        val id = item.getItemId()
        if (id == R.id.nav_standard_mode) {
            val standardFragment = StandardFragment()
            standardFragment.setupFragment(packageName)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, standardFragment).commit()
        } else if (id == R.id.nav_programmer_mode) {
            val programmerFragment = ProgrammerFragment()
            programmerFragment.setupFragment(packageName)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, programmerFragment).commit()
        } else if (id == R.id.nav_themes) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ThemesFragment()).commit()
        } else if (id == R.id.nav_share) {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "text/plain"
            val shareBody = getString(R.string.share_website)
            val shareSub = getString(R.string.share_subject)
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(myIntent, getString(R.string.share_using)))
        } else if (id == R.id.nav_about) {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setCancelable(true)
            builder.setTitle(getString(R.string.about_title))
            builder.setMessage(getString(R.string.about_program))
            builder.setPositiveButton(getString(R.string.button_ok)) { dialog, which -> }
            builder.show()
        }
        val drawer = findViewById<View?>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}