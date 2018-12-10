package sourceCode.model;
import java.io.IOException;

import sourceCode.model.tile.*;
import sourceCode.model.xmlparser.LevelParser;

/**
 * Created by denni on 2018-12-05.
 */
public class Model {
    private int width;
    private int height;

    public Model(int height, int width) throws IOException{
        Tile[][] tiles;

        tiles = LevelParser.xmlparser("./src/resources/testLevel.xml");

    }

}
