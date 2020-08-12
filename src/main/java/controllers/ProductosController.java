package controllers;

import Conection.ConexionBD;
import com.jfoenix.controls.JFXButton;
import entidades.Laboratorio;
import entidades.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metodos.Acciones;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class ProductosController implements Initializable {


    Acciones acciones = new Acciones();
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private AnchorPane myPane;


    @FXML
    private AnchorPane root_pane;
    @FXML
    private AnchorPane panel_home;


    @FXML
    private AnchorPane panel_productos;

    @FXML
    private AnchorPane panel_inventario;

    @FXML
    private AnchorPane panel_reportes;

    @FXML
    private AnchorPane panel_mantenimiento;

    @FXML
    private JFXButton btniMinimize;

    @FXML
    private JFXButton btnMaximizar;

    @FXML
    private JFXButton btnCerrar;

    @FXML
    private JFXButton btnPrincipal;

    @FXML
    private JFXButton btnProductos;

    @FXML
    private JFXButton btnInventario;

    @FXML
    private JFXButton btnReportes;

    @FXML
    private JFXButton btnMantenimiento;

    @FXML
    public TableColumn<Producto,Integer>clmId;
    @FXML
    public TableColumn<Producto, String>clmProductoNombre;
    @FXML
    public TableColumn<Producto, String>clmTipo;
    @FXML
    public TableColumn<Producto, String>clmPresentacion;
    @FXML
    public TableColumn<Producto, Integer>clmLote;
    @FXML
    public TableColumn<Producto, Date>clmFecha_vencimiento;
    @FXML
    public TableColumn<Producto, String>clmInfo_producto;
    @FXML
    public TableColumn<Producto, String>clmEstado_producto;
    @FXML
    public TableColumn<Producto, Double>clmPrecio_unid;
    @FXML
    public TableColumn<Producto, Double>clmPrecio_caja;
    @FXML
    public TableColumn<Producto, Laboratorio> clmLaboratorio;


   @FXML
   private TableView<Producto>tblViewProductos;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showProducts();

    }



    //Menus de ventana
    @FXML
    void cerrar(MouseEvent event) {
        System.exit(0);
    }

    Stage stage = null;
    @FXML
    void maximizar(MouseEvent event) {
        stage = (Stage) myPane.getScene().getWindow();
        if(stage.isMaximized())
            stage.setMaximized(false);
        else
            stage.setMaximized(true);
    }

    @FXML
    void minimizar(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);

    }




    ///Menus
    @FXML
    void principal(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Main.fxml")));

        //Mover(scene,stage);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void productos(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Productos.fxml")));


        stage.setScene(scene);
        stage.show();



    }

    @FXML
    void inventario(MouseEvent event) {

    }

    @FXML
    void reportes(MouseEvent event) {

    }
    @FXML
    void mantenimiento(MouseEvent event) {

    }










   ///Tabla////

    public ObservableList<Producto> getProductsList() {
        ObservableList<Producto> productsList = FXCollections.observableArrayList();
        Connection connection = ConexionBD.getConnection();
        String query =   "Select P.id_producto, " +
                            "P.nombre_producto, " +
                           "P.tipo_producto," +
                            "P.presentacion_producto, " +
                            "P.lote_producto, "+
                            "P.fecha_vencimiento, "+
                            "P.info_producto, " +
                            "P.estado_producto, "+
                            "P.precio_unid, " +
                            "P.precio_caja, " +
                            "L.id_laboratorio, "+
                            "L.nombre_laboratorio " +
                            "From productos P " +
                            "Inner join laboratorio L " +
                            "On(P.fk_laboratorio = L.id_laboratorio)" ;
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Producto producto;
            while(rs.next()) {
                producto = new Producto(
//                                rs.getInt("id_producto"),
                                rs.getString("nombre_producto"),
                                rs.getString("tipo_producto"),
                                rs.getString("presentacion_producto"),
                                rs.getInt("lote_producto"),
                                rs.getDate("fecha_vencimiento"),
                                rs.getString("info_producto"),
                                rs.getString("estado_producto"),
                                rs.getDouble("precio_unid"),
                                rs.getDouble("precio_caja"),
                                new Laboratorio(rs.getInt("id_laboratorio"),
                                        rs.getString("nombre_laboratorio")
                                ));

                productsList.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsList;
    }

    public void showProducts() {
        ObservableList<Producto> list = getProductsList();
//        clmId.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("id_producto"));
        clmProductoNombre.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre_producto"));
		clmTipo.setCellValueFactory(new PropertyValueFactory<Producto,String>("tipo_producto"));
		clmPresentacion.setCellValueFactory(new PropertyValueFactory<Producto,String>("presentacion_producto"));
		clmLote.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("lote_producto"));
        clmFecha_vencimiento.setCellValueFactory(new PropertyValueFactory<Producto,Date>("fecha_vencimiento"));
        clmInfo_producto.setCellValueFactory(new PropertyValueFactory<Producto,String>("info_producto"));
        clmEstado_producto.setCellValueFactory(new PropertyValueFactory<Producto,String>("estado_producto"));
        clmPrecio_unid.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio_unid"));
        clmPrecio_caja.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio_caja"));
       clmLaboratorio.setCellValueFactory(new PropertyValueFactory<Producto,Laboratorio>("laboratorio"));
        tblViewProductos.setItems(list);

    }





}