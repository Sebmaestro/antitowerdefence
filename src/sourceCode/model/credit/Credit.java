package sourceCode.model.credit;

import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.TeleporterTroop;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Class to hold player credits
 */
public class Credit {

    private int credits;

    /**
     * Constructor: Sets starting credit
     */
    public Credit() {
        credits = 500;
    }

    /**
     * Buys a troop and deducts credits
     * @param t - troop
     */
    public void buyNewTroop(Troop t) {
        if (t instanceof RegularTroop) {
            credits = credits - 100;
        } else if (t instanceof TeleporterTroop) {
            credits = credits - 700;
        } else {
            credits = credits - 300;
        }
    }

    /**
     * Receive credit from entering goal
     */
    public void getGoalCredits() {
        credits = credits + 200;
    }

    /**
     * Gets current credits
     * @return credits - your credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets credit for player
     * @param newCredits - new credits
     */
    public void setCredits(int newCredits) {
        credits = newCredits;
    }
}
