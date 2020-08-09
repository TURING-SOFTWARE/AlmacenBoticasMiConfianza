module com.boticaconfianza.boticasconfianzaalmacen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires com.jfoenix;



    opens controllers to javafx.fxml;
    exports com.boticaconfianza.boticasconfianzaalmacen;
    
    
}
