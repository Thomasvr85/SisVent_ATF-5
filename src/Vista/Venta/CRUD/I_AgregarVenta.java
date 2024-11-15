/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Venta.CRUD;

import controlador.Cliente.CCliente;
import controlador.Cliente.IConsultarCliente;
import controlador.DetalleVenta.CDetalleVenta;
import controlador.DetalleVenta.IAgregarDetalleVenta;
import controlador.DetalleVenta.IListarDetalleVenta;
import controlador.Producto.CProducto;
import controlador.Producto.IConsultarP;
import controlador.Producto.IGenericoP;
import controlador.Producto.IModificarP;
import controlador.VariablesEstaticas;
import controlador.Venta.CVenta;
import controlador.Venta.IAgregarVenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import modelos.MCliente;
import modelos.MDetalleVenta;
import modelos.MProducto;
import modelos.MVenta;

/**
 *
 * @author HACK
 */
public class I_AgregarVenta extends javax.swing.JPanel {

    //IListarP cp = new CProducto();
    //---------- Controladores ---------- 
    IListarDetalleVenta c_l_dv = new CDetalleVenta();
    IGenericoP c_Gen_Prod = new CProducto();
    IAgregarDetalleVenta c_a_dv = new CDetalleVenta();
    IConsultarP c_c_p = new CProducto();
    IConsultarCliente c_c_c = new CCliente();
    IAgregarVenta c_a_v = new CVenta();
    IModificarP c_m_p = new CProducto();

    //List<MDetalleVenta> ms_dv = new ArrayList<>();
    MCliente m_c = new MCliente();
    MProducto m_p = new MProducto();
    //MDetalleVenta m_dv = new MDetalleVenta();

