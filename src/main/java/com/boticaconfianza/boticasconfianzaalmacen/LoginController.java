/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boticaconfianza.boticasconfianzaalmacen;



import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class LoginController implements Initializable {
    
    
        @FXML
    private JFXPasswordField txtPass;

    @FXML
    private JFXTextField txtUser;
    
        @FXML
    private JFXButton btnIniciar;
        
        @FXML
    void Iniciar(ActionEvent event){
        
        String user = txtUser.getText();
        String pass = txtPass.getText();
        
        if(user.equals("") && pass.equals("")){
            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
            dialogoAlerta.setTitle("Error al Iniciar Sesión");
            dialogoAlerta.setContentText("Usuario y Cotraseña incorrectos");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.showAndWait();
        }
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
