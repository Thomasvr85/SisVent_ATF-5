/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Venta.CRUD;

import Vista.util.Interaccion;
import controlador.Producto.CProducto;
import controlador.Producto.IListarP;
import controlador.VariablesEstaticas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import modelos.MDetalleVenta;
import modelos.MProducto;
import java.util.stream.Stream;

/**
 *
 * @author HACK
 */
public class I_EncontrarProducto extends javax.swing.JFrame {

    //Modelos
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(0, 0, 0, 0);

    List<MProducto> lstProductosEncontrados = new ArrayList<>();
    Map<Integer, Boolean> mapProdsEnCarro = new HashMap<>();//idProducto, incluido

    private MProducto m_p = null;
    private MDetalleVenta m_dv = new MDetalleVenta();
    private CProducto c_p = new CProducto();

    // ---------------------------------
    private void llenarTabla(List<MProducto> _productosEncontrados) {
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Stock");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Categoría");

        tablaProductos.setModel(modeloTabla);

        for (MProducto _mp : _productosEncontrados) {
            modeloTabla.addRow(c_p.Row_DatosProducto_DatosEsenciales(_mp));
        }

        spinnerCantidad.setModel(modeloSpinner);
    }

    private void deshabilitarControlesDelInicio() {
        c_p.disableControl(spinnerCantidad);
        c_p.disableControl(btnAgregarProducto);
    }

    private void habilitarControlesDelInicio() {
        c_p.enableControl(spinnerCantidad);
        c_p.enableControl(btnAgregarProducto);
    }

    private void reasignarModeloSpinner(MProducto m_p) {
        modeloSpinner = new SpinnerNumberModel(1, 1, m_p.getStockProducto(), 1);//value(1), min(1), max, increment(1)
        spinnerCantidad.setModel(modeloSpinner);
    }

    private void identificarProductosEnCarro(List<MProducto> _productosEncontrados) {
        int idProd;
        boolean enCarro;
        for (MProducto _productosEncontrado : _productosEncontrados) {
            idProd = _productosEncontrado.getIdProducto();
            enCarro = VariablesEstaticas.lstProductosEnCarro_Venta.stream().filter(p -> p.getIdProducto() == _productosEncontrado.getIdProducto()).findFirst().isPresent();
            mapProdsEnCarro.put(idProd, enCarro);
        }
    }

    private List<MProducto> reacondicionarStock(List<MProducto> _productosEncontrados) {
        List<MProducto> productosEncontrados = _productosEncontrados;

        for (int i = 0; i < productosEncontrados.size(); i++) {
            if (mapProdsEnCarro.get(productosEncontrados.get(i).getIdProducto())) {//true -> Si esta en proceso de venta (carrito)
                int index_ProdEnCarro = VariablesEstaticas.lstProductosEnCarro_Venta.stream().map(MProducto::getIdProducto).collect(Collectors.toList()).indexOf(productosEncontrados.get(i).getIdProducto());
                int stock_restante = VariablesEstaticas.lstProductosEnCarro_Venta.get(index_ProdEnCarro).getStockProducto();
                productosEncontrados.get(i).setStockProducto(stock_restante);
            }
        }

        return productosEncontrados;
    }

    private void __init__(List<MProducto> _productosEncontrados) {
        Interaccion.centrarForm(this);
        deshabilitarControlesDelInicio();
        identificarProductosEnCarro(_productosEncontrados);
        lstProductosEncontrados = reacondicionarStock(_productosEncontrados);//ProductosEncontrados adecuado para la venta actual
        llenarTabla(lstProductosEncontrados);
    }

    private void salir() {
        VariablesEstaticas.TERMINAR = true;
        this.dispose();
    }

    /**
     * Creates new form EncontrarProducto
     */
    public I_EncontrarProducto() {
        initComponents();
        Interaccion.centrarForm(this);
    }

    public I_EncontrarProducto(List<MProducto> productos) {
        initComponents();
        __init__(productos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.setEnabled(false);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad del producto: ");

        spinnerCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerCantidadStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        //nuevo stock restante
        m_p.setStockProducto(m_p.getStockProducto() - m_dv.getCantidadProducto());
        //revisar calculo de nuevo stock------
        if (mapProdsEnCarro.get(m_p.getIdProducto())) {
            //index del producto de la lista de variables estaticas
            int index = VariablesEstaticas.lstProductosEnCarro_Venta.stream().map(MProducto::getIdProducto).collect(Collectors.toList()).indexOf(m_p.getIdProducto());

            //actualizando stock
            VariablesEstaticas.lstProductosEnCarro_Venta.get(index).setStockProducto(m_p.getStockProducto());

            
            MDetalleVenta temp_m_dv = VariablesEstaticas.lstDetallesEnCarro_Venta.get(index);
            //Actualizando la cantidad
            VariablesEstaticas.lstDetallesEnCarro_Venta.get(index).setCantidadProducto(temp_m_dv.getCantidadProducto() + m_dv.getCantidadProducto());
            System.out.println("1) " + VariablesEstaticas.lstDetallesEnCarro_Venta.get(index));
            //Actualizando el subtotal
            VariablesEstaticas.lstDetallesEnCarro_Venta.get(index).setSubTotal(temp_m_dv.getSubTotal() + m_dv.getSubTotal());
            System.out.println("2) " + VariablesEstaticas.lstDetallesEnCarro_Venta.get(index));
            //insertando datos de detalle venta
        } else {
            VariablesEstaticas.lstProductosEnCarro_Venta.add(m_p);
            VariablesEstaticas.lstDetallesEnCarro_Venta.add(m_dv);
        }
        System.out.println("3) " + m_dv);
        salir();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void spinnerCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerCantidadStateChanged
        m_dv.setCantidadProducto((int) spinnerCantidad.getValue());
        m_dv.setSubTotal(m_dv.getCantidadProducto() * m_p.getPrecioProducto());

        System.out.println(m_dv);
    }//GEN-LAST:event_spinnerCantidadStateChanged

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        int idProductoSeleccionado = Integer.parseInt(modeloTabla.getValueAt(tablaProductos.getSelectedRow(), 0).toString());

        m_p = lstProductosEncontrados.stream().filter(p -> p.getIdProducto() == idProductoSeleccionado).findFirst().get();
        m_dv = new MDetalleVenta(m_p.getIdProducto(), 1, m_p.getPrecioProducto());

        reasignarModeloSpinner(m_p);
        habilitarControlesDelInicio();
    }//GEN-LAST:event_tablaProductosMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(I_EncontrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(I_EncontrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(I_EncontrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(I_EncontrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //SwingUtilities.invokeLater(() -> new I_EncontrarProducto());
                new I_EncontrarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables

}
