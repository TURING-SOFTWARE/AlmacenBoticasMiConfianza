package com.boticaconfianza.boticasconfianzaalmacen;

import Conection.ConexionBD;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class LoginController implements Initializable {

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private Label lblErrors;
    
    @FXML
    private JFXPasswordField txtPass;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXButton btnIniciar;

    @FXML
    void Iniciar(ActionEvent event) throws IOException {

        String user = txtUser.getText();
        String pass = txtPass.getText();

        
        
        if (user.equals("") && pass.equals("")) {
            
            setLblError(Color.TOMATO, "Los campos están vacíos");
            
        } else {
            String sql = "SELECT * FROM usuarios Where username = ? and cotrasena = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                    dialogoAlerta.setTitle("Iniciar Sesión");
                    dialogoAlerta.setContentText("Usuario y Cotraseña correctos");
                    dialogoAlerta.initStyle(StageStyle.UTILITY);
                    dialogoAlerta.showAndWait();
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/main.fxml")));
                    stage.setScene(scene);
                    stage.show();
                }
               else if(!resultSet.next()){
                    setLblError(Color.PURPLE, "Usuario y/o Cotraseña Incorrectos");
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }

    }

    public LoginController() {
        con = ConexionBD.conDB();
    }

    
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
