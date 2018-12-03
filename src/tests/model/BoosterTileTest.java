package tests.model;

import org.junit.Before;
import org.junit.Test;
import sourceCode.model.Tile.Tile;
import static org.junit.Assert.*;

public class BoosterTileTest {
    Regular reg;
    Boster booster;

    @Before{
        reg = new Regular();
        booster = new Booster(1,1);
    }


    Tile booster = new Booster(1, 1);

    @Test
    public void shouldBeAbleToCreateNewBoosterTile() {
         assertNotNull(booster);
    }
}

    @Test
    public void shoulReturnBOOSTER(){


        assertEquals(booster.landOn().toString(), BOOSTER);
    }
