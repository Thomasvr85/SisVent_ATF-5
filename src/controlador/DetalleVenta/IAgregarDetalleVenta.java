/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DetalleVenta;

import modelos.MDetalleVenta;

/**
 *
 * @author HACK
 */
public interface IAgregarDetalleVenta extends IGenericoDetalleVenta {

    int agregarDetalleVenta(MDetalleVenta m_dv, int idVenta);

    int agregarDetalleVenta(MDetalleVenta m_dv, int idVenta, boolean mensaje);
}
