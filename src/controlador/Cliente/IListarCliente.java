/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Cliente;

import java.util.List;
import modelos.MCliente;

/**
 *
 * @author HACK
 */
public interface IListarCliente extends IGenericoCliente {

    List<MCliente> listar();
}
