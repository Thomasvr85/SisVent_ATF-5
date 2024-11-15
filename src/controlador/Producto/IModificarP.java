/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Producto;

import Vista.Producto.CRUD.I_ModificarProducto;
import javax.swing.JComboBox;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public interface IModificarP extends IGenericoP {

    int modificar(MProducto p);

    int modificar(MProducto p, boolean mensaje);

    void asignarCamposAFormModificarP(I_ModificarProducto f, MProducto mp);

    void habilitarControlesModificarP(I_ModificarProducto f);

    void deshabilitarControlesModificarP(I_ModificarProducto f);

    void clearCamposModificarP(I_ModificarProducto f);

    MProducto asignarCamposAObjetoModificarP(I_ModificarProducto f);
}
