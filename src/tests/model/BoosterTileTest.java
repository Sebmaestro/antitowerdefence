package tests.model;

import org.junit.Test;
import sourceCode.model.Tile.Tile;

import static org.junit.Assert.*;

public class BoosterTileTest {


    Tile booster = new Booster(1, 1);

    @Test
    public void shouldBeAbleToCreateNewBoosterTile() {
         assertNotNull(booster);
    }
}
