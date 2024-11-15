/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelos.MDetalleVenta;
import modelos.MProducto;
import modelos.MTrabajador;
import modelos.MUsuario;

/**
 *
 * @author HACK
 */
public class VariablesEstaticas {
    public static MProducto M_P = null;
    public static MDetalleVenta M_DV = null;
    public static boolean TERMINAR = false;
    
    public static MUsuario usuarioActual;
    public static MTrabajador trabajadorActual;
    
    public static List<MProducto> lstProductosEnCarro_Venta = new ArrayList<>();
    public static List<MDetalleVenta> lstDetallesEnCarro_Venta = new ArrayList<>();
    
}
