package sourceCode.model.Game;

import sourceCode.model.Tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by denni on 2018-12-12.
 */
public class Game {
    private Tile[][] tiles;
    private int width, height;

    public Game(Tile[][] tiles, int width, int height){
        this.tiles = tiles;
        this.width = width;
        this.height = height;

    }

/*
    public BufferedImage getTheGraphics(){
        BufferedImage bufferedImage = new BufferedImage
                (width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2D = (Graphics2D)bufferedImage.getGraphics();


    }
    */



    private void drawGameTiles(Graphics2D g2D) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                try {
                    InputStream inputs = getClass().getResourceAsStream(tiles[x][y].getGraphic());
                    Image oneTileImage = ImageIO.read(inputs);
                }catch(IOException e){}
            }
        }
    }
}
