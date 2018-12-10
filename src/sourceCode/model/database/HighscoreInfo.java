package sourceCode.model.database;

public class HighscoreInfo {
    private String player;
    private int finishTime;
    private String map;

    public HighscoreInfo(String player, String map, int finishTime) {
        this.player = player;
        this.finishTime = finishTime;
        this.map = map;
    }

    public String getPlayer() {
        return player;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public String getMap() {
        return map;
    }
}
