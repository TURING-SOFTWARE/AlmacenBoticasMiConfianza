
package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author palmachris7
 */
public class FrmMedicamentosController implements Initializable {


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
    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }

    
}
