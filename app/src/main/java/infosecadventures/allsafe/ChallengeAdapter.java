package infosecadventures.allsafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder> {

    private final List<ChallengeItem> challengeList;
    private final Context context;

    public ChallengeAdapter(List<ChallengeItem> challengeList, Context context) {
        this.challengeList = challengeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChallengeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drawer_menu_item, parent, false);
        return new ChallengeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeViewHolder holder, int position) {
        ChallengeItem item = challengeList.get(position);
        holder.icon.setImageResource(item.getIconResId());
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.difficulty.setText(item.getDifficulty().toUpperCase());
        holder.difficulty.setBackgroundResource(getDifficultyBackground(item.getDifficulty()));
        holder.difficulty.setTextColor(context.getResources().getColor(getDifficultyTextColor(item.getDifficulty()), null));
    }

    private int getDifficultyBackground(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return R.drawable.difficulty_badge_easy;
            case "medium":
                return R.drawable.difficulty_badge_medium;
            case "hard":
                return R.drawable.difficulty_badge_hard;
            default:
                return R.drawable.difficulty_badge_easy;
        }
    }

    private int getDifficultyTextColor(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return R.color.difficultyEasy;
            case "medium":
                return R.color.difficultyMedium;
            case "hard":
                return R.color.difficultyHard;
            default:
                return R.color.difficultyEasy;
        }
    }

    @Override
    public int getItemCount() {
        return challengeList.size();
    }

    public static class ChallengeViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title, description, difficulty;

        public ChallengeViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.menu_icon);
            title = itemView.findViewById(R.id.menu_title);
            description = itemView.findViewById(R.id.menu_description);
            difficulty = itemView.findViewById(R.id.difficulty_badge);
        }
    }
}
