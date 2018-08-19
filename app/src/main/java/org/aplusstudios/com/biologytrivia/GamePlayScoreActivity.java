package org.aplusstudios.com.biologytrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
                Intent intent = new Intent(GamePlayScoreActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        scoreLabelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamePlayScoreActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        scoreCountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamePlayScoreActivity.this,MainActivity.class);
                startActivity(intent);
            }
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
                Intent intent = new Intent(GamePlayScoreActivity.this,MainActivity.class);
                startActivity(intent);
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


    }
}
