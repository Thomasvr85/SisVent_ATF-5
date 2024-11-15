/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Cliente;

import Vista.Cliente.CRUD.I_ConsultarCliente;
import Vista.Cliente.CRUD.I_ModificarCliente;
import javax.swing.JTextField;
import modelos.MCliente;

/**
 *
 * @author HACK
 */
public interface IConsultarCliente extends IGenericoCliente {

    MCliente consultar(JTextField dni);

    MCliente consultar(JTextField dni, boolean mensaje);

    MCliente consultar(String dni);

    MCliente consultar(String dni, boolean mensaje);

    //UTIL
    void asignarAPanel(MCliente c, I_ConsultarCliente p);

    void enableControls(I_ConsultarCliente p);

    void disableControls(I_ModificarCliente p);

    void disableControls(I_ConsultarCliente p);

}
