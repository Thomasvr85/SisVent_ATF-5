/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Venta;

import Vista.Venta.CRUD.I_AgregarVenta;
import Vista.util.Mensaje;
import controlador.CGenerico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelos.MDetalleVenta;
import modelos.MVenta;

/**
 *
 * @author HACK
 */
public class CVenta extends CGenerico implements IAgregarVenta, IAnularVenta, IConsultarVenta, IListarVenta, IModificarVenta {

    ResultSet rs;

    @Override
    public int agregar(MVenta m_v) {
        return agregar(m_v, false);
    }

    @Override
    public int agregar(MVenta m_v, boolean mensaje) {

        int rowsAfected = 0;

        if (m_v != null) {

            int i = 0;
            try (Connection con = Basico.Obtener.Conexion()) {
                PreparedStatement ps = con.prepareStatement("insert into Venta values (default, ?, ?, default, ?, ?, default)");

                ps.setInt(++i, m_v.getIdCliente());
                ps.setDouble(++i, m_v.getIdTrabajador());
                ps.setDouble(++i, m_v.getTotal());
                ps.setString(++i, m_v.getMetodoPago());

                rowsAfected = ps.executeUpdate();

                if (mensaje) {
                    if (rowsAfected > 0) {
                        Mensaje.INFORMACION("Se registró la venta exitosamente.");
                    } else {
                        Mensaje.ADVERTENCIA("NO se registró la venta exitosamente.");
                    }
                }

            } catch (SQLException ex) {
                Mensaje.ERROR("ERROR: NO SE REGISTRO LA VENTA!!! : " + ex.getMessage(), "REGISTRAR VENTA");
            }
        } else {
            if (mensaje) {
                Mensaje.ADVERTENCIA("No se asignaron datos de la venta.", "REGISTRAR VENTA");
            }
        }

        return rowsAfected;
    }
// --------- GENERICO PRODUCTO ---------

    @Override
    public int ultimoIdVenta() {
        //select max(idVenta) from Venta;
        try (Connection con = Basico.Obtener.Conexion()) {
            PreparedStatement ps = con.prepareStatement("select max(idVenta) from Venta");

            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Mensaje.ERROR("ERROR: NO SE ENCUENTRA EL ÚLTIMO ID_VENTA!!! : " + ex.getMessage(), "ÚLTIMO ID VENTA");
        }
        return -1;
    }

// --------- AGREGAR PRODUCTO ---------
    @Override
    public void enableControls(I_AgregarVenta p) {
        enableControl(p.txtDniCliente);
        enableControl(p.btnBuscarDni);

        enableControl(p.txtProductoAgregar);
        enableControl(p.btnAgregarProducto);

        enableControl(p.tablaProductosVenta);

        enableControl(p.rbEfectivo);
        enableControl(p.rbYape_Plin);
        enableControl(p.rbTarjeta);

        enableControl(p.spinnerMontoDado);
        enableControl(p.btnRealizarCompra);
    }

    @Override
    public void disableControls(I_AgregarVenta p) {
        disableControl(p.txtDniCliente);
        disableControl(p.btnBuscarDni);

        disableControl(p.txtProductoAgregar);
        disableControl(p.btnAgregarProducto);

        disableControl(p.tablaProductosVenta);

        disableControl(p.rbEfectivo);
        disableControl(p.rbYape_Plin);
        disableControl(p.rbTarjeta);

        disableControl(p.spinnerMontoDado);
        disableControl(p.btnRealizarCompra);

    }

// --------- CONSULTAR PRODUCTO ---------
// --------- LISTAR PRODUCTO ---------
// --------- MODIFICAR PRODUCTO ---------
// --------- DESVINCULAR PRODUCTO ---------
}
