package sourceCode;
import sourceCode.controller.Controller;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
        if(args.length == 0){
            SwingUtilities.invokeLater(() -> {
                try {
                    new Controller("src/Resources/levels.xml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            try {
                new Controller(args[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
