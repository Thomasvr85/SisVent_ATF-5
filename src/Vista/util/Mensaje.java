/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.util;

import javax.swing.JOptionPane;

/**
 *
 * @author HACK
 */
public class Mensaje {
    public static void ERROR(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, "ERROR: " + titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void INFORMACION(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, "INFORMACION: " + titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void ADVERTENCIA(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, "ADVERTENCIA: " + titulo, JOptionPane.WARNING_MESSAGE);
    }
    public static void PREGUNTA(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, "PREGUNTA: " + titulo, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static int CONFIRMACION(String mensaje, String titulo){
        return JOptionPane.showConfirmDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
    // ----- sin titulo
    
    public static void ERROR(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "ERROR" , JOptionPane.ERROR_MESSAGE);
    }
    
    public static void INFORMACION(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void ADVERTENCIA(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
    }
    public static void PREGUNTA(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "PREGUNTA", JOptionPane.QUESTION_MESSAGE);
    }
    
    public static int CONFIRMACION(String mensaje){
        return JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
}
