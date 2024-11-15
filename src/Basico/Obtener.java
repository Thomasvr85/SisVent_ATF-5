/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basico;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author HACK
 */
public class Obtener extends VarConf {

    public static Image icono(Object o){
        return (new ImageIcon(o.getClass().getResource(URL_Icono_SisVent)).getImage());
    }
    
    public static Connection Conexion() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (conexion != null) {
            System.out.println("Conexión exitosa a la base de datos MySQL.");
        }

        return conexion;
    }
}
