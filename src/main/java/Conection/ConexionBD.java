package Conection;

import java.sql.*;

public class ConexionBD {
    
    
     // Connection conn = null;
    private Connection connection;


    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }




    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/almacenmiconfianza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","palmachris7");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
           return null;
        }
    }

    public Connection establecerConexion(){
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


    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}