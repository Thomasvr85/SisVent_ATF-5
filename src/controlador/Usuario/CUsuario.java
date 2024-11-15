/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Usuario;

import Vista.InterfazPrincipal.I_Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.MUsuario;

/**
 *
 * @author HACK
 */
public class CUsuario {

    PreparedStatement stmt = null;
    ResultSet rs = null;

    public MUsuario consultar(String user) {
        MUsuario usuario = null;

        try (Connection con = Basico.Obtener.Conexion()){
            stmt = con.prepareStatement("select * from Usuario where usuario = ?");
            stmt.setString(1, user);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new MUsuario();
                
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPwd(rs.getString("passw"));
                usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                usuario.setEstado(rs.getInt("estado"));
                
                System.out.println("usuario = " + usuario);
            }

        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return usuario;
    }
    
    
    public void agregarUsuario(MUsuario user){
        
        //String consulta = "insert into Usuario values (default, " + user.getUsuario() + "'')" ;
        
    }
    
    
    
    //Metodos Genericos
    
    public void clearFields(JTextField txt) {
        txt.setText("");
    }
    
    //Metodos I_login
    
    public void clearFields(I_Login p) {
        clearFields(p.txtUser);
        clearFields(p.txtPwd);
    }
    
}
