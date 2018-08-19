package org.aplusstudios.com.biologytrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.aplusstudios.com.biologytrivia.model.Answer;
import org.aplusstudios.com.biologytrivia.model.Question;

import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private List<Answer> answerList;
    private Question question;

    private TextView questionPromptTextView;

    private Button answerOptionAButton;
    private Button answerOptionBButton;
    private Button answerOptionCButton;
    private Button answerOptionDButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionPromptTextView = findViewById(R.id.question_textview);
        answerOptionAButton = findViewById(R.id.answer_option_A_button);
        answerOptionBButton = findViewById(R.id.answer_option_B_button);
        answerOptionCButton = findViewById(R.id.answer_option_C_button);
        answerOptionDButton = findViewById(R.id.answer_option_D_button);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String question = (String) bundle.get("question");
            answerList = (List<Answer>)bundle.get("answers_list");
            Log.e(getClass().getSimpleName(),"Question"+ question);
            questionPromptTextView.setText(question);
        }else {
            Log.e(getClass().getSimpleName(),"Question is null");
            questionPromptTextView.setText("Unable to load question as this time.");
        }

        answerOptionAButton.setText("Choose this answer");
        answerOptionBButton.setText("OR choose this answer");
        answerOptionCButton.setText("OR this answer");
        answerOptionDButton.setText("OR all these answers");

    }
}
