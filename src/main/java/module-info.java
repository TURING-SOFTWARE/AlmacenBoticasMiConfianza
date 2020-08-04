module com.boticaconfianza.boticasconfianzaalmacen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
  
    
    
    opens com.boticaconfianza.boticasconfianzaalmacen to javafx.fxml;
    exports com.boticaconfianza.boticasconfianzaalmacen;
    requires com.jfoenix;
}
