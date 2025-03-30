package edu.unomaha.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SecondaryController {
    @FXML
    private Label nameOut;
    @FXML
    private Label emailOut;
    @FXML
    private Label numberOut;

    public void initData(String name, String email, String number) {
        
        nameOut.setText(name);
        emailOut.setText(email);
        numberOut.setText(number);
    }

    // @FXML
    // private void switchToPrimary() throws IOException {
        
    // }
}
