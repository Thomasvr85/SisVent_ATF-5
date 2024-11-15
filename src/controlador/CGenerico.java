/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
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
public class CGenerico implements IGenerico {

    // ......................................
    // ................. AREA : ENABLE CONTROL .................
    // ......................................
    @Override
    public void enableControl(JTextField txt) {
        try {
            txt.setEnabled(true);
        } catch (Exception ex) {
        }
        try {
            txt.setEditable(true);
        } catch (Exception ex) {
        }
        try {
            txt.setBackground(new Color(255, 255, 255));
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JComboBox combo, boolean editable) {
        try {
            combo.setEnabled(true);
        } catch (Exception ex) {
        }
        try {
            combo.setEditable(editable);
        } catch (Exception ex) {
        }
        try {
            combo.setBackground(new Color(255, 255, 255));
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JButton btn) {
        try {
            btn.setEnabled(true);
        } catch (Exception ex) {
        }
        try {
            btn.setBackground(new Color(255, 255, 255));
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JPanel panel) {
        try {
            panel.setEnabled(true);
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JTable table) {
        try {
            table.setEnabled(true);
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JCheckBox chx) {
        try {
            chx.setEnabled(true);
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JRadioButton rb) {
        try {
            rb.setEnabled(true);
        } catch (Exception ex) {
        }
    }

    @Override
    public void enableControl(JSpinner spinner) {
        try {
            spinner.setEnabled(true);
        } catch (Exception ex) {
        }
    }

    // ......................................
    // ................. AREA : EDITABLE CONTROL .................
    // ......................................
    @Override
    public void editableControl(JTextField txt, boolean editable) {
        try {
            txt.setEditable(editable);
        } catch (Exception ex) {

        }
    }

    @Override
    public void editableControl(JComboBox combo, boolean editable) {
        try {
            combo.setEditable(editable);
        } catch (Exception ex) {

        }
    }

    // ......................................
    // ................. AREA : DISABLE CONTROL .................
    // ......................................
    @Override
    public void disableControl(JTextField txt) {
        try {
            txt.setEnabled(false);
        } catch (Exception ex) {
        }
        try {
            txt.setEditable(false);
        } catch (Exception ex) {
        }
        try {
            txt.setBackground(new Color(0xD3D3D3));
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JComboBox combo) {
        try {
            combo.setEnabled(false);
        } catch (Exception ex) {
        }
        try {
            combo.setBackground(new Color(0xD3D3D3));
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JButton btn) {
        try {
            btn.setEnabled(false);
        } catch (Exception ex) {
        }
        try {
            btn.setBackground(new Color(0xD3D3D3));
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JPanel panel) {
        try {
            panel.setEnabled(false);
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JTable table) {
        try {
            table.setEnabled(false);
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JCheckBox chx) {
        try {
            chx.setEnabled(false);
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JRadioButton rb) {
        try {
            rb.setEnabled(false);
        } catch (Exception ex) {
        }
    }

    @Override
    public void disableControl(JSpinner spinner) {
        try {
            spinner.setEnabled(false);
        } catch (Exception ex) {
        }
    }

    // ......................................
    // ................. AREA : CLEAR .................
    // ......................................
    @Override
    public void clear(JTextField txt) {
        try {
            txt.setText("");
        } catch (Exception ex) {
        }
    }

    @Override
    public void clear(JLabel lbl) {
        try {
            lbl.setText("");
        } catch (Exception ex) {
        }
    }

    @Override
    public void clear(JSpinner spinner) {
        try {
            spinner.setValue(0);
        } catch (Exception ex) {

        }
    }

    @Override
    public void clear(JComboBox combo, boolean elminarItems) {
        if (elminarItems) {
            try {
                combo.removeAllItems();
            } catch (Exception ex) {
            }
        }
        noSelectItem(combo);
    }

    @Override
    public void clear(DefaultTableModel modeloTabla) {
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
    }

    // ......................................
    // ................. AREA : CLEAR ITEMS .................
    // ......................................
    @Override
    public void clearItems(JComboBox combo) {
        try {
            combo.removeAllItems();
        } catch (Exception ex) {
        }
    }

    @Override
    public void clearItems(JTable table) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();

        while (modelo.getRowCount() > 0) {
            try {
                modelo.removeRow(0);
            } catch (Exception ex) {
            }
        }
    }

    // ......................................
    // ................. AREA : NO SELECTED ITEM .................
    // ......................................
    @Override
    public void noSelectItem(JComboBox combo) {
        try {
            combo.setSelectedIndex(-1);
        } catch (Exception ex) {
        }
    }

    // ......................................
    // ................. AREA : SET CONTENT .................
    // ......................................
    @Override
    public void setContent(String content, JCheckBox chx) {
        try {
            chx.setText(content);
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(String content, JButton btn) {
        try {
            btn.setText(content);
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(String content, JTextField txt) {
        try {
            txt.setText(content);
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(int content, JTextField txt) {
        try {
            txt.setText(String.valueOf(content));
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(double content, JTextField txt) {
        try {
            txt.setText(String.valueOf(content));
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(String content, JLabel lbl) {
        try {
            lbl.setText(content);
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(int content, JLabel lbl) {
        try {
            lbl.setText(String.valueOf(content));
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(int index, JComboBox combo) {
        try {
            combo.setSelectedIndex(index);
        } catch (Exception ex) {
        }
    }

    @Override
    public void setContent(String content, JComboBox combo) {
        try {
            combo.setSelectedItem(content);
        } catch (Exception ex) {
        }
    }

    // ......................................
    // ................. AREA : TEXT TIPO ESTADO .................
    // ......................................
    @Override
    public String textTipoEstadoProducto(int estado) {
        return estado == 0 ? "Inactivo" : "Activo";
    }

    // ......................................
    // ................. AREA : TEXT .................
    // ......................................
    @Override
    public String text(JTextField txt) {
        return txt.getText() != null ? txt.getText() : "";
    }

    @Override
    public String text(JComboBox combo) {
        return combo.getSelectedItem() != null ? combo.getSelectedItem().toString() : "";
    }

    // ......................................
    // ................. AREA : NUMBER ENTERO .................
    // ......................................
    @Override
    public int numberEntero(JTextField txt) {

        return txt.getText().isBlank() ? -1 : Integer.parseInt(txt.getText());
    }

    // ......................................
    // ................. AREA : NUMBER REAL .................
    // ......................................
    @Override
    public double numberReal(JTextField txt) {
        return txt.getText().isBlank() ? -1 : Double.parseDouble(txt.getText());
    }

    // ......................................
    // ................. AREA : INDEX COMBO .................
    // ......................................
    @Override
    public int indexCombo(JComboBox combo) {
        return combo != null ? combo.getSelectedIndex() : -100;
    }

    // ......................................
    // ................. AREA : SET ESTABLISH .................
    // ......................................
    @Override
    public void setEstablish(boolean establish, JCheckBox chx) {
        try {
            chx.setSelected(establish);
        } catch (Exception ex) {
        }
    }
    
    @Override
    public void setEstablish(boolean establish, JRadioButton rb){
        try {
            rb.setSelected(establish);
        } catch (Exception ex) {
        }
    }

    // ......................................
    // ................. AREA : FOCUS .................
    // ......................................
    @Override
    public void focus(JTextField txt) {
        txt.requestFocus();
    }

    @Override
    public void focus(JComboBox combo) {
        combo.requestFocus();
    }

    @Override
    public void focus(JCheckBox chx) {
        chx.requestFocus();
    }

    @Override
    public void focus(JButton btn) {
        btn.requestFocus();
    }

    // ................. AREA : IS EMPTY .................
    @Override
    public boolean isEmpty(JTextField txt) {
        return txt.getText().isBlank();
    }

}
