package controllers;

import Conection.ConexionBD;
import com.jfoenix.controls.*;
import entidades.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import metodos.Acciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class FrmEditar implements Initializable {

//    Acciones acciones = new Acciones();



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


    private Stage dialogStage;
    private Producto producto;
    private boolean okClicked = false;




    @FXML
    void Cancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();

    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            producto.setNombre_producto(nombreProducto.getText());
            producto.setEstado_producto(Estado.getSelectedToggle().toString());
            producto.setLote_producto(Integer.parseInt(loteProducto.getText()));


            okClicked = true;
            dialogStage.close();
        }
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (nombreProducto.getText() == null || nombreProducto.getText().length() == 0) {
            errorMessage += "No valido\n";
        }
        if (loteProducto.getText() == null || loteProducto.getText().length() == 0) {
            errorMessage += "No valido!\n";
        }
        if (precioUnidad.getText() == null || precioUnidad.getText().length() == 0) {
            errorMessage += "No valido!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;

        nombreProducto.setText(producto.getNombre_producto());
        Estado.setUserData(producto.getEstado_producto());
    }
}
