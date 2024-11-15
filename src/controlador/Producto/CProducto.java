/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Producto;

import controlador.Categoria.CCategoria;
import Vista.Producto.CRUD.*;
import Vista.Venta.CRUD.I_EncontrarProducto;
import Vista.util.Mensaje;
import controlador.CGenerico;
import java.util.List;
import modelos.MProducto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.E_TipoAccion;
import modelos.MCategoria;

/**
 *
 * @author HACK
 */
public class CProducto extends CGenerico implements IAgregarP, IModificarP, IConsultarP, IEliminarP, IListarP {

    CCategoria ccat = new CCategoria();

    @Override
    public List<MProducto> listar() {
        List<MProducto> mps = new ArrayList<>();
        MProducto mp = null;
        try (Connection con = Basico.Obtener.Conexion()) {
            PreparedStatement ps = con.prepareStatement("select * from Producto");
            ResultSet rs = ps.executeQuery();
            int i;
            while (rs.next()) {
                mp = new MProducto();
                i = 0;
                mp.setIdProducto(rs.getInt(++i));
                mp.setNombreProducto(rs.getString(++i));
                mp.setPrecioProducto(rs.getDouble(++i));
                mp.setStockProducto(rs.getInt(++i));
                mp.setDescripcionProducto(rs.getString(++i));
                mp.setIdCategoria(rs.getInt(++i));
                mp.setEstadoProducto(rs.getInt(++i));

                mp.setNombreCategoria(ccat.consultar(mp.getIdCategoria()).getNombreCategoria());

                mps.add(mp);
            }

        } catch (SQLException ex) {
            Mensaje.ERROR("ERROR: al Listar productos!!! : " + ex.getMessage(), "Listar Producto");
        }

        return mps;
    }

    @Override
    public MProducto consultar(JTextField id) {
        return consultar(id, true);
    }

    public MProducto consultar(int id) {
        return consultar(id, false);
    }

    private MProducto consultar(JTextField id, boolean mensaje) {
        return consultar(Integer.parseInt(id.getText()), mensaje);
    }

