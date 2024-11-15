/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Producto;

import Vista.Producto.CRUD.I_ConsultarProducto;
import javax.swing.JTextField;
import modelos.MProducto;
import controlador.IGenerico;

/**
 *
 * @author HACK
 */
public interface IConsultarP extends IGenerico {

    MProducto consultar(JTextField id);

    MProducto consultar(int id);
    
    MProducto consultar(String nombreProducto);
    
    MProducto consultar(String nombreProducto, boolean mensaje);

    void clearCamposConsultarP(I_ConsultarProducto f);

    void asignarCamposAFormConsultarP(I_ConsultarProducto f, MProducto mp);
}
