package com.jackshaw.moviecatalogueapi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    String film, tv;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menambahkan menu ke action bar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public void onComposeAction(MenuItem mi){
        Intent SettingIntent = new Intent(MainActivity.this, SettingLanguage.class);
        startActivity(SettingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_Layout);
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        film = getResources().getString(R.string.movies);
        tv = getResources().getString(R.string.tv_show);

        //tambahkan fragment
        pagerAdapter.AddFragment(new MoviesFragment(), film);
        pagerAdapter.AddFragment(new TVShowFragment(), tv);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
