package sourceCode.model.Troop;

import sourceCode.model.Position;
import sourceCode.model.Tile.TyleType;

public class TeleporterTroop extends Troop {

    private Position teleportEntry;
    private Position teleportExit;
    private boolean isCreatingTeleport;

    public TeleporterTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 40;
        speed = 10;
        isCreatingTeleport = false;
        troopID = 1;
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
}
