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
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane myPane;

    
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
    
    Stage stage = null;
    
    
    @FXML
    void maximizar(MouseEvent event) {
        
        
       stage = (Stage) myPane.getScene().getWindow();
       if(stage.isMaximized())
           stage.setMaximized(false);
       else
           stage.setMaximized(true);

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
