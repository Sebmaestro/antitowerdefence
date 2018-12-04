package sourceCode.model.Troop;

import sourceCode.model.Position;

public class TeleporterTroop extends Troop{

    private Position teleportEntry;
    private Position teleportExit;
    private boolean isCreatingTeleport;

    public TeleporterTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 40;
        speed = 10;
    }


}
