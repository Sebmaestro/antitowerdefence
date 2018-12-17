package sourceCode.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import sourceCode.model.*;
import sourceCode.model.Model;
import sourceCode.model.credit.Credit;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.database.HighscoreInfo;
import sourceCode.model.logic.Game;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.RegularTower;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;
import sourceCode.view.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static sourceCode.model.troop.Direction.EAST;

public class Controller {
    private Frame frame;
    private Model model;
    private Tile[][] tiles;
    private LevelParser levelP;
    private ImageArray imgArr;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> pathPosition, towerPosition, quicksandPositions,
            boosterPositions, switchUpPositions, switchDownPositions;
    private Position startPos, goalPos;
    private ArrayList<Troop> regularTroops;
    private ArrayList<Tower> towers;
    private ArrayList<LaserPositions> laserPositionList;
    private int goalCounter = 0;
    private BufferedImage[][] underlay, overlay;
    private final Object troopListLock = new Object();
    private final Object towerListLock = new Object();
    private PopupFrame popupFrame;
    private PopupHighscoreFrame newHighscore;
    private Database db = new Database();
    private HighscoreHandler handler;
    private StartMenuFrame start;
    private Game g;

    int gameWon = 0;
    Credit money = new Credit();


    public Controller() throws IOException {

        g = new Game();
        g.init();

    }
}

