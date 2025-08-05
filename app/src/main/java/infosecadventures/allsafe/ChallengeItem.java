package infosecadventures.allsafe;

public class ChallengeItem {
    private int iconResId;
    private String title;
    private String description;
    private String difficulty;
    private int navigationId;

    public ChallengeItem(int iconResId, String title, String description, String difficulty, int navigationId) {
        this.iconResId = iconResId;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.navigationId = navigationId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getNavigationId() {
        return navigationId;
    }
}
