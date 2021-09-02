/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;

/**
 *
 * @author jcastrio
 */
public class Conexion {
    
    //Atributos de clase para gestión de conexión con la base de datos    
    private static final String UBICACION_BD = "ProyectosConstruccion.db";

    String url = "jdbc:sqlite:" + UBICACION_BD;
    
    Connection conn = null;
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
    
    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión Exitosa");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ResultSet consultarRegistros (String url){
        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
