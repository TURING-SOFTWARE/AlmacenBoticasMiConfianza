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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class MainController implements Initializable {



    @FXML
    private AnchorPane myPane;


    @FXML
    private AnchorPane panel_home;


    @FXML
    private AnchorPane panel_productos;

    @FXML
    private AnchorPane panel_inventario;

    @FXML
    private AnchorPane panel_reportes;

    @FXML
    private AnchorPane panel_mantenimiento;


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



//Menus de ventana
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
    



    ///Menus
    @FXML
    void principal(MouseEvent event) {
        panel_home.toFront();
    }
    @FXML
    void productos(MouseEvent event) {
        panel_productos.toFront();
    }

    @FXML
    void inventario(MouseEvent event) {
        panel_inventario.toFront();
    }

    @FXML
    void reportes(MouseEvent event) {
        panel_reportes.toFront();
    }
    @FXML
    void mantenimiento(MouseEvent event) {
        panel_mantenimiento.toFront();
   }


//    private void loadpage(String page){
//        Parent root=null;
//        try {
//            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//           bp.setCenter(root);
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
