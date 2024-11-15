/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Producto;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public interface IListarP extends IGenericoP {

    List<MProducto> listar();

    void asignarCamposAObjetoListarP(DefaultTableModel modelo);
}
