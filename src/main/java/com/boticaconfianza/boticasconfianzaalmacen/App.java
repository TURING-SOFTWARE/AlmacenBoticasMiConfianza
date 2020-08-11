package com.boticaconfianza.boticasconfianzaalmacen;

import metodos.Acciones;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class App extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    Acciones acciones = new Acciones();
    @Override
    public void start(Stage stage) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
         stage.setMaximized(false);

//        root.setOnMousePressed(event -> {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        });
//
//        root.setOnMouseDragged(event -> {
//            stage.setX(event.getScreenX() - xOffset);
//            stage.setY(event.getScreenY() - yOffset);
//        });



        Scene scene = new Scene(root, 343, 435);
        acciones.Mover(scene,stage);
        stage.setScene(scene);
        stage.show();
        
    }


    public static void main(String[] args) {
        launch();
    }

}