package sourceCode.controller;
import sourceCode.model.*;


import sourceCode.model.Model;

import java.io.IOException;

public class Controller {
    private Frame frame;
    private Model model;

    public Controller() throws IOException {
        int height = 700;
        int width = 1080;
        frame = new Frame();
        //model = new Model(height, width);
    }


}
