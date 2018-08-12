package org.aplusstudios.com.biologytrivia;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.aplusstudios.com.biologytrivia.adapters.LevelsRecyclerViewAdapter;
import org.aplusstudios.com.biologytrivia.custom.DividerDecorator;
import org.aplusstudios.com.biologytrivia.model.Level;

import java.util.Arrays;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-5160269550159038~2362790683");

        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "PG");

        AdRequest adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build();


        AdView adView = findViewById(R.id.adView_main_activity);
        if (adView == null) {
            Log.e("", "Null About Layout adView");
        }
        if (adView == null) {
            Log.e("", "Null About Layout adRequest");
        }
        if (adView != null) {
            adView.loadAd(adRequest);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerDecorator(getApplicationContext()));

        List<Level> trackList = Arrays.asList(
//                new Level(getResources().getString(R.string.track_one_title), getResources().getString(R.string.track_one_youtube_id), getResources().getString(R.string.track_one_description_two)),
                //new Level(getResources().getString(R.string.track_eleven_title),getResources().getString(R.string.track_eleven_youtube_id),getResources().getString(R.string.track_eleven_description))
        );

        LevelsRecyclerViewAdapter tracksRecyclerViewAdapter = new LevelsRecyclerViewAdapter(trackList);
        recyclerView.setAdapter(tracksRecyclerViewAdapter);

        //  startActivity( new Intent(MainActivity.this,GoogleAuthActivity.class));
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile_menu:
                startActivity(new Intent(MainActivity.this, QuestionActivity.class));
                break;
        }

        return true;
    }

}


