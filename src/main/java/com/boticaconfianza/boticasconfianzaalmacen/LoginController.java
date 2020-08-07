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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class LoginController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private Label lblErrors;

    @FXML
    private Label lblRecup;

    @FXML
    private JFXPasswordField txtPass;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXButton btnIniciar;

    @FXML
    private JFXButton btnminimize;

    @FXML
    private JFXButton btnclose;
    
    
    public void Iniciando(ActionEvent event) throws IOException{
       
        String user = txtUser.getText();
        String pass = txtPass.getText();

        if (user.equals("") && pass.equals("")) {

            setLblError(Color.TOMATO, "Los campos están vacíos");

        } else {
            String sql = "SELECT * FROM usuarios Where username = ? and contrasena = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
//                    Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
//                    dialogoAlerta.setTitle("Iniciar Sesión");
//                    dialogoAlerta.setContentText("Usuario y Contraseña correctos");
//                    dialogoAlerta.initStyle(StageStyle.UTILITY);
//                    dialogoAlerta.showAndWait();
                    
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/main9.fxml")));
                    
        
                    scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            xOffset = event.getSceneX();
                            yOffset = event.getSceneY();
                        }
                    });

                    scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            stage.setX(event.getScreenX() - xOffset);
                            stage.setY(event.getScreenY() - yOffset);
                        }
                    });
                    
                    
                    stage.setScene(scene);
                    stage.setFullScreen(true);
                    stage.show();
                     
                     
                     
                } else if (!resultSet.next()) {
                    setLblError(Color.PURPLE, "Usuario y/o Cotraseña Incorrectos");
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }


    

}
    
    
    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        
       Iniciando (event);

    }

    
    
    @FXML
    void presionar(KeyEvent event) throws IOException {
        
        String user = txtUser.getText();
        String pass = txtPass.getText();

        if (user.equals("") && pass.equals("")) {

            setLblError(Color.TOMATO, "Los campos están vacíos");

        } else {
            String sql = "SELECT * FROM usuarios Where username = ? and contrasena = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                    dialogoAlerta.setTitle("Iniciar Sesión");
                    dialogoAlerta.setContentText("Usuario y Contraseña correctos");
                    dialogoAlerta.initStyle(StageStyle.UTILITY);
                    dialogoAlerta.showAndWait();
                    
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/main.fxml")));
                    
        
                    scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            xOffset = event.getSceneX();
                            yOffset = event.getSceneY();
                        }
                    });

                    scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            stage.setX(event.getScreenX() - xOffset);
                            stage.setY(event.getScreenY() - yOffset);
                        }
                    });
                    
                    
                    stage.setScene(scene);
                    //stage.setFullScreen(true);
                    stage.show();
                     
                     
                     
                } else if (!resultSet.next()) {
                    setLblError(Color.PURPLE, "Usuario y/o Cotraseña Incorrectos");
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }
        
        

    }
    
    
    @FXML
    void recuperar(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/recuperacion.fxml")));

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void minimizar(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(0);
    }

      @FXML
        void IniciarEnter(KeyEvent event) throws IOException {
            if(event.getCode().equals(KeyCode.ENTER)){
                
        
    
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
