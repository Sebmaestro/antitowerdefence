package sourceCode.model;

import sourceCode.view.MainFrame;
import sourceCode.view.Screen;

import java.awt.event.*;
import java.awt.*;

public class KeyHandel implements MouseMotionListener, MouseListener{


    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }


    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        Screen.msc = new Point((e.getX()) + ((MainFrame.size.width - Screen.myWidth/2) - (Screen.myWidth/2)),
                (e.getY()) - ((MainFrame.size.height - (Screen.myHeight)) - (MainFrame.size.width - Screen.myWidth)/2));
    }
}
