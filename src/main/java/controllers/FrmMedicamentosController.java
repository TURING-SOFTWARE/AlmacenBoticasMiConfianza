
package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Conection.ConexionBD;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metodos.Acciones;

import static Conection.ConexionBD.getConnection;


/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class FrmMedicamentosController implements Initializable {

    Acciones acciones = new Acciones();
    ProductosController productosController= new ProductosController();
    @FXML
    private JFXTextField nombreProducto;

    @FXML
    private JFXTextField loteProducto;

    @FXML
    private JFXTextField precioUnidad;

    @FXML
    private JFXTextField precioCaja;

    @FXML
    private JFXComboBox<String> laboratorioProducto;

    @FXML
    private JFXComboBox<String> presentacionProducto;

    @FXML
    private JFXComboBox<String> tipoProducto;

    @FXML
    private JFXTextArea infoProducto;






    @FXML
    private JFXRadioButton rdbtnActivo;


    @FXML
    private JFXRadioButton rdbtnInacnt;

    @FXML
    private ToggleGroup Estado;






    @FXML
    private DatePicker datePicker;

    @FXML
    private JFXButton btnAgregar;

    @FXML
    private JFXButton btnCancelar;


    @FXML
    void Cancelar(ActionEvent event) {
    //    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    @FXML
    void agregar(MouseEvent event) {
        RadioButton selectedRadioButton = (RadioButton) Estado.getSelectedToggle();
       String query="insert into productos values (null,"+"'" +nombreProducto.getText()+"',"+
               "'"+presentacionProducto.getValue().toString()+"',"
               +Integer.parseInt(loteProducto.getText())+","+
               "'"+datePicker.getValue()+"',"+
               "'"+infoProducto.getText()+"',"+
               "'"+selectedRadioButton.getText()+"',"
               +Double.parseDouble(precioUnidad.getText())+","+
               +Double.parseDouble(precioCaja.getText())+","+
               "'"+tipoProducto.getValue().toString()+"',"+
               "2)";

     //   String query = "delete from productos where id_producto=11";
        ConexionBD.executeQuery(query);

       productosController.showProducts();
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
       stage.close();

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        presentacionProducto.getItems().add("Tableta");
        presentacionProducto.getItems().add("Jarábe");
        presentacionProducto.getItems().add("Cápsula");
        presentacionProducto.getItems().add("Grajea");


        tipoProducto.getItems().add("Genérico");
        tipoProducto.getItems().add("Marca");

        laboratorioProducto.getItems().add("1");
        laboratorioProducto.getItems().add("2");


    }

    
}
