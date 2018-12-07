package sourceCode.model.database;

public class HighscoreInfo {
    private String player;
    private int score;
    private int time;
    private String map;

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }
}
