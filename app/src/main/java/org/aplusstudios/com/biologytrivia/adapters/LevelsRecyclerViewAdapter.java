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
        lessonsViewHolder.cardTitleView.setText(levelList.get(position).getSongTitle());
        lessonsViewHolder.cardDescription.setText(levelList.get(position).getSongDescription());

        lessonsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_one_title))) {
                    Intent intent = new Intent(view.getContext(),TrackOneActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_two_title))) {
                    Intent intent = new Intent(view.getContext(),TrackTwoActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_three_title))) {
                    Intent intent = new Intent(view.getContext(),TrackThreeActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_four_title))) {
                    Intent intent = new Intent(view.getContext(),TrackFourActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_five_title))) {
                    Intent intent = new Intent(view.getContext(),TrackFiveActivity.class);
                    view.getContext().startActivity(intent);
                }  else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_six_title))) {
                    Intent intent = new Intent(view.getContext(),TrackSixActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_seven_title))) {
                    Intent intent = new Intent(view.getContext(),TrackSevenActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_eight_title))) {
                    Intent intent = new Intent(view.getContext(),TrackEightActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_nine_title))) {
                    Intent intent = new Intent(view.getContext(),TrackNineActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_ten_title))) {
                    Intent intent = new Intent(view.getContext(),TrackTenActivity.class);
                    view.getContext().startActivity(intent);
                } else if (levelList.get(lessonsViewHolder.getAdapterPosition()).getSongTitle().equals(view.getContext().getString(R.string.track_eleven_title))) {
                    Intent intent = new Intent(view.getContext(),TrackElevenActivity.class);
                    view.getContext().startActivity(intent);
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

