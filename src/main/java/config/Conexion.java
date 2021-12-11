	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.net.ConnectException;
import java.sql.*;

public class Conexion 
{
    public String driver="com.mysql.jdbc.Driver";
    
    
    public Connection getConnection()
    {
        Connection conexion=null;
        try
        {
            Class.forName(driver);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/codoacodo2021","root","");
        }
        catch(ClassNotFoundException|SQLException e)
        {
                    System.out.println(e);
        }
        return conexion;    
    }   

    
public static void main(String [] args) throws SQLException
{
    Connection conexion=null;
    Conexion con=new Conexion();
    conexion =con.getConnection();
    
    PreparedStatement ps;
    ResultSet rs;
    
    ps=conexion.prepareStatement("select * from alumnos");
    rs=ps.executeQuery();
    
    while(rs.next())
    {
     int id=rs.getInt("id");
     String nombre=rs.getString("nombre");
     String apellido=rs.getString("apellido");
     String mail=rs.getString("mail");     
     System.out.println("id:"+id+" Nombre:"+nombre+" Apellido:"+apellido+" Mail:"+mail);
    }   
    

}



}