package sourceCode.view;


import sourceCode.model.Position;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.RegularTower;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by denni on 2018-12-11.
 */
public class TowerMofo extends JPanel {
    public RegularTower regTower[];
    public RegularTower regaTower;
    public Tile[][] tileMap;
    public ArrayList<Position> towerZonePosition;

    public TowerMofo() {define();}

    public void define(){
        tileMap = LevelParser.allTiles;
        towerZonePosition = LevelParser.towerZonePositions;
        regTower = new RegularTower[5];
        regaTower = new RegularTower(towerZonePosition.get(getRandomNumberInRange(0,27)));


        regTower[0] = new RegularTower(towerZonePosition.get(2));
        regTower[1] = new RegularTower(towerZonePosition.get(12));
        regTower[2] = new RegularTower(towerZonePosition.get(10));
        regTower[3] = new RegularTower(towerZonePosition.get(15));
        regTower[4] = new RegularTower(towerZonePosition.get(20));
        for(int i=0;i<5;i++){
            regTower[i].setBounds(235 + regTower[i].getPosition().getX() * 55, regTower[i].getPosition().getY() * 55, 55, 55);
        }
            regTower[4] = new RegularTower(towerZonePosition.get(20));
            regTower[4].setBounds(235 + regTower[4].getPosition().getX() * 55, regTower[4].getPosition().getY() * 55, 55, 55);



    }

    public void physics(Troop t) {



    }

    public void draw(Graphics g){

        for(int i=0; i<5; i++){
            regTower[i].draw(g);
        }
        //regaTower.draw(g);

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}





