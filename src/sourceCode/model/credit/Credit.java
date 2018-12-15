package sourceCode.model.credit;

import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.TeleporterTroop;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Credit {

    private int credits;

    public Credit() {
        credits = 500;
    }

    public void buyNewTroop(Troop t) {
        if (t instanceof RegularTroop) {
            credits = credits - 100;
        } else if (t instanceof TeleporterTroop) {
            credits = credits - 700;
        }
    }

    public void getGoalCredits() {
        credits = credits + 200;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int newCredits) {
        credits = newCredits;
    }
}
