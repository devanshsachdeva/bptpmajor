package com.example.sachd.mixed;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    FloatingActionButton Fab_toy , Fab_mail , Fab_call;
    Animation Fabopen,Fabclose,Fabcl,Fabancl;
    boolean isopen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fab_toy =(FloatingActionButton)findViewById(R.id.fab_toys);
        Fab_mail =(FloatingActionButton)findViewById(R.id.fab_email);
        Fab_call =(FloatingActionButton)findViewById(R.id.fab_phone);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        Fabclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        Fabcl = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        Fabancl = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_account_balance_white_24dp);

      //  tabLayout.getTabAt(1).setIcon(R.drawable.ic_update_white_24dp);

        tabLayout.getTabAt(1).setIcon(R.drawable.ic_info_outline_white_24dp);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fab_toy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isopen)
                {
                    Fab_call.startAnimation(Fabclose);
                    Fab_mail.startAnimation(Fabclose);
                    Fab_toy.startAnimation(Fabancl);
                    Fab_call.setClickable(false);
                    Fab_mail.setClickable(false);
                    isopen = false;
                }

                else
                {
                    Fab_call.startAnimation(Fabopen);
                    Fab_mail.startAnimation(Fabopen);
                    Fab_toy.startAnimation(Fabcl);
                    Fab_call.setClickable(true);
                    Fab_mail.setClickable(true);
                    isopen = true;
                }
            }
        });

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
        if (id == R.id.settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

              // @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.about) {

        } else if (id == R.id.projects) {

        } else if (id == R.id.updates) {

        } else if (id == R.id.notices) {

        } else if (id == R.id.feedback) {

        }else if (id == R.id.contact) {

            Intent intent = new Intent(this,Contactus.class);
            startActivity(intent);

        } else if (id == R.id.ehs) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0 :
                    Tab1 tab1 = new Tab1();
                    return tab1;
                case 1 :
                    Tab2 tab2 = new Tab2();
                    return tab2;


                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }
}
