/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Cliente;

import Vista.Cliente.CRUD.I_AgregarCliente;
import modelos.MCliente;

/**
 *
 * @author HACK
 */
public interface IAgregarCliente extends IGenericoCliente {

    int agregar(MCliente c);

    //UTIL
    MCliente asignarDelPanel(I_AgregarCliente p);

    void clearFields(I_AgregarCliente p);
}
