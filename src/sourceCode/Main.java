package sourceCode;
import org.xml.sax.SAXException;
import sourceCode.controller.Controller;
import tests.SchemaTest;

import javax.swing.*;
import java.io.IOException;

/**
 * Author: Dennis Karlman / Sebastian Arledal
 * 2019-01-21
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException {

        SchemaTest schema = new SchemaTest();
        if (schema.validation()) {
            if (args.length == 0) {
                SwingUtilities.invokeLater(() -> new Controller("src/resources/levels.xml"));
            } else {
                SwingUtilities.invokeLater(() -> new Controller(args[0]));
            }
        }
    }
}
