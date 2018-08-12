package org.aplusstudios.com.biologytrivia.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aplusstudios.com.biologytrivia.R;
import org.aplusstudios.com.biologytrivia.model.Level;

import java.util.List;

public class LevelsRecyclerViewAdapter extends RecyclerView.Adapter<LevelsRecyclerViewAdapter.LessonViewHolder> {

    private final List<Level> levelList;

    public LevelsRecyclerViewAdapter(List<Level> lessonList) {
        this.levelList = lessonList;
    }


    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tracks_single_row_cardview, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LessonViewHolder lessonsViewHolder, final int position) {
        lessonsViewHolder.cardTitleView.setText(levelList.get(position).getLevelTitle());
        lessonsViewHolder.cardDescription.setText(levelList.get(position).getLevelTitle());
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }

    static class LessonViewHolder extends RecyclerView.ViewHolder {

        final CardView cardView;
        final TextView cardTitleView;
        final TextView cardDescription;

        LessonViewHolder(View itemView) {

            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            cardTitleView = itemView.findViewById(R.id.card_title);
            cardDescription = itemView.findViewById(R.id.card_title_description);
        }
    }
}