    private SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(0, 0, 0, 0);
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    private void iniciarTimer() {
        Timer timer = new Timer();
        //TIMER
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer activo.");
                if (VariablesEstaticas.TERMINAR) {

                    esperar100mili();

                    llenarTabla();
                    actualizarPagoFinal();
                    establecerMargenesSpinner();
                    actualizarVuelto();

                    VariablesEstaticas.TERMINAR = false;
                    System.out.println("Fin Timer");
                    timer.cancel();
                }
            }
        };

        //Iniciar timer
        timer.scheduleAtFixedRate(tarea, 0, 500);
    }

    private void esperar100mili() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(I_AgregarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarVuelto() {
        actualizarVuelto(Double.parseDouble(lblTotal.getText()));
    }

    private void actualizarVuelto(double total) {
        lblVuelto.setText(String.valueOf(Double.parseDouble(String.valueOf(spinnerMontoDado.getValue())) - total));
    }

    private void actualizarPagoFinal() {
        double total = 0;
        for (MDetalleVenta mDetalleVenta : VariablesEstaticas.lstDetallesEnCarro_Venta) {
            total += mDetalleVenta.getSubTotal();
        }

        lblTotal.setText(String.valueOf(total));

        esperar100mili();

    }

    private void establecerMargenesSpinner() {
        int total = (int) (Double.parseDouble(lblTotal.getText()) + 1);
        System.out.println("total = " + total);
        modeloSpinner = new SpinnerNumberModel(total, total, Long.MAX_VALUE, 1);
        spinnerMontoDado.setModel(modeloSpinner);
    }

    private void llenarTabla() {
        modeloTabla = new DefaultTableModel();
        //limpiar tabla
        c_a_dv.clear(modeloTabla);
        //Columnas table
        modeloTabla.addColumn("Nro");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Precio U");
        modeloTabla.addColumn("SubTotal");
        //vinculacion de table con modelotable
        tablaProductosVenta.setModel(modeloTabla);

        int c = 1;
        for (MDetalleVenta mDetalleVenta : VariablesEstaticas.lstDetallesEnCarro_Venta) {
            modeloTabla.addRow(c_a_dv.Row_DatosProducto_Boleta(mDetalleVenta, c++));
        }
    }

    private void Inicio() {
        //Desabilitar conroles panel contenido productos
        c_a_v.disableControls(this);

        c_a_v.enableControl(txtDniCliente);
        c_a_v.enableControl(btnBuscarDni);
    }

    private void clearAll() {
        c_a_dv.clear(lblDatosCliente);
        c_a_dv.clear(txtDniCliente);
        c_a_dv.clear(txtProductoAgregar);
        c_a_dv.clear(modeloTabla);
        c_a_dv.clear(spinnerMontoDado);
        c_a_dv.setEstablish(false, rbEfectivo);
        c_a_dv.setEstablish(false, rbYape_Plin);
        c_a_dv.setEstablish(false, rbTarjeta);
        lblTotal.setText("00");
        lblVuelto.setText("00");

    }

    private void inhabilitarEdicionTabla() {
        tablaProductosVenta.setDefaultEditor(Object.class, null);
    }

    //INICIAL
    private void __init__() {
        llenarTabla();

        Inicio();

        inhabilitarEdicionTabla();

    }

    public I_AgregarVenta() {
        initComponents();

        __init__();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelContenido = new javax.swing.JPanel();
        txtProductoAgregar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductosVenta = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnRealizarCompra = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblSimboloMoneda = new javax.swing.JLabel();
        rbEfectivo = new javax.swing.JRadioButton();
        rbYape_Plin = new javax.swing.JRadioButton();
        rbTarjeta = new javax.swing.JRadioButton();
        spinnerMontoDado = new javax.swing.JSpinner();
        btnActualizarTabla = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblVuelto = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblDatosCliente = new javax.swing.JLabel();
        btnBuscarDni = new javax.swing.JButton();

        txtProductoAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoAgregarKeyTyped(evt);
            }
        });

        tablaProductosVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProductosVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaProductosVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaProductosVenta);

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnRealizarCompra.setText("REALIZAR COMPRA");
        btnRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCompraActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Monto:");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("TOTAL: ");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("00");

        lblSimboloMoneda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSimboloMoneda.setText("S/.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(lblSimboloMoneda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTotal)
                    .addComponent(lblSimboloMoneda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(rbEfectivo);
        rbEfectivo.setText("Efectivo");
        rbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEfectivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbYape_Plin);
        rbYape_Plin.setText("Yape / Plin");
        rbYape_Plin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbYape_PlinActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTarjeta);
        rbTarjeta.setText("Tarjeta");
        rbTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTarjetaActionPerformed(evt);
            }
        });

        spinnerMontoDado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerMontoDadoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbYape_Plin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerMontoDado, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(rbEfectivo)
                        .addComponent(rbYape_Plin)
                        .addComponent(rbTarjeta)
                        .addComponent(spinnerMontoDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnActualizarTabla.setText("Actualizar");
        btnActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaActionPerformed(evt);
            }
        });

        jLabel4.setText("Vuelto:");

        jLabel5.setText("S/.");

        lblVuelto.setText("00");

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addComponent(txtProductoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizarTabla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRealizarCompra)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVuelto))))
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(txtProductoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoLayout.createSequentialGroup()
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lblVuelto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRealizarCompra))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });

        jLabel1.setText("DNI Cliente:");

        lblDatosCliente.setText(".");

        btnBuscarDni.setText("Buscar cliente");
        btnBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarDni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatosCliente)
                    .addComponent(btnBuscarDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarProducto() {
        //Inicia el timer
        iniciarTimer();
        //Mostrar producto en base al producto escrito
        c_Gen_Prod.encontrarProducto_Por_NombreOCategoria(txtProductoAgregar);
    }

    private void txtProductoAgregarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoAgregarKeyTyped
        m_p.bloquearCaracterEspecial_NoNumero_NoCaracter(evt);

        if (m_p.caracterEnter((int) evt.getKeyChar())) {
            buscarProducto();
        }
    }//GEN-LAST:event_txtProductoAgregarKeyTyped

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        buscarProducto();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void buscarCliente() {
        m_c = c_c_c.consultar(txtDniCliente, true);
        if (m_c != null) {
            lblDatosCliente.setText(c_c_c.DatosDelCliente_Esencial(m_c));
            c_a_v.clear(txtDniCliente);
            c_a_v.enableControls(this);

            c_a_v.disableControl(btnBuscarDni);
            c_a_v.disableControl(txtDniCliente);
            c_a_v.disableControl(spinnerMontoDado);
            c_a_dv.disableControl(btnRealizarCompra);

            recalculoAutomatico();
        }
    }

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        if (!m_p.bloquearNoNumeroEntero(evt)) {
            m_p.setNumeroActual_Entero(txtDniCliente.getText());
            m_p.bloquearCaracteresExcesivosDe(evt, m_p.getNumeroActual_Entero(), 8);
        }

        if (m_p.caracterEnter(evt)) {
            buscarCliente();
        }
    }//GEN-LAST:event_txtDniClienteKeyTyped

    private void btnBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDniActionPerformed
        buscarCliente();

    }//GEN-LAST:event_btnBuscarDniActionPerformed

    private void btnActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTablaActionPerformed
        llenarTabla();
        actualizarVuelto();
    }//GEN-LAST:event_btnActualizarTablaActionPerformed

    private void recalculoAutomatico() {
        c_a_dv.enableControl(btnRealizarCompra);

        establecerMargenesSpinner();

        if (rbEfectivo.isSelected()) {
            c_a_dv.enableControl(spinnerMontoDado);
        } else {
            c_a_dv.disableControl(spinnerMontoDado);
        }

        actualizarVuelto();
    }

    private void rbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfectivoActionPerformed
        recalculoAutomatico();
    }//GEN-LAST:event_rbEfectivoActionPerformed

    private void rbYape_PlinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbYape_PlinActionPerformed
        recalculoAutomatico();
    }//GEN-LAST:event_rbYape_PlinActionPerformed

    private void rbTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTarjetaActionPerformed
        recalculoAutomatico();
    }//GEN-LAST:event_rbTarjetaActionPerformed

    private String metodoDePago() {
        if (rbEfectivo.isSelected()) {
            return "EFECTIVO";
        } else if (rbTarjeta.isSelected()) {
            return "TARJETA";
        } else if (rbYape_Plin.isSelected()) {
            return "YAPE_PLIN";
        } else {
            return "NO_SELECTED";
        }
    }

    private void btnRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCompraActionPerformed
        //Agregando venta
        CVenta c_v = new CVenta();
        MVenta m_v = new MVenta(m_c.getIdCliente(), VariablesEstaticas.trabajadorActual.getIdTrabajador(), Double.parseDouble(lblTotal.getText()), metodoDePago());
        c_v.agregar(m_v, false);

        int idVenta = c_v.ultimoIdVenta();

        CDetalleVenta c_dv = new CDetalleVenta();
        for (MDetalleVenta mDetalleVenta : VariablesEstaticas.lstDetallesEnCarro_Venta) {
            c_dv.agregarDetalleVenta(mDetalleVenta, idVenta, false);
        }
        clearAll();
        Inicio();

        //Acualizar stock productos
        for (MProducto mProducto : VariablesEstaticas.lstProductosEnCarro_Venta) {
            System.out.println("mProducto = " + mProducto);
            c_m_p.modificar(mProducto, false);
        }

        VariablesEstaticas.lstDetallesEnCarro_Venta = new ArrayList<>();
        VariablesEstaticas.lstProductosEnCarro_Venta = new ArrayList<>();
        //Agregando detalle ventas

    }//GEN-LAST:event_btnRealizarCompraActionPerformed

    private void spinnerMontoDadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerMontoDadoStateChanged
        actualizarVuelto();
        System.out.println("Va");
    }//GEN-LAST:event_spinnerMontoDadoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarTabla;
    public javax.swing.JButton btnAgregarProducto;
    public javax.swing.JButton btnBuscarDni;
    public javax.swing.JButton btnRealizarCompra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatosCliente;
    private javax.swing.JLabel lblSimboloMoneda;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVuelto;
    private javax.swing.JPanel panelContenido;
    public javax.swing.JRadioButton rbEfectivo;
    public javax.swing.JRadioButton rbTarjeta;
    public javax.swing.JRadioButton rbYape_Plin;
    public javax.swing.JSpinner spinnerMontoDado;
    public javax.swing.JTable tablaProductosVenta;
    public javax.swing.JTextField txtDniCliente;
    public javax.swing.JTextField txtProductoAgregar;
    // End of variables declaration//GEN-END:variables
}
