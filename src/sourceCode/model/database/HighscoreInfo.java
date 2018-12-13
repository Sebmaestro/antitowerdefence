package sourceCode.model.database;

/**
 * Author: Sebastian Arledal c17sal
 * 2018-12-13
 *
 * A class to hold info about the user and his score
 */
public class HighscoreInfo {
    private String player;
    private int finishTime;

    /**
     * Constructor
     *
     * @param player - The player
     * @param finishTime - The players time
     */
    public HighscoreInfo(String player, int finishTime) {
        this.player = player;
        this.finishTime = finishTime;
    }

    /**
     * Gets the playername
     *
     * @return getPlayer - playername
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Gets the finishtime
     *
     * @return finishTime - The players time
     */
    public int getFinishTime() {
        return finishTime;
    }
}
