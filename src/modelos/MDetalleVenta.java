/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HACK
 */
public class MDetalleVenta extends MVenta {

    /*
     * Tabla detalle venta
    
     */
    //idVenta (Obligatorio)
    private int idDetalleVenta = -1;//default
    private int idProducto = -1;//indicar
    private int cantidadProducto = 0;//indicar
    private double subTotal = 0;//indicar
    private int estado_DetalleVenta = 1;//default

    public MDetalleVenta() {
    }

    public MDetalleVenta(int idDetalleVenta, int idProducto, int cantidadProducto, double subTotal, int estado_DetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.subTotal = subTotal;
        this.estado_DetalleVenta = estado_DetalleVenta;
    }

    public MDetalleVenta(int idProducto, int cantidadProducto, double subTotal) {
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.subTotal = subTotal;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getEstado_DetalleVenta() {
        return estado_DetalleVenta;
    }

    public void setEstado_DetalleVenta(int estado_DetalleVenta) {
        this.estado_DetalleVenta = estado_DetalleVenta;
    }

    @Override
    public String toString() {
        return "MDetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idProducto=" + idProducto + ", cantidadProducto=" + cantidadProducto + ", subTotal=" + subTotal + ", estado_DetalleVenta=" + estado_DetalleVenta + '}';
    }

}
