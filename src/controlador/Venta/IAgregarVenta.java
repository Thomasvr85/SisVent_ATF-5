/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.Venta;

import Vista.Venta.CRUD.I_AgregarVenta;
import java.util.List;
import modelos.MProducto;
import modelos.MVenta;

/**
 *
 * @author HACK
 */
public interface IAgregarVenta extends IGenericoVenta {

    int agregar(MVenta m_v);
    
    int agregar(MVenta m_v, boolean mensaje);

    //UTIL
    void enableControls(I_AgregarVenta p);

    void disableControls(I_AgregarVenta p);
}
