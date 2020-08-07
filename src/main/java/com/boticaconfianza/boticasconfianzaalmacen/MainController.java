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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    private JFXButton btnPrincipal;

    @FXML
    private JFXButton btnProductos;

    @FXML
    private JFXButton btnInventario;

    @FXML
    private JFXButton btnReportes;

    @FXML
    private JFXButton btnMantenimiento;


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
    void inventario(MouseEvent event) {

    }

    @FXML
    void mantenimiento(MouseEvent event) {

    }

       @FXML
    void principal(MouseEvent event) {

    }

    @FXML
    void productos(MouseEvent event) {

    }

    @FXML
    void reportes(MouseEvent event) {

    }  

    private void loadpage(String page){
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
