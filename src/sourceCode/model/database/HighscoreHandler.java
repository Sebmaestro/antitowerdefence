package sourceCode.model.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sebastian Arledal c17sal
 * 2018-12-13
 *
 * A class to handle the highscores and make sure there is only 10 available
 * to put in the database
 */
public class HighscoreHandler {

        private List<HighscoreInfo> l;

    /**
     * Constructor
     */
    public HighscoreHandler(List<HighscoreInfo> list) {
            l = new ArrayList<>(10);
            l = list;
        }

    /**
     * Returns the list
     * @return l - the list
     */
    public List<HighscoreInfo> getList() {
            return l;
        }

    /**
     * Insert a highscore in the list if the list isnt full
     *
     * @param highscoreInfo - Object holding the score data
     * @return boolean - true or false
     */
    public boolean addHighscoreToList(HighscoreInfo highscoreInfo) {
            if (l.size() >= 10) {
                return true;
            } else
                addHighscoreInNonFullList(highscoreInfo);
                return false;
        }

    /**
     * Loops the list and checks if a new player can take a spot in the
     * highscore. If the new player has a top 10 score it will be inserted
     * and the nr 10 score will be deleted
     *
     * @param highscoreInfo - Object holding the score data
     */
    public void checkAndInsertHighscore(HighscoreInfo highscoreInfo) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getFinishTime() > highscoreInfo.getFinishTime()) {
                    l.add(i, highscoreInfo);
                    l.remove(10);
                    break;
                }
            }
        }

    /**
     * Adds a highscore to the list
     *
     * @param highscoreInfo - Object holding the score data
     */
    private void addHighscoreInNonFullList(HighscoreInfo highscoreInfo) {
            l.add(highscoreInfo);
        }
}
