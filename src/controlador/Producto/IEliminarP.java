/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Producto;

import Vista.Producto.CRUD.I_EliminarProducto;
import javax.swing.JTextField;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public interface IEliminarP extends IGenericoP{

    int elminarProducto(JTextField id);
    
    void asignarCamposAFormEliminarP(I_EliminarProducto f, MProducto mp);
    
    void clearCamposEliminarP(I_EliminarProducto f);
}
