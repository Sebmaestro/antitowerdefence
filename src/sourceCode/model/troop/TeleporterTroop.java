package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.TyleType;

/**
 * Author: Sebastian Arledal c17sal
 */
public class TeleporterTroop extends Troop {

    private Position teleportEntry;
    private Position teleportExit;
    private boolean isCreatingTeleport;
    int numberOfTeleportTiles;

    public TeleporterTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 40;
        ordinarySpeed = 4;
        currentSpeed = ordinarySpeed;
        fastSpeed = ordinarySpeed/2;
        slowSpeed = ordinarySpeed*3;
        isCreatingTeleport = false;
        troopID = 1;
        graphic = "Teleporter";
    }

    @Override
    public TyleType clickOn() {
        if (!isCreatingTeleport) {
            teleportEntry = getPosition();
            isCreatingTeleport = true;
            return TyleType.TELEPORTENTRY;
        } else {
            teleportExit = getPosition();
            return TyleType.TELEPORTEXIT;
        }
    }



    //public Troop getTroop() {
    //    return TeleporterTroop.this;
    //}
}
