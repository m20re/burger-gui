package edu.unomaha.controllers;

import java.io.IOException;
import java.util.List;

import edu.unomaha.burger.Burger;
import edu.unomaha.burger.BurgerManager;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

public class MenuController {

    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToBurger(ActionEvent event) throws IOException {
        /* Load the BurgerMenu */
        root = FXMLLoader.load(getClass().getResource("/edu/unomaha/views/" + "BurgerMenu" + ".fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        /* Store and load the css stylesheet */
        String css = this.getClass().getResource("/edu/unomaha/views/styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Burger Menu");
        stage.show();
    }

    public void switchToReceipt(ActionEvent event) throws IOException {

        /* Ensures a receipt can't be printed out if nothing was added */
        List<Burger> burgers = BurgerManager.getInstance().getBurgers();
        if (burgers.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("No Burgers");
            alert.setHeaderText(null);
            alert.setContentText("No burgers have been added.");
            alert.showAndWait();
            /* Return early */
            return;
        }

        Parent root = FXMLLoader.load(getClass().getResource("/edu/unomaha/views/Receipt.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/edu/unomaha/views/styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("Receipt");
        stage.show();
    }
    

    /* Depreciated function */
    // public void switchToPizza(ActionEvent event) throws IOException {
    //     /* Load the BurgerMenu */
    //     root = FXMLLoader.load(getClass().getResource("/edu/unomaha/views/" + "PizzaMenu" + ".fxml"));
    //     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);

    //     /* Store and load the css stylesheet */
    //     String css = this.getClass().getResource("/edu/unomaha/views/styles.css").toExternalForm();
    //     scene.getStylesheets().add(css);

    //     stage.setScene(scene);
    //     stage.setTitle("Pizza Menu");
    //     stage.show();
    // }


    


    /* FXML loader will look for instance variables that match with fx:id variables.  */

    // @FXML
    // private void switchToSecondary() throws IOException {
    //     App.setRoot("secondary");
    // }

    /* Source: https://stackoverflow.com/questions/15041760/javafx-open-new-window */

}
