/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DetalleVenta;

import Vista.Venta.CRUD.I_EncontrarProducto;
import Vista.util.Mensaje;
import controlador.CGenerico;
import controlador.Producto.CProducto;
import controlador.Producto.IListarP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import modelos.MDetalleVenta;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public class CDetalleVenta extends CGenerico implements IAgregarDetalleVenta, IAnularDetalleVenta, IConsultarDetalleVenta, IListarDetalleVenta, IModificarDetalleVenta, IGenericoDetalleVenta {

    CProducto cp = new CProducto();

    @Override
    public int agregarDetalleVenta(MDetalleVenta m_dv, int idVenta) {
        return agregarDetalleVenta(m_dv, idVenta, false);
    }

    @Override
    public int agregarDetalleVenta(MDetalleVenta m_dv, int idVenta, boolean mensaje) {
        int rowsAfected = 0;

        if (m_dv != null) {

            int i = 0;
            try (Connection con = Basico.Obtener.Conexion()) {

                PreparedStatement ps = con.prepareStatement("insert into DetalleVenta values (default, ?, ?, ?, ?, default)");
                ps.setInt(++i, idVenta);
                ps.setInt(++i, m_dv.getIdProducto());
                ps.setInt(++i, m_dv.getCantidadProducto());
                ps.setDouble(++i, m_dv.getSubTotal());

                rowsAfected = ps.executeUpdate();
                if (mensaje) {
                    if (rowsAfected > 0) {
                        Mensaje.INFORMACION("Se registró el detalle_venta exitosamente.");
                    } else {
                        Mensaje.ADVERTENCIA("NO se registró el detalle_venta exitosamente.");
                    }
                }
            } catch (SQLException ex) {
                Mensaje.ERROR("ERROR: NO SE AGREGO EL DETALLE_VENTA!!! : " + ex.getMessage(), "AGREGAR DETALLE_VENTA");
            }

        } else {
            if (mensaje) {
                Mensaje.ADVERTENCIA("No se asignaron datos al detalle_venta.", "REGISTRAR DETALLE_VENTA");
            }
        }

        return rowsAfected;
    }

    // --------- GNERICO PRODUCTO ---------
    @Override
    public Object[] Row_DatosProducto_Completo(MDetalleVenta mdv) {
        Object[] fila = {
            mdv.getIdDetalleVenta(),
            mdv.getIdVenta(),
            mdv.getIdProducto(),
            mdv.getCantidadProducto(),
            mdv.getSubTotal(),
            mdv.getEstado_Venta()
        };

        return fila;
    }

    @Override
    public Object[] Row_DatosProducto_Boleta(MDetalleVenta mdv, int ID) {
        MProducto mp = cp.consultar(mdv.getIdProducto());
        Object[] fila = {
            ID,
            mdv.getCantidadProducto(),
            mp.getNombreProducto(),
            mp.getDescripcionProducto(),
            mp.getPrecioProducto(),
            mdv.getSubTotal()
        };

        return fila;
    }

}
