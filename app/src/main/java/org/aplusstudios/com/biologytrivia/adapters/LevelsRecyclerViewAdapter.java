package org.aplusstudios.com.biologytrivia.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.aplusstudios.com.biologytrivia.QuestionActivity;
import org.aplusstudios.com.biologytrivia.R;
import org.aplusstudios.com.biologytrivia.model.Level;

import java.util.List;

public class LevelsRecyclerViewAdapter extends RecyclerView.Adapter<LevelsRecyclerViewAdapter.LessonViewHolder> {

    private final List<Level> levelList;
    private final Context context;

    public LevelsRecyclerViewAdapter(List<Level> lessonList, Context context) {
        this.levelList = lessonList;
        this.context = context;
    }


    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game_level, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LessonViewHolder lessonsViewHolder, final int position) {
        lessonsViewHolder.levelTitleTextView.setText(levelList.get(position).getLevelTitle());
        if (levelList.get(position).isCompleted()) {
            lessonsViewHolder.levelCompleteStatusImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_action_level_success));
            lessonsViewHolder.levelImageView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
            lessonsViewHolder.levelImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_action_label_complete));
            lessonsViewHolder.levelTitleTextView.setTextColor(context.getResources().getColor(R.color.success_blue));
        } else if (levelList.get(position).isStarted()) {
            lessonsViewHolder.levelCompleteStatusImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_action_level_started));
            lessonsViewHolder.levelImageView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
            lessonsViewHolder.levelImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_action_label_started));
            lessonsViewHolder.levelTitleTextView.setTextColor(context.getResources().getColor(android.R.color.black));
        } else {
            lessonsViewHolder.levelCompleteStatusImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_action_level_locked));
            lessonsViewHolder.levelImageView.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
            lessonsViewHolder.levelImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_action_label_not_started));
        }

        lessonsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer questionsNumber = 0;
                Intent openLevelIntent;
                Level level = levelList.get(position);

                switch (level.getNumber()) {
                    case 1:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 2:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 3:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 4:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 5:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 6:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 7:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 8:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 9:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    case 10:
                        questionsNumber = Integer.parseInt(context.getResources().getString(R.string.level_one_questions_number));

                        openLevelIntent = new Intent(context, QuestionActivity.class);
                        openLevelIntent.putExtra("level_name", level.getLevelTitle());
                        openLevelIntent.putExtra("level_id", level.getNumber());
                        openLevelIntent.putExtra("question_number", 0);
                        openLevelIntent.putExtra("score_count", 0);
                        openLevelIntent.putExtra("total_questions_count", questionsNumber);
                        context.startActivity(openLevelIntent);
                        break;
                    default:
                        break;
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }

    static class LessonViewHolder extends RecyclerView.ViewHolder {

        final CardView cardView;
        final TextView levelTitleTextView;
        final ImageView levelCompleteStatusImageView;
        final ImageView levelImageView;

        LessonViewHolder(View itemView) {

            super(itemView);

            cardView = itemView.findViewById(R.id.level_title_cardview);
            levelTitleTextView = itemView.findViewById(R.id.level_name_textview);
            levelCompleteStatusImageView = itemView.findViewById(R.id.level_complete_status);
            levelImageView = itemView.findViewById(R.id.level_image_view);
        }
    }
}

