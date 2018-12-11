package sourceCode.model;

import javafx.geometry.Pos;
import sourceCode.model.Tile.*;
import sourceCode.model.Tile.Path;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Troop.Direction;
import sourceCode.model.Troop.RegularTroop;
import sourceCode.model.Xmlparser.LevelParser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Lagertest extends JPanel {
    public Path gubbe;
    public int worldWidth = 10;
    public int worldHeight = 10;
    int blockSize = 32;
    protected Direction dir;
    public static RegularTroop rTroop;
    public Tile[][] tileMap;
    public Position startPos;
    public Position east;
    public Position south;
    public Position west;
    public Position north;




    public Lagertest(){
        define();
    }

    public void define(){

       Position startPos = LevelParser.startPos;
       tileMap = LevelParser.allTiles;




        rTroop = new RegularTroop(startPos, Direction.EAST);


        rTroop.setBounds(235 + rTroop.getPosition().getX() * 55, rTroop.getPosition().getY() * 55, 55, 55);
        //gubbe = new Path(new Position(1,3));
       // gubbe.setGroundId(5);
       // gubbe.setBounds(235 + gubbe.getPosition().getX()*55,gubbe.getPosition().getY()*55,55,55);
    }

    int walkFrame = 0, walkSpeed = 200;
    public void physic(){

        if(walkFrame >= walkSpeed && (!rTroop.isGoalReached())) {
            east = rTroop.getPosition().getPosToEast();
            south = rTroop.getPosition().getPosToSouth();
            west = rTroop.getPosition().getPosToWest();
            north = rTroop.getPosition().getPosToNorth();

            if (rTroop.getDirection() == Direction.EAST) {
                System.out.println("öster");

                if (tileMap[east.getY()][east.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(east);
                } else if (tileMap[south.getY()][south.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(south);
                    rTroop.setDirection(Direction.SOUTH);
                } else if (tileMap[north.getY()][north.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(north);
                    rTroop.setDirection(Direction.NORTH);
                }

            }

            if (rTroop.getDirection() == Direction.NORTH) {
                System.out.println("ska inte gå norr");

                if (tileMap[north.getY()][north.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(north);
                } else if (tileMap[east.getY()][east.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(east);
                    rTroop.setDirection(Direction.EAST);
                } else if (tileMap[west.getY()][west.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(west);
                    rTroop.setDirection(Direction.WEST);
                }

            }

            if (rTroop.getDirection() == Direction.SOUTH) {
                System.out.println("söder");

                if (tileMap[south.getY()][south.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(south);
                } else if (tileMap[east.getY()][east.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(east);
                    rTroop.setDirection(Direction.EAST);
                } else if (tileMap[west.getY()][west.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(west);
                    rTroop.setDirection(Direction.WEST);
                }
                else if (tileMap[south.getY()][south.getX()].landOn().equals(TyleType.GOAL)) {
                    rTroop.setPosition(south);
                    rTroop.setDirection(Direction.SOUTH);
                    rTroop.setGoalReached();

                    if(rTroop.isGoalReached()){
                        System.out.println("nu nådde vi målet");
                    }
                }

            }

            if (rTroop.getDirection() == Direction.WEST) {
                System.out.println("väster");

                if (tileMap[west.getY()][west.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(west);
                } else if (tileMap[north.getY()][north.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(north);
                    rTroop.setDirection(Direction.NORTH);
                } else if (tileMap[south.getY()][south.getX()].landOn().equals(TyleType.PATH)) {
                    rTroop.setPosition(south);
                    rTroop.setDirection(Direction.SOUTH);
                }

            }
            walkFrame = 0;
        }
        else{
            walkFrame +=1;
        }

        rTroop.setBounds(235 + rTroop.getPosition().getX() * 55, rTroop.getPosition().getY() * 55, 55, 55);
    }


    public void draw(Graphics g){

        if(rTroop.isAlive() && (!rTroop.isGoalReached())) {
            rTroop.draw(g);
        }
    }
}
