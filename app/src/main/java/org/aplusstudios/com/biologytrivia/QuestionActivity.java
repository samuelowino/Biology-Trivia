package org.aplusstudios.com.biologytrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

    Button answerOptionAButton;
    Button answerOptionBButton;
    Button answerOptionCButton;
    Button answerOptionDButton;

    String correctAnswer = "";

    ImageView cancelGamePlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionPromptTextView = findViewById(R.id.question_textview);
        questionNumberProgressTextView = findViewById(R.id.question_number_textview);
        answerOptionAButton = findViewById(R.id.answer_option_A_button);
        answerOptionBButton = findViewById(R.id.answer_option_B_button);
        answerOptionCButton = findViewById(R.id.answer_option_C_button);
        answerOptionDButton = findViewById(R.id.answer_option_D_button);
        cancelGamePlayButton = findViewById(R.id.exit_game_playButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            questionNumber = (Integer) bundle.get("question_number");
            questionNumber += 1;
            levelName = (String) bundle.get("level_name");
            level_id = (Integer) bundle.get("level_id");
            totalQuestionInLevel = (Integer) bundle.get("total_questions_count");
            scoreCount = (Integer) bundle.get("score_count");
        } else {
            Log.e(getClass().getSimpleName(), "Question is null");
            questionPromptTextView.setText(R.string.general_error_unable_to_load_question);
        }

        questionNumberProgressTextView.setText((questionNumber) + "/" + totalQuestionInLevel);

        cancelGamePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitIntent = new Intent(QuestionActivity.this,MainActivity.class);
                startActivity(exitIntent);
            }
        });

        answerOptionAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer.contains("A")) {
                    answerOptionAButton.setBackgroundColor(getResources().getColor(R.color.success_blue));

                    if (questionNumber == totalQuestionInLevel) {
                        Intent intent = new Intent(QuestionActivity.this, GamePlayScoreActivity.class);
                        startActivity(intent);
                    } else {
                        Intent openLevelIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", levelName);
                        openLevelIntent.putExtra("level_id", level_id);
                        openLevelIntent.putExtra("question_number", questionNumber);
                        openLevelIntent.putExtra("score_count", scoreCount + 1);
                        openLevelIntent.putExtra("total_questions_count", totalQuestionInLevel);
                        startActivity(openLevelIntent);
                    }
                } else {
                    answerOptionAButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });

        answerOptionBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer.contains("B")) {
                    answerOptionBButton.setBackgroundColor(getResources().getColor(R.color.success_blue));

                    if (questionNumber == totalQuestionInLevel) {
                        Intent intent = new Intent(QuestionActivity.this, GamePlayScoreActivity.class);
                        startActivity(intent);
                    } else {
                        Intent openLevelIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", levelName);
                        openLevelIntent.putExtra("level_id", level_id);
                        openLevelIntent.putExtra("question_number", questionNumber);
                        openLevelIntent.putExtra("score_count", scoreCount + 1);
                        openLevelIntent.putExtra("total_questions_count", totalQuestionInLevel);
                        startActivity(openLevelIntent);
                    }
                } else {
                    answerOptionBButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });

        answerOptionCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer.contains("C")) {
                    answerOptionCButton.setBackgroundColor(getResources().getColor(R.color.success_blue));

                    if (questionNumber == totalQuestionInLevel) {
                        Intent intent = new Intent(QuestionActivity.this, GamePlayScoreActivity.class);
                        startActivity(intent);
                    } else {

                        Intent openLevelIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", levelName);
                        openLevelIntent.putExtra("level_id", level_id);
                        openLevelIntent.putExtra("question_number", questionNumber);
                        openLevelIntent.putExtra("score_count", scoreCount + 1);
                        openLevelIntent.putExtra("total_questions_count", totalQuestionInLevel);
                        startActivity(openLevelIntent);
                    }
                } else {
                    answerOptionCButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });

        answerOptionDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer.contains("D")) {
                    answerOptionDButton.setBackgroundColor(getResources().getColor(R.color.success_blue));

                    if (questionNumber == totalQuestionInLevel) {
                        Intent intent = new Intent(QuestionActivity.this, GamePlayScoreActivity.class);
                        startActivity(intent);
                    } else {
                        Intent openLevelIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", levelName);
                        openLevelIntent.putExtra("level_id", level_id);
                        openLevelIntent.putExtra("question_number", questionNumber);
                        openLevelIntent.putExtra("score_count", scoreCount + 1);
                        openLevelIntent.putExtra("total_questions_count", totalQuestionInLevel);
                        startActivity(openLevelIntent);
                    }
                } else {
                    answerOptionDButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });

        switch (level_id) {
            case 1:
                setUpLeveOneQuestions();
                setUpLevelOneQuestionOptions();
                break;
            case 2:
                setUpLeveTwoQuestions();
                setUpLevelTwoQuestionOptions();
                break;
            case 3:
                setUpLeveThreeQuestions();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
    }

    public void setUpLeveOneQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                correctAnswer = getResources().getString(R.string.level_one_question_one_answer);
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                correctAnswer = getResources().getString(R.string.level_one_question_one_answer);

                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                correctAnswer = getResources().getString(R.string.level_one_question_one_answer);

                break;
            default:
        }
    }

    public void setUpLeveTwoQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveThreeQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_three_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveFourQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_four_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveFiveQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_five_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveSixQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_six_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveSevenQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_seven_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveEightQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_eight_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLeveNineQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_nine_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLevelTenQuestions() {
        switch (questionNumber) {
            case 1:
                questionPromptTextView.setText(getResources().getString(R.string.level_ten_question_one));
                break;
            case 2:
                questionPromptTextView.setText(getResources().getString(R.string.level_one_question_one));
                break;
            case 3:
                questionPromptTextView.setText(getResources().getString(R.string.level_two_question_one));
                break;
            default:
        }
    }

    public void setUpLevelOneQuestionOptions() {
        switch (questionNumber) {
            case 1:
                answerOptionAButton.setText(R.string.level_one_question_one_option_one);
                answerOptionBButton.setText(R.string.level_one_question_one_option_two);
                answerOptionCButton.setText(R.string.level_one_question_one_option_three);
                answerOptionDButton.setText(R.string.level_one_question_one_option_four);
                break;
            case 2:
                answerOptionAButton.setText(R.string.level_one_question_two_option_one);
                answerOptionBButton.setText(R.string.level_one_question_two_option_one);
                answerOptionCButton.setText(R.string.level_one_question_two_option_one);
                answerOptionDButton.setText(R.string.level_one_question_two_option_one);
                break;
            case 3:
                answerOptionAButton.setText(R.string.level_one_question_three_option_one);
                answerOptionBButton.setText(R.string.level_one_question_three_option_one);
                answerOptionCButton.setText(R.string.level_one_question_three_option_one);
                answerOptionDButton.setText(R.string.level_one_question_three_option_one);
                break;
            default:
        }
    }

    public void setUpLevelTwoQuestionOptions() {
        switch (questionNumber) {
            case 1:
                answerOptionAButton.setText(R.string.level_one_question_one_option_one);
                answerOptionBButton.setText(R.string.level_one_question_one_option_two);
                answerOptionCButton.setText(R.string.level_one_question_one_option_three);
                answerOptionDButton.setText(R.string.level_one_question_one_option_four);
                break;
            case 2:
                answerOptionAButton.setText(R.string.level_one_question_two_option_one);
                answerOptionBButton.setText(R.string.level_one_question_two_option_one);
                answerOptionCButton.setText(R.string.level_one_question_two_option_one);
                answerOptionDButton.setText(R.string.level_one_question_two_option_one);
                break;
            case 3:
                answerOptionAButton.setText(R.string.level_one_question_three_option_one);
                answerOptionBButton.setText(R.string.level_one_question_three_option_one);
                answerOptionCButton.setText(R.string.level_one_question_three_option_one);
                answerOptionDButton.setText(R.string.level_one_question_three_option_one);
                break;
            default:
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuestionActivity.this, MainActivity.class));
    }
}
