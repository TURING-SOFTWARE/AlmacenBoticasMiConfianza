package com.boticaconfianza.boticasconfianzaalmacen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
         stage.initStyle(StageStyle.UNDECORATED);
         stage.setMaximized(false);
        
        
        
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

       
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
        
        
        
        scene = new Scene(root, 330, 412);
        stage.setScene(scene);
        stage.show();
        
    }

    

    public static void main(String[] args) {
        launch();
    }

}