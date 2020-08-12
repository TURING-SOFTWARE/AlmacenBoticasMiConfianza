
package controllers;

import java.net.URL;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metodos.Acciones;


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
    private JFXComboBox<?> laboratorioProducto;

    @FXML
    private JFXComboBox<?> presentacionProducto;

    @FXML
    private JFXComboBox<?> tipoProducto;

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
        String query = "INSERT into productos" +
                " VALUES (null," +
                ",'"+nombreProducto.getText()+
                ",'"+presentacionProducto.getValue().toString()+

                ",'"+nombreProducto.getText()+
                ",'"+presentacionProducto.getValue().toString()+
                ",'"+presentacionProducto.getValue().toString()+
                ",'"+precioUnidad.getText()+
                ",'"+nombreProducto.getText()+
                "''," +
                "2," +
                "'2020-08-18'," +
                "'dfd2323fdf'," +
                "'sd232fdf'," +
                "23.0," +
                "20," +
                "0," +
                "2)";



        ConexionBD.executeQuery(query);
        productosController.showProducts();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }

    
}