    private MProducto consultar(int id, boolean mensaje) {
        MProducto mp = null;

        try (Connection con = Basico.Obtener.Conexion()) {
            PreparedStatement ps = con.prepareStatement("select * from Producto where idProducto = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            int i;
            if (rs.next()) {
                mp = new MProducto();
                i = 0;
                mp.setIdProducto(rs.getInt(++i));
                mp.setNombreProducto(rs.getString(++i));
                mp.setPrecioProducto(rs.getDouble(++i));
                mp.setStockProducto(rs.getInt(++i));
                mp.setDescripcionProducto(rs.getString(++i));
                mp.setIdCategoria(rs.getInt(++i));
                mp.setEstadoProducto(rs.getInt(++i));

                mp.setNombreCategoria(ccat.consultar(mp.getIdCategoria()).getNombreCategoria());
            } else {
                if (mensaje) {
                    Mensaje.ADVERTENCIA("Producto NO ubicado");
                }
            }
        } catch (SQLException ex) {
            Mensaje.ERROR("ERROR: CONSULTAR PRODUCTO!!! : " + ex.getMessage(), "CONSULTAR PRODUCTO");
        }

        return mp;
    }

    public MProducto consultar(String nombreProducto) {
        return consultar(nombreProducto, false);
    }

    public MProducto consultar(String nombreProducto, boolean mensaje) {
        MProducto mp = null;

        try (Connection con = Basico.Obtener.Conexion()) {
            PreparedStatement ps = con.prepareStatement("select * from Producto where nombreProducto = ?");
            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();

            int i;
            if (rs.next()) {
                mp = new MProducto();
                i = 0;
                mp.setIdProducto(rs.getInt(++i));
                mp.setNombreProducto(rs.getString(++i));
                mp.setPrecioProducto(rs.getDouble(++i));
                mp.setStockProducto(rs.getInt(++i));
                mp.setDescripcionProducto(rs.getString(++i));
                mp.setIdCategoria(rs.getInt(++i));
                mp.setEstadoProducto(rs.getInt(++i));

                mp.setNombreCategoria(ccat.consultar(mp.getIdCategoria()).getNombreCategoria());
            } else {
                if (mensaje) {
                    Mensaje.ADVERTENCIA("Producto NO ubicado");
                }
            }
        } catch (SQLException ex) {
            Mensaje.ERROR("ERROR: CONSULTAR PRODUCTO!!! : " + ex.getMessage(), "CONSULTAR PRODUCTO");
        }

        return mp;
    }

    @Override
    public int siguienteNumeroProducto() {
        return listar().size() + 1;
    }

    /*
        Evitar que se duplique el producto
        Agregar si existe
     */
    @Override
    public int agregar(MProducto mp) {

        int rowsAfected = 0;

        if (mp != null) {
            if (consultar(mp.getNombreProducto()) == null) {
                if (mp.noVacio(E_TipoAccion.AGREGAR) && mp.estructuraCorrectaNombreCategoria()) {

                    MCategoria mcat = ccat.consultar(mp.getNombreCategoria());
                    if (mcat == null) {
                        ccat.agregar(mp.getNombreCategoria());
                        mcat = ccat.consultar(mp.getNombreCategoria());
                    }

                    mp.setIdCategoria(mcat.getIdCategoria());

                    int i = 0;
                    try (Connection con = Basico.Obtener.Conexion()) {
                        PreparedStatement ps = con.prepareStatement("insert into Producto values (default, ?, ?, ?, ?, ?, default)");
                        ps.setString(++i, mp.getNombreProducto());
                        ps.setDouble(++i, mp.getPrecioProducto());
                        ps.setInt(++i, mp.getStockProducto());
                        ps.setString(++i, mp.getDescripcionProducto());
                        ps.setInt(++i, mp.getIdCategoria());

                        rowsAfected = ps.executeUpdate();
                        if (rowsAfected > 0) {
                            Mensaje.INFORMACION("Se agregó el producto exitosamente.");
                        } else {
                            Mensaje.ADVERTENCIA("NO agregó el producto exitosamente.");
                        }
                    } catch (SQLException ex) {
                        Mensaje.ERROR("ERROR: NO SE AGREGO EL PRODUCTO!!! : " + ex.getMessage(), "AGREGAR PRODUCTO");
                    }
                } else {
                    Mensaje.INFORMACION("No se asignaron todos o parcialmente los datos del producto.");
                }
            } else {
                return -1;
            }
        } else {
            Mensaje.ADVERTENCIA("No se asignaron datos del producto.", "AGREGAR PRODUCTO");
        }

        return rowsAfected;
    }

    @Override
    public int aumentar(MProducto mp) {
        int rowsAfected = 0;

        if (mp != null && mp.estructuraCorrectaNombreCategoria()) {
            if (mp.noVacio(E_TipoAccion.AUMENTAR)) {
                int i = 0;
                try (Connection con = Basico.Obtener.Conexion()) {
                    PreparedStatement ps = con.prepareStatement("update Producto set stockProducto = ? where idProducto = ?");
                    ps.setInt(++i, mp.getStockProducto());
                    ps.setInt(++i, mp.getIdProducto());

                    rowsAfected = ps.executeUpdate();
                    if (rowsAfected > 0) {
                        Mensaje.INFORMACION("Se Aumento el Stock del producto exitosamente.");
                    } else {
                        Mensaje.ADVERTENCIA("NO se Aumento el Stock del producto!");
                    }
                } catch (SQLException ex) {
                    Mensaje.ERROR("ERROR: NO SE AUMENTO EL PRODUCTO!!! : " + ex.getMessage(), "AUMENTAR PRODUCTO");
                }
            } else {
                Mensaje.INFORMACION("No se asignaron todos o parcialmente los datos del producto.");
            }
        } else {
            Mensaje.ADVERTENCIA("No se asignaron datos del producto.", "AUMENTO PRODUCTO");
        }

        return rowsAfected;
    }

    /*
    Verificar la existencia de la categoria (crearla de no existir)
        -actualizar idCategoria
    Verificar noVacio
    
     */
    @Override
    public int modificar(MProducto mp) {
        return modificar(mp, false);
    }

    @Override
    public int modificar(MProducto mp, boolean mensaje) {
        int rowsAfected = 0;

        if (mp != null && mp.estructuraCorrectaNombreCategoria()) {
            MCategoria mcat = ccat.consultar(mp.getNombreCategoria());
            if (mcat == null) {
                ccat.agregar(mp.getNombreCategoria());
                mcat = ccat.consultar(mp.getNombreCategoria());
            }

            mp.setIdCategoria(mcat.getIdCategoria());
            if (mp.noVacio(E_TipoAccion.MODIFICAR)) {
                int i = 0;
                try (Connection con = Basico.Obtener.Conexion()) {
                    //PreparedStatement preparedStatement = con.prepareStatement("update cliente set estado = ? where dniCliente = ?");
                    PreparedStatement ps = con.prepareStatement("update Producto  set nombreProducto = ?, precioProducto = ?, stockProducto = ?, descripcionProducto = ?, idCategoria = ?, estado = ? where idProducto = ?");

                    ps.setString(++i, mp.getNombreProducto());
                    ps.setDouble(++i, mp.getPrecioProducto());
                    ps.setInt(++i, mp.getStockProducto());
                    ps.setString(++i, mp.getDescripcionProducto());
                    ps.setInt(++i, mp.getIdCategoria());
                    ps.setInt(++i, mp.getEstadoProducto());
                    //parametro where
                    ps.setInt(++i, mp.getIdProducto());

                    rowsAfected = ps.executeUpdate();
                    if (mensaje) {
                        if (rowsAfected > 0) {
                            Mensaje.INFORMACION("Se Modificó el producto exitosamente.");
                        } else {
                            Mensaje.ADVERTENCIA("NO se Modificó el producto!");
                        }
                    }
                } catch (SQLException ex) {
                    Mensaje.ERROR("ERROR: NO SE MODIFICO EL PRODUCTO!!! : " + ex.getMessage(), "MODIFICAR PRODUCTO");
                }
            } else {
                if (mensaje) {
                    Mensaje.INFORMACION("No se asignaron todos o parcialmente los datos del producto.");
                }
            }
        } else {
            if (mensaje) {
                Mensaje.ADVERTENCIA("No se asignaron datos del producto.", "MODIFICAR PRODUCTO");
            }
        }

        return rowsAfected;
    }

    @Override
    public int elminarProducto(JTextField id) {
        int _id = Integer.parseInt(id.getText());
        int rowsAfected = 0;
        MProducto mp = consultar(_id);
        if (mp != null) {
            try (Connection con = Basico.Obtener.Conexion()) {
                PreparedStatement ps = con.prepareStatement("update producto set estado = 0 where idProducto = ?");
                ps.setInt(1, _id);
                rowsAfected = ps.executeUpdate();
                if (rowsAfected > 0) {
                    Mensaje.INFORMACION("Producto deshabilitado con exito!");
                }
            } catch (SQLException ex) {
                Mensaje.ERROR("ERROR: NO SE ELIMINÓ EL PRODUCTO: " + ex.getMessage(), "ELIMINAR PRODUCTO");
            }
        } else {
            Mensaje.ADVERTENCIA("No se encontró el producto", "ELIMINAR PRODUCTO");
        }

        return rowsAfected;
    }

    // --------- GENERICO PRODUCTO ---------
    @Override
    public void listarCategoriaA(JComboBox combo) {
        clear(combo, true);
        for (MCategoria mc : ccat.listar()) {
            combo.addItem(mc.getNombreCategoria());
        }
    }

    @Override
    public Object[] Row_DatosProducto_Completo(MProducto mp) {
        Object[] fila = {
            mp.getIdProducto(),
            mp.getNombreProducto(),
            mp.getPrecioProducto(),
            mp.getStockProducto(),
            mp.getDescripcionProducto(),
            mp.getNombreCategoria(),
            textTipoEstadoProducto(mp.getEstadoProducto())
        };

        return fila;
    }

    @Override
    public Object[] Row_DatosProducto_DatosEsenciales(MProducto mp) {
        Object[] fila = {
            mp.getIdProducto(),
            mp.getNombreProducto(),
            mp.getPrecioProducto(),
            mp.getStockProducto(),
            mp.getDescripcionProducto(),
            mp.getNombreCategoria(),};

        return fila;
    }

    @Override
    public List<MProducto> listaProductosEncontrada_enBase_Al_Texto(String text) {
        List<MProducto> mps = new ArrayList<>();

        //Lista productos de la base de datos
        for (MProducto _mp : new CProducto().listar()) {
            //cadena que contienen el nombre y categoria del producto
            String cadena = (_mp.getNombreProducto() + " - (" + _mp.getNombreCategoria() + ")").toLowerCase();

            //la cadena contiene el texto en mencion
            if (cadena.contains(text.toLowerCase()) && _mp.getEstadoProducto() == 1) {
                mps.add(_mp);
            }
        }

        return mps;
    }

    @Override
    public void encontrarProducto_Por_NombreOCategoria(JTextField txt) {
        encontrarProducto_Por_NombreOCategoria(txt.getText());
    }

    @Override
    public void encontrarProducto_Por_NombreOCategoria(String texto) {
        List<MProducto> mps = listaProductosEncontrada_enBase_Al_Texto(texto);
        if (mps.isEmpty()) {
            Mensaje.INFORMACION("No se encontró producto registrado.", "Producto no agregado");
        } else {
            I_EncontrarProducto iep = new I_EncontrarProducto(mps);
            iep.setVisible(true);
        }
    }

    // --------- AGREGAR PRODUCTO ---------
    @Override
    public void asignarCamposFormAgregarP(I_AgregarProducto f, MProducto mp) {
        setContent(mp.getNombreProducto(), f.txtNombre);
        setContent(mp.getPrecioProducto(), f.txtPrecio);
        setContent(mp.getStockProducto(), f.txtStock);
        setContent(mp.getDescripcionProducto(), f.txtDescripcion);
        setContent(mp.getNombreCategoria(), f.comboCategoria);

    }

    @Override
    public void habilitarControles(I_AgregarProducto f) {
        enableControl(f.txtIDBusqueda);
        enableControl(f.txtNombre);
        enableControl(f.txtPrecio);
        enableControl(f.txtStock);
        enableControl(f.txtDescripcion);
        enableControl(f.comboCategoria, true);
    }

    @Override
    public void desabilitarControles(I_AgregarProducto f) {
        disableControl(f.txtIDBusqueda);
        disableControl(f.txtNombre);
        disableControl(f.txtPrecio);
        disableControl(f.txtStock);
        disableControl(f.txtDescripcion);
        disableControl(f.comboCategoria);
    }

    @Override
    public MProducto asignarCamposAObjetoAgregarP(I_AgregarProducto f) {
        MProducto mp = new MProducto();
        mp.setIdProducto(numberEntero(f.txtIDBusqueda));
        mp.setNombreProducto(text(f.txtNombre));
        mp.setPrecioProducto(numberReal(f.txtPrecio));
        mp.setStockProducto(numberEntero(f.txtStock));
        mp.setDescripcionProducto(text(f.txtDescripcion));
        mp.setNombreCategoria(text(f.comboCategoria));

        return mp;
    }

    @Override
    public void clearCamposAgregarP(I_AgregarProducto f) {
        setContent("N° Producto: " + siguienteNumeroProducto(), f.lblNumero);
        clear(f.txtIDBusqueda);
        clear(f.txtNombre);
        clear(f.txtPrecio);
        clear(f.txtStock);
        clear(f.txtDescripcion);
        clear(f.comboCategoria, false);
    }

    // --------- CONSULTAR PRODUCTO ---------
    @Override
    public void clearCamposConsultarP(I_ConsultarProducto f) {
        clear(f.txtNombre);
        clear(f.txtPrecio);
        clear(f.txtStock);
        clear(f.txtDescripcion);
        clear(f.txtCategoria);
        clear(f.txtEstado);
    }

    @Override
    public void asignarCamposAFormConsultarP(I_ConsultarProducto f, MProducto mp) {
        setContent(mp.getNombreProducto(), f.txtNombre);
        setContent(mp.getPrecioProducto(), f.txtPrecio);
        setContent(mp.getStockProducto(), f.txtStock);
        setContent(mp.getDescripcionProducto(), f.txtDescripcion);
        setContent(mp.getNombreCategoria(), f.txtCategoria);
        setContent(textTipoEstadoProducto(mp.getEstadoProducto()), f.txtEstado);

    }

    // --------- ELIMINAR PRODUCTO ---------
    @Override
    public void asignarCamposAFormEliminarP(I_EliminarProducto f, MProducto mp) {
        setContent(mp.getNombreProducto(), f.txtNombre);
        setContent(mp.getPrecioProducto(), f.txtPrecio);
        setContent(mp.getStockProducto(), f.txtStock);
        setContent(mp.getDescripcionProducto(), f.txtDescripcion);
        setContent(ccat.consultar(mp.getIdCategoria()).getNombreCategoria(), f.txtCategoria);
        setContent(textTipoEstadoProducto(mp.getEstadoProducto()), f.txtEstado);
    }

    @Override
    public void clearCamposEliminarP(I_EliminarProducto f) {
        clear(f.txtID);
        clear(f.txtNombre);
        clear(f.txtPrecio);
        clear(f.txtStock);
        clear(f.txtDescripcion);
        clear(f.txtCategoria);
        clear(f.txtEstado);
    }

    // --------- MODIFICAR PRODUCTO ---------
    @Override
    public void asignarCamposAFormModificarP(I_ModificarProducto f, MProducto mp) {
        setContent(mp.getNombreProducto(), f.txtNombre);
        setContent(mp.getPrecioProducto(), f.txtPrecio);
        setContent(mp.getStockProducto(), f.txtStock);
        setContent(mp.getDescripcionProducto(), f.txtDescripcion);
        setContent(ccat.consultar(mp.getIdCategoria()).getNombreCategoria(), f.comboCategoria);
        setContent(mp.getEstadoProducto(), f.comboEstado);
    }

    @Override
    public MProducto asignarCamposAObjetoModificarP(I_ModificarProducto f) {
        MProducto mp = new MProducto();
        mp.setIdProducto(numberEntero(f.txtID));
        mp.setNombreProducto(text(f.txtNombre));
        mp.setPrecioProducto(numberReal(f.txtPrecio));
        mp.setStockProducto(numberEntero(f.txtStock));
        mp.setDescripcionProducto(text(f.txtDescripcion));
        mp.setNombreCategoria(text(f.comboCategoria));
        mp.setEstadoProducto(indexCombo(f.comboEstado));

        return mp;
    }

    @Override
    public void habilitarControlesModificarP(I_ModificarProducto f) {
        enableControl(f.txtID);
        enableControl(f.txtNombre);
        enableControl(f.txtPrecio);
        enableControl(f.txtStock);
        enableControl(f.txtDescripcion);
        enableControl(f.comboCategoria, true);
        enableControl(f.comboEstado, false);
        enableControl(f.btnBuscar);
        enableControl(f.btnModificar);
    }

    @Override
    public void deshabilitarControlesModificarP(I_ModificarProducto f) {
        disableControl(f.txtID);
        disableControl(f.txtNombre);
        disableControl(f.txtPrecio);
        disableControl(f.txtStock);
        disableControl(f.txtDescripcion);
        disableControl(f.comboCategoria);
        disableControl(f.comboEstado);
        disableControl(f.btnBuscar);
        disableControl(f.btnModificar);
    }

    @Override
    public void clearCamposModificarP(I_ModificarProducto f) {
        clear(f.txtID);
        clear(f.txtNombre);
        clear(f.txtPrecio);
        clear(f.txtStock);
        clear(f.txtDescripcion);
        clear(f.comboCategoria, true);
        clear(f.comboEstado, false);
    }

    // --------- LISTAR PRODUCTO ---------
    @Override
    public void asignarCamposAObjetoListarP(DefaultTableModel modelo) {

        for (MProducto mp : listar()) {
            modelo.addRow(Row_DatosProducto_Completo(mp));
        }
    }

}
