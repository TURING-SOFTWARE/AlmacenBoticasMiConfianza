package controllers;

import entidades.Laboratorio;
import entidades.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class ListaProductosController implements Initializable {
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

    //COLECCIONES
   //public ObservableList<Producto> listaProductos;
    //public ObservableList<Laboratorio> listaLaboratorio;
   @FXML
   private TableView<Producto>tblViewProductos;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        conexion = new ConexionBD();
//        conexion.establecerConexion();
//
//        //Inicializar listas
//        listaProductos = FXCollections.observableArrayList();
//        listaLaboratorio= FXCollections.observableArrayList();
//
//        //Llenar listas
//        Producto.llenarInformacion(conexion.getConnection(), listaProductos);
//       //Laboratorio.llenarInformacion(conexion.getConnection(), listaLaboratorio);
//
//
//        //Enlazar listas con TableView
//        tblViewProductos.setItems(listaProductos);
//
//       //Enlazar columnas con atributosp
//		clmId.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("id_producto"));
//        clmProductoNombre.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre_producto"));
//		clmTipo.setCellValueFactory(new PropertyValueFactory<Producto,String>("tipo_producto"));
//		clmPresentacion.setCellValueFactory(new PropertyValueFactory<Producto,String>("presentacion_producto"));
//		clmLote.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("lote_producto"));
//        clmFecha_vencimiento.setCellValueFactory(new PropertyValueFactory<Producto,Date>("fecha_vencimiento"));
//        clmInfo_producto.setCellValueFactory(new PropertyValueFactory<Producto,String>("info_producto"));
//        clmEstado_producto.setCellValueFactory(new PropertyValueFactory<Producto,String>("estado_producto"));
//        clmPrecio_unid.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio_unid"));
//        clmPrecio_caja.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio_caja"));
//        clmLaboratorio.setCellValueFactory(new PropertyValueFactory<Producto,Laboratorio>("laboratorio"));
//
//		conexion.cerrarConexion();
        showProducts();

    }


    public void executeQuery(String query) {
        Connection conn =getConnection() ;
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/almacenmiconfianza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","palmachris7");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Producto> getProductsList() {
        ObservableList<Producto> productsList = FXCollections.observableArrayList();
        Connection connection = getConnection();
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
                                rs.getInt("id_producto"),
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



//    public static void llenarInformacion(Connection connection,
//                                         ObservableList<Producto> lista){
//        try {
//            Statement instruccion = connection.createStatement();
//            ResultSet resultado = instruccion.executeQuery(
//
//                    "Select P.id_producto, " +
//                            "P.nombre_producto, " +
//                            "P.tipo_producto," +
//                            "P.presentacion_producto, " +
//                            "P.lote_producto, "+
//                            "P.fecha_vencimiento, "+
//                            "P.info_producto, " +
//                            "P.estado_producto, "+
//                            "P.precio_unid, " +
//                            "P.precio_caja, " +
//                            "L.id_laboratorio, "+
//                            "L.nombre_laboratorio " +
//                            "From productos P " +
//                            "Inner join laboratorio L " +
//                            "On(P.fk_laboratorio = L.id_laboratorio)" );
//
//            while(resultado.next()){
//
//                lista.add(
//                        new Producto(
//                                resultado.getInt("id_producto"),
//                                resultado.getString("nombre_producto"),
//                                resultado.getString("tipo_producto"),
//                                resultado.getString("presentacion_producto"),
//                                resultado.getInt("lote_producto"),
//                                resultado.getDate("fecha_vencimiento"),
//                                resultado.getString("info_producto"),
//                                resultado.getString("estado_producto"),
//                                resultado.getDouble("precio_unid"),
//                                resultado.getDouble("precio_caja"),
//                                new Laboratorio(resultado.getInt("id_laboratorio"),
//                                        resultado.getString("nombre_laboratorio")
//                                )
//
//                        )
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



    public void showProducts() {
        ObservableList<Producto> list = getProductsList();


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
  