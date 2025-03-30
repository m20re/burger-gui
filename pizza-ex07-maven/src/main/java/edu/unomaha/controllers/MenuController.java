package edu.unomaha.controllers;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

public class MenuController {
    
    @FXML
    private TextField nameIn;
    @FXML
    private TextField numberIn; 
    @FXML
    private TextField emailIn;

    /* FXML loader will look for instance variables that match with fx:id variables.  */

    // @FXML
    // private void switchToSecondary() throws IOException {
    //     App.setRoot("secondary");
    // }

    /* Source: https://stackoverflow.com/questions/15041760/javafx-open-new-window */

}
