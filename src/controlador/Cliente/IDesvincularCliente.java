/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Cliente;

import Vista.Cliente.CRUD.I_DesvincularCliente;
import javax.swing.JTextField;
import modelos.MCliente;

/**
 *
 * @author HACK
 */
public interface IDesvincularCliente extends IGenericoCliente {

    int desvincular(JTextField dni);

    //UTIL
    void asignarAPanel(MCliente c, I_DesvincularCliente p);

    void clearFields(I_DesvincularCliente p);
}
