package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni and simon on 2018-12-10.
 */

public class Screen extends JLayeredPane {
    private static Room room;
    private static Laser laser;
    private static Overlay overlay;
    private BufferedImage[][] underlayimg, overlayimg;
    private boolean laserBoolean;
    Screen() {
        setSize(new Dimension(1080, 700));

        laserBoolean = false;

    }

    void setImages(BufferedImage[][] underLay, BufferedImage[][] overLay) {
        underlayimg = underLay;
        overlayimg = overLay;
    }

    void createGameScreen(){
        room = new Room(underlayimg);
        overlay = new Overlay(overlayimg);
        laser = new Laser();
    }

    public void drawLaser() {

        laserBoolean = true;

    }

    public void updateOverlay(BufferedImage[][] overLay){
        overlay.updateOverlay(overLay);
    }

    public void paintComponent(Graphics g){
        g.setColor(new Color(70,70,70));
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(new Color(0,0,0));

        setLayer(room, DEFAULT_LAYER);
        setLayer(overlay, PALETTE_LAYER);

        room.draw(g);
        overlay.draw(g);

        if(laserBoolean) {
            setLayer(laser, PALETTE_LAYER);
            laser.draw(g);
            laserBoolean = false;
        }
    }

    public Laser getLaser(){
        return laser;
    }
}

