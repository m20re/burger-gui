package edu.unomaha.burger;

import java.util.Scanner;
import edu.unomaha.burger.buns.*;
import edu.unomaha.burger.cheese.*;
import edu.unomaha.burger.garnishes.*;
import edu.unomaha.burger.meat.*;

public class BurgerMain {
    private Burger burger;
    private Scanner input;

    public BurgerMain() {
        burger = new Burger();
        input = new Scanner(System.in);
    }

    private void inputBunChoice() {
        System.out.println("Choose a bun:");
        System.out.println("1 - Sesame Bun");
        System.out.println("2 - Brioche Bun");
        System.out.print("Your choice: ");
        boolean validChoice = false;
        while (!validChoice) {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    burger.setBun(new SesameBun());
                    validChoice = true;
                    break;
                case 2:
                    burger.setBun(new BriocheBun());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice, pick between 1-2");
            }
        }
    }

    private void inputCheeseChoice() {
        System.out.println("Choose a cheese:");
        System.out.println("1 - Cheddar");
        System.out.println("2 - Swiss");
        System.out.print("Your choice: ");
        boolean validChoice = false;
        while (!validChoice) {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    burger.setCheese(new CheddarCheese());
                    validChoice = true;
                    break;
                case 2:
                    burger.setCheese(new SwissCheese());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice, pick between 1-2");
            }
        }
    }

    private void inputMeatChoice() {
        System.out.println("Choose a meat:");
        System.out.println("1 - Beef Patty");
        System.out.println("2 - Chicken Patty");
        System.out.print("Your choice: ");
        boolean validChoice = false;
        while (!validChoice) {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    burger.setMeat(new BeefMeat());
                    validChoice = true;
                    break;
                case 2:
                    burger.setMeat(new ChickenMeat());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice, pick between 1-2");
            }
        }
    }

    private void inputGarnishChoices() {
        System.out.print("How many garnishes? ");
        int numGarnishes = input.nextInt();
        for (int i = 0; i < numGarnishes; i++) {
            System.out.println("Choose a garnish:");
            System.out.println("1 - Lettuce");
            System.out.println("2 - Tomato");
            System.out.println("3 - Onion");
            System.out.print("Your choice: ");
            boolean validChoice = false;
            while (!validChoice) {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        burger.addTopping(new LettuceGarnish());
                        validChoice = true;
                        break;
                    case 2:
                        burger.addTopping(new TomatoGarnish());
                        validChoice = true;
                        break;
                    case 3:
                        burger.addTopping(new OnionringGarnish());
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Invalid choice, pick between 1-3");
                }
            }
        }
    }

    private void showBurger() {
        burger.displaySorted();
        System.out.println("----");
        System.out.printf("%s $%.2f\n", burger.toNiceString(), burger.getPrice());
    }

    public void runMenu() {
        inputBunChoice();
        inputCheeseChoice();
        inputMeatChoice();
        inputGarnishChoices();
        showBurger();
    }

    public static void main(String[] args) {
        BurgerMain bm = new BurgerMain();
        bm.runMenu();
    }
}
