package sourceCode;
import sourceCode.controller.Controller;
import javax.swing.*;

/**
 * Author: Dennis Karlman / Sebastian Arledal
 */
public class Main {

    public static void main(String[] args){
        if(args.length == 0){
            SwingUtilities.invokeLater(() -> new Controller("src/resources/levels.xml"));
        } else {
            new Controller(args[0]);
        }
    }
}
