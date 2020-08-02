module com.proyecto.boticasmiconfianza {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.proyecto.boticasmiconfianza to javafx.fxml;
    exports com.proyecto.boticasmiconfianza;
}
