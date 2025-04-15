package edu.unomaha.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.unomaha.burger.Burger;
import edu.unomaha.burger.BurgerManager;
import edu.unomaha.burger.buns.*;
import edu.unomaha.burger.cheese.*;
import edu.unomaha.burger.meat.*;
import edu.unomaha.burger.garnishes.*;


/* Tutorial Source: https://www.youtube.com/watch?v=hwCbXOM4_Qc&ab_channel=BroCode */
public class BurgerController implements Initializable {

    @FXML
    private VBox burgerVbox;
    @FXML
    private ChoiceBox<BurgerBun> bunChoice;
    @FXML
    private ChoiceBox<BurgerCheese> cheeseChoice;
    @FXML
    private ChoiceBox<BurgerMeat> meatChoice;
    @FXML
    private ChoiceBox<BurgerGarnish> garnishChoice;
    @FXML
    private ChoiceBox<BurgerGarnish> garnishChoice2;
    @FXML
    private ChoiceBox<BurgerGarnish> garnishChoice3;
    @FXML
    private ChoiceBox<BurgerGarnish> garnishChoice4;
    @FXML
    private Label garnishLabel2;
    @FXML
    private Label garnishLabel3;
    @FXML
    private Label garnishLabel4;


    // Data lists
    private List<Label> extraLabels;
    private List<ChoiceBox<BurgerGarnish>> extraBoxes;
    private List<BurgerBun> buns;
    private List<BurgerCheese> cheeses;
    private List<BurgerMeat> meats;
    private List<BurgerGarnish> garnishes;

    Integer garnishCount = 1;

    @Override
    /* Used to initialize things after the root element has been processed. */
    public void initialize(URL location, ResourceBundle resources) {
        
        /* Creates lists with corresponding items */
        initBun();
        initCheese();
        initMeat();
        initGarnishes();
        
        /* Adds our ArrayList (part of collections) to the choice box */
        bunChoice.getItems().addAll(buns);
        cheeseChoice.getItems().addAll(cheeses);
        meatChoice.getItems().addAll(meats);
        garnishChoice.getItems().addAll(garnishes);
        garnishChoice2.getItems().addAll(garnishes);
        garnishChoice3.getItems().addAll(garnishes);
        garnishChoice4.getItems().addAll(garnishes);

        extraBoxes = new ArrayList<>();
        extraBoxes.add(garnishChoice2);
        extraBoxes.add(garnishChoice3);
        extraBoxes.add(garnishChoice4);

        extraLabels = new ArrayList<>();
        extraLabels.add(garnishLabel2);
        extraLabels.add(garnishLabel3);
        extraLabels.add(garnishLabel4);
    }

    @FXML
    public void addGarnishField() {
        // Limit to 4 extra garnish choices
        if (garnishCount < 4 ) {
            ChoiceBox<BurgerGarnish> choiceBox = extraBoxes.get(garnishCount-1);
            Label label = extraLabels.get(garnishCount-1);

            if (!choiceBox.isVisible()) {
                choiceBox.setVisible(true);
                choiceBox.setManaged(true);
            }
            if (!label.isVisible()) {
                label.setVisible(true);
                label.setManaged(true);
            }

            ++garnishCount;
        }
    }

    @FXML
    private void submit() {
        Integer nullCount = 3 + garnishCount;
        /* Retrieve values */
        BurgerBun selectedBun = bunChoice.getValue();
        BurgerCheese selectedCheese = cheeseChoice.getValue();
        BurgerMeat selectedMeat = meatChoice.getValue();
        BurgerGarnish selectedGarnish = garnishChoice.getValue();
        BurgerGarnish selectedGarnish2 = garnishChoice2.getValue();
        BurgerGarnish selectedGarnish3 = garnishChoice3.getValue();
        BurgerGarnish selectedGarnish4 = garnishChoice4.getValue();

        /* Make the new burger */
        Burger userBurger = new Burger();
        if ( selectedBun != null ) {
            userBurger.setBun(selectedBun);
            nullCount--;
        }
        if ( selectedCheese != null ) {
            userBurger.setCheese(selectedCheese);
            nullCount--;
        }
        if ( selectedMeat != null ) {
            userBurger.setMeat(selectedMeat);
            nullCount--;
        }
        if ( selectedGarnish != null ) {
            userBurger.addTopping(selectedGarnish);
            nullCount--;
        }
        if ( selectedGarnish2 != null ) {
            userBurger.addTopping(selectedGarnish2);
            nullCount--;
        }
        if ( selectedGarnish3 != null ) {
            userBurger.addTopping(selectedGarnish3);
            nullCount--;
        }
        if ( selectedGarnish4 != null ) {
            userBurger.addTopping(selectedGarnish4);
            nullCount--;
        }

        if (nullCount > 0 ) {
            /* Alert the user that a field was not filled out */
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Burger not added");
            alert.setHeaderText(null);
            alert.setContentText("Please select your ingredients");
            alert.showAndWait();
            /* Return early */
            return;
        }


        displayBurgerSummary(userBurger);
        BurgerManager.getInstance().addBurger(userBurger);
        
        /* Alert the user that a burger has been added */
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Burger Added");
        alert.setHeaderText(null);
        alert.setContentText("The burger was added successfully");
        alert.showAndWait();

        /* Switch to the main GUI */
        try {
            switchToMenu(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/edu/unomaha/views/Menu.fxml"));
        Stage stage;
        if (event == null) {
            // If event is null, use any node already in the scene graph (e.g., burgerVbox)
            stage = (Stage) burgerVbox.getScene().getWindow();
        } else {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        }
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("/edu/unomaha/views/styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
    

    private void displayBurgerSummary(Burger burger) {
        System.out.println(burger.toNiceString());
    }
    

    private void initBun() {
        buns = new ArrayList<BurgerBun>();
        buns.add(new BriocheBun());
        buns.add(new SesameBun());
    }

    private void initCheese() {
        cheeses = new ArrayList<>();
        cheeses.add(new AmericanCheese());
        cheeses.add(new CheddarCheese());
        cheeses.add(new SwissCheese());
    }

    private void initMeat() {
        meats = new ArrayList<>();
        meats.add(new BeefMeat());
        meats.add(new ChickenMeat());
    }

    private void initGarnishes() {
        garnishes = new ArrayList<>();
        garnishes.add(new BaconGarnish());
        garnishes.add(new FriedEggGarnish());
        garnishes.add(new GuacamoleGarnish());
        garnishes.add(new LettuceGarnish());
        garnishes.add(new OnionringGarnish());
        garnishes.add(new PicklesGarnish());
        garnishes.add(new TomatoGarnish());
    }

}
