package sourceCode;
import sourceCode.controller.Controller;
import sourceCode.view.View;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
        if(args.length == 0){
            SwingUtilities.invokeLater(() -> {
                try {
                    new Controller();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
