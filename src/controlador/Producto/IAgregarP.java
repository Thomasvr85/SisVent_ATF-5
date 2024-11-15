/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Producto;

import Vista.Producto.CRUD.I_AgregarProducto;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public interface IAgregarP extends IGenericoP {

    int siguienteNumeroProducto();

    int agregar(MProducto mp);

    int aumentar(MProducto mp);

    MProducto asignarCamposAObjetoAgregarP(I_AgregarProducto f);

    void asignarCamposFormAgregarP(I_AgregarProducto f, MProducto mp);

    void clearCamposAgregarP(I_AgregarProducto f);

    void habilitarControles(I_AgregarProducto f);

    void desabilitarControles(I_AgregarProducto f);

}
