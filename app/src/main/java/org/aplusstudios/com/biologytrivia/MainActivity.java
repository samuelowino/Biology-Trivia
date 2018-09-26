package org.aplusstudios.com.biologytrivia;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import org.aplusstudios.com.biologytrivia.adapters.LevelsRecyclerViewAdapter;
import org.aplusstudios.com.biologytrivia.model.Answer;
import org.aplusstudios.com.biologytrivia.model.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private InterstitialAd mInterstitialAd;
    private GridLayoutManager gridLayoutManager;
    private Typeface typeface;
    private RewardedVideoAd rewardedVideoAd;
    private AdRequest adRequest;

    private TextView free_coins_textview;
    private ImageView free_coins_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        AssetManager am = getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "freedom.ttf"));
        free_coins_imageView = findViewById(R.id.reward_video_image_view);
        free_coins_textview = findViewById(R.id.free_coins_textview);

       // setTypeface(typeface);


        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-5160269550159038~4440780762");

        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "PG");

        adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build();

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {

            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });


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

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        List<Level> trackList = Arrays.asList(
                new Level(1, true, true, getResources().getString(R.string.level1)),
                new Level(2, true, false, getResources().getString(R.string.level2)),
                new Level(3, true, false, getResources().getString(R.string.app_name)),
                new Level(4, false, false, getResources().getString(R.string.app_name)),
                new Level(5, false, false, getResources().getString(R.string.app_name)),
                new Level(6, false, false, getResources().getString(R.string.app_name)),
                new Level(7, false, false, getResources().getString(R.string.app_name)),
                new Level(8, false, false, getResources().getString(R.string.app_name)),
                new Level(9, false, false, getResources().getString(R.string.app_name)),
                new Level(10, false, false, getResources().getString(R.string.app_name)),
                new Level(11, false, false, getResources().getString(R.string.app_name)),
                new Level(12, false, false, getResources().getString(R.string.app_name)),
                new Level(13, false, false, getResources().getString(R.string.app_name))

        );

        LevelsRecyclerViewAdapter tracksRecyclerViewAdapter = new LevelsRecyclerViewAdapter(trackList,getApplicationContext());
        recyclerView.setAdapter(tracksRecyclerViewAdapter);

        free_coins_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRewardedVideoAd();
            }
        });

        free_coins_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRewardedVideoAd();
            }
        });

        //  startActivity( new Intent(MainActivity.this,GoogleAuthActivity.class));
    }

    private void loadRewardedVideoAd() {

        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewarded(RewardItem reward) {

                // Reward the user.
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdClosed() {
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int errorCode) {
            }

            @Override
            public void onRewardedVideoAdLoaded() {

                if (rewardedVideoAd.isLoaded()) {
                    rewardedVideoAd.show();
                }
            }

            @Override
            public void onRewardedVideoAdOpened() {
            }

            @Override
            public void onRewardedVideoStarted() {
            }

            @Override
            public void onRewardedVideoCompleted() {
            }
        });

        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                adRequest);

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
                List<Answer> answerList = new ArrayList<>();
                Answer answer = new Answer("This is an answer", 1, 1, false);
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                intent.putExtra("question_text", "This is a question");
                intent.putExtra("question_id", "1");
                startActivity(intent);
                break;
        }

        return true;
    }

}


