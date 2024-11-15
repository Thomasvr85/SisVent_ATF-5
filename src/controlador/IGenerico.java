/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.MProducto;

/**
 *
 * @author HACK
 */
public interface IGenerico {

    //Generico
    // ----------- Controles ------------
    // ................. AREA : ENABLE CONTROL .................
    void enableControl(JTextField txt);

    void enableControl(JComboBox combo, boolean editable);

    void enableControl(JButton btn);

    void enableControl(JPanel panel);

    void enableControl(JTable table);

    void enableControl(JCheckBox chx);

    void enableControl(JRadioButton rb);

    void enableControl(JSpinner spinner);

    // ................. AREA : EDITABLE CONTROL .................
    void editableControl(JTextField txt, boolean editable);

    void editableControl(JComboBox combo, boolean editable);

    // ................. AREA : DISABLE CONTROL .................
    void disableControl(JTextField txt);

    void disableControl(JComboBox combo);

    void disableControl(JButton btn);

    void disableControl(JPanel panel);

    void disableControl(JTable table);

    void disableControl(JCheckBox chx);

    void disableControl(JRadioButton rb);

    void disableControl(JSpinner spinner);

    // ................. AREA : CLEAR .................
    void clear(JTextField txt);

    void clear(JLabel lbl);

    void clear(JComboBox combo, boolean elminarItems);

    void clear(JSpinner spinner);

    void clearItems(JComboBox combo);

    void clearItems(JTable table);

    void clear(DefaultTableModel modeloTabla);

    // ................. AREA : NO SELECTED ITEM .................
    void noSelectItem(JComboBox combo);

    // ................. AREA : SET CONTENT .................
    void setContent(String content, JCheckBox chx);

    void setContent(String content, JButton btn);

    void setContent(String content, JTextField txt);

    void setContent(int content, JTextField txt);

    void setContent(double content, JTextField txt);

    void setContent(String content, JLabel lbl);

    void setContent(int content, JLabel lbl);

    void setContent(int content, JComboBox combo);

    void setContent(String content, JComboBox combo);

// ................. AREA : TEXT TIPO ESTADO .................
    String textTipoEstadoProducto(int estado);

    // ................. AREA : TEXT .................
    String text(JTextField txt);

    String text(JComboBox combo);

    // ................. AREA : NUMBER ENTERO .................
    int numberEntero(JTextField txt);

    // ................. AREA : NUMBER REAL .................
    public double numberReal(JTextField txt);

    // ................. AREA : INDEX COMBO .................
    int indexCombo(JComboBox combo);

    // ................. AREA : SET ESTABLISH .................
    void setEstablish(boolean establish, JCheckBox chx);
    
    void setEstablish(boolean establish, JRadioButton chx);

    // ................. AREA : FOCUS .................
    void focus(JTextField txt);

    void focus(JComboBox combo);

    void focus(JCheckBox chx);

    void focus(JButton btn);

    // ................. AREA : IS EMPTY .................
    boolean isEmpty(JTextField txt);

}
