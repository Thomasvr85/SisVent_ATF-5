/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Vista.util.Mensaje;
import javax.swing.JTextField;
import static modelos.E_TipoAccion.*;

/**
 *
 * @author HACK
 */
public class MProducto extends MCategoria {

    
    private int inicial = -1;
    private int idProducto = inicial;
    private String nombreProducto;
    private double precioProducto = inicial;
    private int stockProducto = inicial;
    private String descripcionProducto;
    private int estadoProducto = 1;

    public MProducto() {

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    

    private boolean noVacio(String campo) {
        if (campo.isEmpty()) {
            Mensaje.ADVERTENCIA("El campo (cadena) : " + campo + " está vacio");
        }
        return !campo.isEmpty();
    }

    private boolean noVacio(int campo) {

        if (campo == inicial) {
            Mensaje.ADVERTENCIA("El campo (entero) : " + campo + " está vacio");
        }
        return campo != inicial;
    }

    private boolean noVacio(double campo) {
        if (campo == inicial) {
            Mensaje.ADVERTENCIA("El campo (real) : " + campo + " está vacio");
        }

        return campo != inicial;
    }

    public boolean noVacio(E_TipoAccion tipo) {
        boolean datos = true;

        switch (tipo) {
            case MODIFICAR -> {
                datos
                        = datos
                        && noVacio(estadoProducto)
                        && estructuraCorrectaNombreCategoria();
                System.out.println("Pasa por: Modificar");
            }

            case CONSULTAR, ELMIMNAR -> {
                datos
                        = datos && noVacio(idProducto);
                System.out.println("Pasa por: Consultar O Eliminar");
            }

            case AGREGAR -> {
                datos = datos
                        && noVacio(nombreProducto)
                        && noVacio(precioProducto)
                        && noVacio(stockProducto)
                        && noVacio(descripcionProducto)
                        && estructuraCorrectaNombreCategoria();
                System.out.println("Pasa por: Agregar");
            }

            case AUMENTAR -> {
                datos = datos
                        && noVacio(idProducto)
                        && noVacio(precioProducto)
                        && noVacio(stockProducto)
                        && noVacio(descripcionProducto)
                        && estructuraCorrectaNombreCategoria();
                System.out.println("Pasa por: Aumentar");
            }

        }

        return datos;
    }

    @Override
    public String toString() {
        return "MProducto{" + "inicial=" + inicial + ", idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", stockProducto=" + stockProducto + ", descripcionProducto=" + descripcionProducto + ", estadoProducto=" + estadoProducto + '}';
    }
    
    

}
