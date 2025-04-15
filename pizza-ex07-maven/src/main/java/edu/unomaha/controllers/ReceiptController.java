package edu.unomaha.controllers;

import edu.unomaha.burger.Burger;
import edu.unomaha.burger.BurgerManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReceiptController implements Initializable {

    @FXML
    private TextArea receiptTextArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Burger> burgers = BurgerManager.getInstance().getBurgers();
        StringBuilder receipt = new StringBuilder();

        if (burgers.isEmpty()) {
            receipt.append("No burgers created yet.");
        } else {
            for (Burger burger : burgers) {
                receipt.append(burger.toNiceString())
                       .append("\nPrice: $")
                       .append(String.format("%.2f", burger.getPrice()))
                       .append("\n\n");
            }
        }

        receipt.append("Final price: $")
                .append(String.format("%.2f", BurgerManager.getInstance().getPrice()))
                .append("\n\n");

        receiptTextArea.setText(receipt.toString());
    }
}
