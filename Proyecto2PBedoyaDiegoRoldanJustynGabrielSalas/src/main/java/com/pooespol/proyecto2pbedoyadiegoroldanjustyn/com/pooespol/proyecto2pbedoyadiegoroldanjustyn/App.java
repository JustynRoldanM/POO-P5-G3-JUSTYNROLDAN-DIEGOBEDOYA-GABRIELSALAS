package com.pooespol.proyecto2pbedoyadiegoroldanjustyn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"), 1037, 758);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml)throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static Stage abrirNuevaVentana(String fxml,double n,double m) throws IOException {
        Stage nuevaVentana = new Stage();
        Parent root = loadFXML(fxml);
        Scene nuevaScene = new Scene(root, n, m);
        nuevaVentana.setScene(nuevaScene);
        nuevaVentana.setResizable(false);
        nuevaVentana.show();
        return nuevaVentana;
    }

    public static void main(String[] args) {
        launch();
    }
    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        App.scene = scene;
    }

}