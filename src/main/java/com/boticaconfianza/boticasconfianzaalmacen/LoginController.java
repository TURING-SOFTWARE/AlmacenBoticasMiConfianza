
package com.boticaconfianza.boticasconfianzaalmacen;



import Conection.ConexionBD;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
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
            dialogoAlerta.setContentText("Los campos están vacíos");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.showAndWait();
        }
        else{
            String sql = "SELECT * FROM usuarios Where username = ? and cotrasena = ?";
            try{
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
            dialogoAlerta.setTitle("Iniciar Sesión");
            dialogoAlerta.setContentText("Usuario y Cotraseña correctos");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.showAndWait();
                }

            
            }catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }


    }
    public LoginController() {
        con = ConexionBD.conDB();
    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}



