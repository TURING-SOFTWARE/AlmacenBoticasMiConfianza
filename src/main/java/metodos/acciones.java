package metodos;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class acciones {
    private double xOffset = 0;
    private double yOffset = 0;

    public void Mover(Scene scene, Stage stage){

        scene.setOnMousePressed(event1 -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });

        scene.setOnMouseDragged(event12 -> {
            stage.setX(event12.getScreenX() - xOffset);
            stage.setY(event12.getScreenY() - yOffset);
        });

        stage.setScene(scene);

        stage.show();




    }


    public void Nuevaventana(String string){
        try {

            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/fxml/"+string+".fxml"));
            Parent ventana=(Parent)fxmloader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(ventana));
            stage.initStyle(StageStyle.UNDECORATED);
            Mover(ventana.getScene(), stage);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
