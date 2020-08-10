package controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class main2Controller implements Initializable {


    public JFXDrawer Drawer;
    public JFXHamburger hamburger;

    public void minimizar(MouseEvent mouseEvent) {
    }

    public void maximizar(MouseEvent mouseEvent) {
    }

    public void cerrar(MouseEvent mouseEvent) {
    }

    public void initDrawer(){
        try {
            AnchorPane toolbar = FXMLLoader.load(getClass().getResource("/fxml/menubar.fxml"));
            Drawer.setSidePane(toolbar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1 );
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<Event>) event -> {
            task.setRate(task.getRate()*-1);
            task.play();
            if(Drawer.isHidden()){
                Drawer.open();
            }else{
                Drawer.close();
            }
        });


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDrawer();
    }
}
