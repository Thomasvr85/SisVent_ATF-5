/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Producto;

import controlador.IGenerico;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public interface IGenericoP extends IGenerico {

    void listarCategoriaA(JComboBox combo);

    MProducto consultar(JTextField id);

    MProducto consultar(String nombreProducto);

    MProducto consultar(int id);

    // ----------- Row datos producto ------------
    Object[] Row_DatosProducto_Completo(MProducto mp);

    Object[] Row_DatosProducto_DatosEsenciales(MProducto mp);

    // ----------- Consultas ------------    
    List<MProducto> listaProductosEncontrada_enBase_Al_Texto(String text);

    void encontrarProducto_Por_NombreOCategoria(JTextField txt);

    void encontrarProducto_Por_NombreOCategoria(String texto);

}
