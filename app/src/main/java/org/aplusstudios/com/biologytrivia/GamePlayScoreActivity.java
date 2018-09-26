package org.aplusstudios.com.biologytrivia;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class GamePlayScoreActivity extends AppCompatActivity {

    private ImageView doubleCoinsImageView;
    private TextView doubleCoinsTextView;
    private LinearLayout doubleCoinsLinearLayout;
    private TextView tapToContinueTextView;
    private ImageView gamePlayGraphicImageView;
    private TextView scoreLabelTextView;
    private TextView scoreCountTextView;
    private TextView numberOfKeysTextView;
    private TextView numberOfCoinsTextView;
    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play_score);

        doubleCoinsImageView = findViewById(R.id.doubleCoins_imageView);
        doubleCoinsTextView = findViewById(R.id.doubleCoins_textview);
        doubleCoinsLinearLayout = findViewById(R.id.double_coins_layout);
        tapToContinueTextView = findViewById(R.id.next_level_textview);
        gamePlayGraphicImageView = findViewById(R.id.game_play_summary_graphic);
        scoreCountTextView = findViewById(R.id.game_play_score_value);
        scoreLabelTextView = findViewById(R.id.game_play_score_label_textview);
        numberOfCoinsTextView = findViewById(R.id.game_play_coins_textview);
        numberOfKeysTextView = findViewById(R.id.game_play_keys_textview);

        tapToContinueTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    Log.e(getClass().getSimpleName(),"device is online");
                    loadInterstitial();
                }else{
                    Log.e(getClass().getSimpleName(),"device is offline");
                    startNextActivity();
                }            }
        });

        scoreLabelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    Log.e(getClass().getSimpleName(),"device is online");
                    loadInterstitial();
                }else{
                    Log.e(getClass().getSimpleName(),"device is offline");
                    startNextActivity();
                }
            }
        });

        scoreCountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    Log.e(getClass().getSimpleName(),"device is online");
                    loadInterstitial();
                }else{
                    Log.e(getClass().getSimpleName(),"device is offline");
                    startNextActivity();
                }            }
        });

        doubleCoinsLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO play reward video

            }
        });

        doubleCoinsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO play reward video

            }
        });

        doubleCoinsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO play reward video

            }
        });


        gamePlayGraphicImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInterstitial();
            }
        });


        numberOfKeysTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamePlayScoreActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        numberOfCoinsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO play reward video
            }
        });

        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "PG");

        adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build();


        AdView adView = findViewById(R.id.adView_game_play_score_activity);
        if (adView == null){
            Log.e("","Null About Layout adView");
        }

        if (adView != null) {
            adView.loadAd(adRequest);
        }



    }

    private void loadInterstitial() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5160269550159038/5349989016");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }  //Toast.makeText(getApplicationContext(), "The interstitial wasn't loaded yet.", Toast.LENGTH_SHORT).show();

                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // request twise
                startActivity(new Intent(GamePlayScoreActivity.this, MainActivity.class));
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(GamePlayScoreActivity.this, MainActivity.class));
            }
        });

        mInterstitialAd.loadAd(adRequest);


    }

    public void startNextActivity(){
        startActivity(new Intent(GamePlayScoreActivity.this, MainActivity.class));
    }

    @Override
    public void onBackPressed() {
        if (isNetworkAvailable()){
            Log.e(getClass().getSimpleName(),"device is online");
            loadInterstitial();
        }else{
            Log.e(getClass().getSimpleName(),"device is offline");
            startNextActivity();
        }
        super.onBackPressed();

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            // Network is present and connected
            isAvailable = true;
        }
        return isAvailable;
    }

}
