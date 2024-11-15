/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.util;

import Basico.VarConf;
import Vista.InterfazPrincipal.E_Acceso;
import Vista.InterfazPrincipal.I_Principal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author HACK
 */
public class Interaccion {

    private static Dimension Login_TamanioVentana = new Dimension(644, 292);//[607, 256] - [644, 292]
    private static Dimension Principal_TamanioVentana = new Dimension(950, 700);
    private static Dimension Gestion_TamanioVentana = new Dimension(684, 600);
    private static Dimension CRUD_TamanioVentana = new Dimension(672, 515);

    private static Dimension btn_CerrarSesion = new Dimension(200, 30);

    //private static Point Login_Origen = new Point(128, 105);
    private static Point Origen_Coordenadas = new Point(0, 0);

    static int posBtnCS = 3;
    private static Point Btn_CerrarSesion_Coordenadas = new Point(posBtnCS, posBtnCS);

    public static void Login_ShowJPanel(JPanel ventana_objeto, JPanel panel_contenedor, I_Principal Form_principal) {
        panel_contenedor.removeAll();

        Form_principal.setSize(Login_TamanioVentana);
        panel_contenedor.setSize(Login_TamanioVentana);

        ventana_objeto.setSize(Login_TamanioVentana);
        ventana_objeto.setLocation(Origen_Coordenadas);

        panel_contenedor.add(ventana_objeto, BorderLayout.CENTER);
        panel_contenedor.revalidate();
        panel_contenedor.repaint();
    }

    public static void Principal_ShowJPanel(JPanel ventana_objeto, JPanel panel_contenedor, I_Principal Form_principal, JButton btn) {
        panel_contenedor.removeAll();

        agregar_CerrarSesion_ShowJPanel(btn, panel_contenedor, Form_principal, Basico.VarConf.SOURCE_IMAGEN_CERRAR_SESION);
        Form_principal.setPreferredSize(Principal_TamanioVentana);
        Form_principal.setSize(Principal_TamanioVentana);
        Form_principal.setLocationRelativeTo(null);

        panel_contenedor.setSize(Principal_TamanioVentana);
        panel_contenedor.setPreferredSize(Principal_TamanioVentana);

        ventana_objeto.setSize(Principal_TamanioVentana);
        ventana_objeto.setLocation(Origen_Coordenadas);

        panel_contenedor.add(ventana_objeto, BorderLayout.CENTER);
        panel_contenedor.revalidate();
        panel_contenedor.repaint();
    }

    public static void Gestion_ShowJPanel(JPanel ventana_objeto, JPanel panel_contenedor) {
        panel_contenedor.removeAll();

        panel_contenedor.setSize(Gestion_TamanioVentana);

        ventana_objeto.setSize(Gestion_TamanioVentana);
        ventana_objeto.setLocation(Origen_Coordenadas);

        panel_contenedor.add(ventana_objeto, BorderLayout.CENTER);
        panel_contenedor.revalidate();
        panel_contenedor.repaint();
    }

    public static void CRUD_ShowJPanel(JPanel ventana_objeto, JPanel panel_contenedor) {
        panel_contenedor.removeAll();

        panel_contenedor.setSize(CRUD_TamanioVentana);

        ventana_objeto.setSize(CRUD_TamanioVentana);
        ventana_objeto.setLocation(Origen_Coordenadas);

        panel_contenedor.add(ventana_objeto, BorderLayout.CENTER);
        panel_contenedor.revalidate();
        panel_contenedor.repaint();
    }

    public static void agregar_CerrarSesion_ShowJPanel(JButton btn, JPanel panel_contenedor, I_Principal Form_principal, String sourceImage) {
        int dim = 20;
        Dimension dimensionImagen = new Dimension(dim, dim);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Form_principal.setAcceso(E_Acceso.LOGIN);
                Form_principal.Agregar_I_Principal();
            }
        });

        JLabel lblImagen = new JLabel(new ImageIcon(new ImageIcon(VarConf.URL_Imagen_CerrarSesion).getImage().getScaledInstance(dim, dim, Image.SCALE_DEFAULT)), SwingConstants.RIGHT);
        lblImagen.setSize(dimensionImagen);
        lblImagen.setPreferredSize(dimensionImagen);
        lblImagen.setLocation(173, 0);
        btn.add(lblImagen);

        btn.setLocation(Btn_CerrarSesion_Coordenadas);
        btn.setSize(btn_CerrarSesion);
        panel_contenedor.add(btn);

        panel_contenedor.revalidate();
        panel_contenedor.repaint();
    }
    
    public static void centrarForm(JFrame f){
        f.setLocationRelativeTo(null);
    }
}
