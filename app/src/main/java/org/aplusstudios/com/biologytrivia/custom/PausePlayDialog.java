package org.aplusstudios.com.biologytrivia.custom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import org.aplusstudios.com.biologytrivia.MainActivity;
import org.aplusstudios.com.biologytrivia.QuestionActivity;
import org.aplusstudios.com.biologytrivia.R;

public class PausePlayDialog extends Dialog {

    private Context context;
    private Button cancelGamePlayButton;
    private Button resumeGamePlayButton;
    private CountDownTimer countDownTimer;

    public PausePlayDialog(@NonNull Context context, CountDownTimer countDownTimer) {
        super(context);
        this.context = context;
        this.countDownTimer = countDownTimer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pause_game_play_dialog_layout);

        cancelGamePlayButton = findViewById(R.id.give_up_game_play_button);
        resumeGamePlayButton = findViewById(R.id.resume_game_play_button);

        cancelGamePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitIntent = new Intent(context, MainActivity.class);
                context.startActivity(exitIntent);
                countDownTimer.cancel();
            }
        });

        resumeGamePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }


}
