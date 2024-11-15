/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Trabajador;

import Vista.util.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.MTrabajador;

/**
 *
 * @author HACK
 */
public class CTrabajador implements IConsultarTrabajador {

    @Override
    public MTrabajador consultar(int idUsuario) {
        return consultar(idUsuario, false);
    }

    @Override
    public MTrabajador consultar(int idUsuario, boolean mensaje) {
        MTrabajador m_t = null;

        try (Connection con = Basico.Obtener.Conexion()) {
            PreparedStatement ps = con.prepareStatement("select * from Trabajador where idUsuario = ?");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            int i;
            if (rs.next()) {
                m_t = new MTrabajador();
                i = 0;

                m_t.setIdTrabajador(rs.getInt(++i));
                m_t.setDniTrabajador(rs.getString(++i));
                m_t.setNombreTrabajador(rs.getString(++i));
                m_t.setApellidoPaternoTrabajador(rs.getString(++i));
                m_t.setApellidoMaternoTrabajador(rs.getString(++i));
                m_t.setDireccionTrabajador(rs.getString(++i));
                m_t.setTelTrabajador(rs.getString(++i));
                m_t.setEmailTrabajador(rs.getString(++i));
                m_t.setIdCargoTrabajador(rs.getInt(++i));
                m_t.setIdUsuario(rs.getInt(++i));
                m_t.setEstado(rs.getInt(++i));

                System.out.println("m_t = " + m_t);
            } else {
                if (mensaje) {
                    Mensaje.ADVERTENCIA("Trabajador NO ubicado");
                }
            }
        } catch (SQLException ex) {
            Mensaje.ERROR("ERROR: CONSULTAR TRABAJADOR!!! : " + ex.getMessage(), "CONSULTAR TRABAJADOR");
        }

        return m_t;
    }
}
