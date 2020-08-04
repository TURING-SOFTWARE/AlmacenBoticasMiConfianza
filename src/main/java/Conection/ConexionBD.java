
package Conection;

import java.sql.*;

public class ConexionBD {
    
    Connection con;
    
    public ConexionBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            ///con = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenmiconfianza","root","root");
            con = DriverManager.getConnection("jdbc:mysql://localhost/almacenmiconfianza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
        }catch(Exception e){
            System.err.println("Error: "+e);
        }
        
    }
    
    public static void main(String[] args){
        ConexionBD cn=new ConexionBD();
        Statement st;
        ResultSet rs;
        try{
            st= cn.con.createStatement();
            rs=st.executeQuery("select * from usuarios");
            while (rs.next()){
                System.out.println(rs.getInt("id")+ " " + rs.getString("username") + " " + rs.getString("cotrasena")
                + " "+ rs.getString("recuperacion"));
        }
            cn.con.close();
        }catch(Exception e){
            System.err.println("Error: "+e);
            
        }
        
        }
    }
    
    
    

