package edu.unomaha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
 
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        /* Scene constructor that immediately returns a Parent within its constructor */
        scene = new Scene(loadFXML("Menu"));

        /* Store and load the css stylesheet */
        String css = this.getClass().getResource("/edu/unomaha/views/styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Input");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        /* Loads the string's passed in XML File. */
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/edu/unomaha/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
