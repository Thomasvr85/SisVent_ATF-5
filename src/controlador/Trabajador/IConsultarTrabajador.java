/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Trabajador;

import modelos.MTrabajador;

/**
 *
 * @author HACK
 */
public interface IConsultarTrabajador {

    MTrabajador consultar(int id);

    MTrabajador consultar(int id, boolean mensaje);
}
