/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HACK
 */
public class MVenta extends M_AccionesModelos {

    private int idVenta;
    private String RUC;
    private int idCliente;
    private int idTrabajador;
    private String fechaHora;
    private double total;
    private String metodoPago;
    private int estado_Venta;

    public MVenta() {

    }

    //Para agregar/registrar
    public MVenta(int idCliente, int idTrabajador, double total, String metodoPago) {
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getEstado_Venta() {
        return estado_Venta;
    }

    public void setEstado_Venta(int estado_Venta) {
        this.estado_Venta = estado_Venta;
    }

}
