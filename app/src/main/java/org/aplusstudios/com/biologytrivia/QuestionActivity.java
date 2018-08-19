package org.aplusstudios.com.biologytrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.aplusstudios.com.biologytrivia.model.Answer;
import org.aplusstudios.com.biologytrivia.model.Question;

import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private Question question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView questionPromptTextView = findViewById(R.id.question_textview);
        Button answerOptionAButton = findViewById(R.id.answer_option_A_button);
        Button answerOptionBButton = findViewById(R.id.answer_option_B_button);
        Button answerOptionCButton = findViewById(R.id.answer_option_C_button);
        Button answerOptionDButton = findViewById(R.id.answer_option_D_button);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String question = (String) bundle.get(getString(R.string.general_question));
            List<Answer> answerList = (List<Answer>) bundle.get("answers_list");
            Log.e(getClass().getSimpleName(),"Question"+ question);
            questionPromptTextView.setText(question);
        }else {
            Log.e(getClass().getSimpleName(),"Question is null");
            questionPromptTextView.setText(R.string.general_error_unable_to_load_question);
        }

        answerOptionAButton.setText(R.string.sample_answer_a);
        answerOptionBButton.setText(R.string.sample_answer_b);
        answerOptionCButton.setText(R.string.sample_c);
        answerOptionDButton.setText(R.string.sample_answer_d);

    }
}
