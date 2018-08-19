package org.aplusstudios.com.biologytrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.aplusstudios.com.biologytrivia.model.Question;

public class QuestionActivity extends AppCompatActivity {

    private Question question;
    private TextView questionNumberProgressTextView;
    private TextView questionPromptTextView;

    Integer questionNumber = 0;
    String levelName = "unknown level";
    Integer level_id = 0;
    Integer totalQuestionInLevel = 0;
    Integer scoreCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionPromptTextView = findViewById(R.id.question_textview);
        questionNumberProgressTextView = findViewById(R.id.question_number_textview);
        Button answerOptionAButton = findViewById(R.id.answer_option_A_button);
        Button answerOptionBButton = findViewById(R.id.answer_option_B_button);
        Button answerOptionCButton = findViewById(R.id.answer_option_C_button);
        Button answerOptionDButton = findViewById(R.id.answer_option_D_button);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
             questionNumber = (Integer) bundle.get("question_number");
             levelName = (String)bundle.get("level_name");
             level_id = (Integer)bundle.get("level_id");
             totalQuestionInLevel = (Integer)bundle.get("total_questions_count");
             scoreCount = (Integer)bundle.get("score_count");
        }else {
            Log.e(getClass().getSimpleName(),"Question is null");
            questionPromptTextView.setText(R.string.general_error_unable_to_load_question);
        }

        questionNumberProgressTextView.setText(questionNumber+"/"+totalQuestionInLevel);

        answerOptionAButton.setText(R.string.sample_answer_a);
        answerOptionBButton.setText(R.string.sample_answer_b);
        answerOptionCButton.setText(R.string.sample_answer_c);
        answerOptionDButton.setText(R.string.sample_answer_d);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity( new Intent(QuestionActivity.this,MainActivity.class));
    }
}
