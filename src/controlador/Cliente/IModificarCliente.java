/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Cliente;

import Vista.Cliente.CRUD.I_AgregarCliente;
import Vista.Cliente.CRUD.I_ModificarCliente;
import modelos.MCliente;

/**
 *
 * @author HACK
 */
public interface IModificarCliente extends IGenericoCliente {

    int modificar(MCliente mc);

    //UTIL
    MCliente asignarDelPanel(I_ModificarCliente p);

    void asignarAPanel(MCliente c, I_ModificarCliente p);

    void clearFields(I_ModificarCliente p);

    void enableControls(I_ModificarCliente p);

}
