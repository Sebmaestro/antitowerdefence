package sourceCode.controller;


import sourceCode.model.Model;
import sourceCode.view.View;

import java.io.IOException;

public class Controller {
    private View view;
    private Model model;

    public Controller() throws IOException {
        int height = 700;
        int width = 1080;
        view = new View();

        model = new Model(height, width);
    }


}
