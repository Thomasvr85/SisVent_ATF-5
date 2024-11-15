/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DetalleVenta;

import controlador.IGenerico;
import modelos.MDetalleVenta;

/**
 *
 * @author HACK
 */
public interface IGenericoDetalleVenta extends IGenerico {

    Object[] Row_DatosProducto_Completo(MDetalleVenta mdv);

    Object[] Row_DatosProducto_Boleta(MDetalleVenta mdv, int ID);

}
