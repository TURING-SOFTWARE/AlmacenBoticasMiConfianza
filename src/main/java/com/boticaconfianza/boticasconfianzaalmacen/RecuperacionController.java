/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boticaconfianza.boticasconfianzaalmacen;

import Conection.ConexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class RecuperacionController implements Initializable {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
     @FXML
    private JFXTextField txtval;
    @FXML
    private JFXButton lblreturn;
    
    @FXML
    private Label lblErrors;
      @FXML
    private JFXButton btnValidar;

    

    @FXML
    void Validar(ActionEvent event) throws IOException {
        String val = txtval.getText();
        
        if (val.equals("")) {
            
            setLblError(Color.TOMATO, "Los campos están vacíos");
            
        } else {
            String sql = "SELECT * FROM usuarios Where recuperacion = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, val);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                    dialogoAlerta.setTitle("Recuperacion");
                    dialogoAlerta.setContentText("Su usuario es:admin"+"y su contraseña:admin");
                    dialogoAlerta.initStyle(StageStyle.UTILITY);
                    dialogoAlerta.showAndWait();
                    
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/login.fxml")));
                    stage.setScene(scene);
                    stage.show();
                }
               else if(!resultSet.next()){
                    setLblError(Color.PURPLE, "Clave incorrecta");
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }
    }

    @FXML
    void regresar(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/login.fxml")));
                    stage.setScene(scene);
                    stage.show();
    }
    
   

    
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }
    
    
    public RecuperacionController() {
        con = ConexionBD.conDB();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
