/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boticaconfianza.boticasconfianzaalmacen;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class MainController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private JFXButton btniMinimize;

    @FXML
    private JFXButton btnMaximizar;

    @FXML
    private JFXButton btnCerrar;

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(0);
    }
    
    int i = 1;
    @FXML
    void maximizar(MouseEvent event) {
        boolean b = false;
        
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount()> 1) {
                b = true;
            } else {
                b = false;

            }

        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreen(b);

    }

    @FXML
    void minimizar(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
