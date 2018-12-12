package sourceCode.model;
import sourceCode.model.Game.Game;
import sourceCode.model.Tile.*;
import java.io.IOException;

import sourceCode.model.Xmlparser.LevelParser;

/**
 * Created by denni on 2018-12-05.
 */
public class Model {
    private int width;
    private int height;
    private Tile[][] tiles;
    private Game game;

    public Model() throws IOException{

        tiles = LevelParser.xmlparser("./src/resources/testLevel.xml");
        game = new Game(tiles);

    }

}
