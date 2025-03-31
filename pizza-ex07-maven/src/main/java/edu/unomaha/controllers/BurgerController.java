package edu.unomaha.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.unomaha.burger.buns.*;
import edu.unomaha.burger.cheese.*;
import edu.unomaha.burger.meat.*;
import edu.unomaha.burger.garnishes.*;


/* Source: https://www.youtube.com/watch?v=hwCbXOM4_Qc&ab_channel=BroCode */
public class BurgerController implements Initializable {
    @FXML
    private ChoiceBox<BurgerBun> bunChoice;
    @FXML
    private ChoiceBox<BurgerCheese> cheeseChoice;
    @FXML
    private ChoiceBox<BurgerMeat> meatChoice;
    @FXML
    private ChoiceBox<BurgerGarnish> garnishChoices;

    private ArrayList<BurgerBun> buns;
    private ArrayList<BurgerCheese> cheeses;
    private ArrayList<BurgerMeat> meats;
    private ArrayList<BurgerGarnish> garnishes;



    
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
        garnishChoices.getItems().addAll(garnishes);
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
    }




}
