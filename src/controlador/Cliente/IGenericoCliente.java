/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import modelos.MCliente;

/**
 *
 * @author HACK
 */
public interface IGenericoCliente {

    int numeroNuevoCliente();

    void asignarNumeroNuevoCliente(JLabel lbl);

    void bloquearNoNumero(java.awt.event.KeyEvent evt);

    void bloquearNumeroFueraDeRango(java.awt.event.KeyEvent evt, int limit, JTextField txt);
    
    String DatosDelCliente_Esencial(MCliente c);
}
