/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.JTextField;

/**
 *
 * @author HACK
 */
class M_AccionesModelos {

    private boolean puntoDecimalActivado = false;
    private String numeroActual_Entero = "";
    private String numeroActual_Decimal = "";

    public void setNumeroActual_Entero(String numeroActual_Entero) {
        this.numeroActual_Entero = numeroActual_Entero;
    }

    public String getNumeroActual_Entero() {
        return numeroActual_Entero;
    }

    public void setNumeroActual_Decimal(String numeroActual_Decimal) {
        this.numeroActual_Decimal = numeroActual_Decimal;
    }

    public String getNumeroActual_Decimal() {
        return numeroActual_Decimal;
    }

//Caracter ENTER
    public boolean caracterEnter(java.awt.event.KeyEvent evt) {
        return caracterEnter(evt.getKeyChar());
    }

    public boolean caracterEnter(char c) {
        return caracterEnter((int) c);
    }

    public boolean caracterEnter(int codigoASCII) {
        return (codigoASCII == 10//Enter
                );
    }
//Caracter ALPHA

    public boolean caracterAlpha(java.awt.event.KeyEvent evt) {
        return caracterAlpha(evt.getKeyChar());
    }

    public boolean caracterAlpha(char c) {
        return caracterAlpha((int) c);
    }

    public boolean caracterAlpha(int codigoASCII) {
        return ((codigoASCII >= 65 && 90 >= codigoASCII)//MAYUSCULAS
                || (codigoASCII >= 97 && 122 >= codigoASCII)//minusculas
                || codigoASCII == 193/*Á*/ || codigoASCII == 225/*á*/ || codigoASCII == 196/*Ä*/ || codigoASCII == 228/*ä*/
                || codigoASCII == 201/*É*/ || codigoASCII == 233/*é*/ || codigoASCII == 203/*Ë*/ || codigoASCII == 235/*ë*/
                || codigoASCII == 205/*Í*/ || codigoASCII == 237/*í*/ || codigoASCII == 207/*Ï*/ || codigoASCII == 239/*ï*/
                || codigoASCII == 211/*Ó*/ || codigoASCII == 243/*ó*/ || codigoASCII == 214/*Ö*/ || codigoASCII == 246/*ö*/
                || codigoASCII == 218/*Ú*/ || codigoASCII == 250/*ú*/ || codigoASCII == 220/*Ü*/ || codigoASCII == 252/*ü*/
                || codigoASCII == 241/*Ñ*/ || codigoASCII == 209/*n*/ //
                || codigoASCII == 32//espacio
                );
    }
//Caracter NUMERICO

    public boolean caracterNumerico(java.awt.event.KeyEvent evt) {
        return caracterNumerico(evt.getKeyChar());
    }

    public boolean caracterNumerico(char c) {
        return caracterNumerico((int) c);
    }

    public boolean caracterNumerico(int codigoASCII) {
        return codigoASCII >= 48 && codigoASCII <= 57;
    }
//Caracter SUPRIMIR

    public boolean caracterSuprimir(java.awt.event.KeyEvent evt) {
        return caracterSuprimir(evt.getKeyChar());
    }

    public boolean caracterSuprimir(char c) {
        return caracterSuprimir((int) c);
    }

    public boolean caracterSuprimir(int codigoASCII) {
        return codigoASCII == 127;
    }
//Caracter BACKSPACE

    public boolean caracterBackspace(java.awt.event.KeyEvent evt) {
        return caracterBackspace(evt.getKeyChar());
    }

    public boolean caracterBackspace(char c) {
        return caracterBackspace((int) c);
    }

    public boolean caracterBackspace(int codigoASCII) {
        return codigoASCII == 8;
    }
//Caracter 

    public boolean caracterPuntoDecimal(java.awt.event.KeyEvent evt) {
        return caracterPuntoDecimal(evt.getKeyChar());
    }

    public boolean caracterPuntoDecimal(char c) {
        return caracterPuntoDecimal((int) c);
    }

    public boolean caracterPuntoDecimal(int codigoASCII) {
        return codigoASCII == 46;
    }
//--------- FIN - Caracter ---------

    public boolean bloquearNoCaracteresAlpha(java.awt.event.KeyEvent evt) {
        int codigoASCII = (int) (evt.getKeyChar());
        System.out.println(codigoASCII);
        if (!caracterAlpha(codigoASCII)) {
            evt.consume();
            return true;
        }
        return false;
    }

    public boolean bloquearCaracterEspecial_NoNumero_NoCaracter(java.awt.event.KeyEvent evt) {
        int codigoASCII = (int) evt.getKeyChar();
        if (!(caracterAlpha(codigoASCII) || caracterNumerico(codigoASCII) || caracterPuntoDecimal(codigoASCII))) {
            evt.consume();
            return true;
        }

        return false;
    }

    public void reactivarPuntoDecimal(java.awt.event.KeyEvent evt, JTextField txt) {
        String s = txt.getText();

        if (s.split("\\.").length == 1 && s.length() != 0 && s.charAt(s.length() - 1) != '.') {
            puntoDecimalActivado = false;
        }

        //System.out.println("t: " + s + " - b: " + puntoDecimalActivado + " count: " + s.split("\\.").length);
    }

    public boolean bloquearNoNumeroReal(java.awt.event.KeyEvent evt, JTextField txt) {
        String s = txt.getText();
        char c = evt.getKeyChar();
        int codigoASCII = (int) c;

        if (s.matches("[0-9]{0,}\\.[0-9]{2}")) {
            evt.consume();
        }

        if (caracterPuntoDecimal(codigoASCII) && puntoDecimalActivado) {
            evt.consume();
            return true;
        } else if (caracterPuntoDecimal(codigoASCII)) {
            puntoDecimalActivado = true;
            return false;
        }

        if (!caracterNumerico(codigoASCII) && !caracterPuntoDecimal(codigoASCII) && !caracterBackspace(codigoASCII) && !caracterSuprimir(codigoASCII)) {
            evt.consume();
            return true;
        }

        return false;
    }

    public boolean bloquearNoNumeroEntero(java.awt.event.KeyEvent evt) {
        int codigoASCII = (int) evt.getKeyChar();
        if (!Character.isDigit(evt.getKeyChar()) && codigoASCII != 8 && codigoASCII != 127) {
            evt.consume();
            return true;
        }
        return false;
    }

    public boolean bloquearNumeroMenorACero(java.awt.event.KeyEvent evt, JTextField txt) {
        if (!txt.getText().isEmpty() && Double.parseDouble(txt.getText()) < 0) {
            evt.consume();
            return true;
        }
        return false;
    }

    public boolean bloquearNumero_Entero_No_Entre(java.awt.event.KeyEvent evt, int min, int max) {
        if (!numeroActual_Entero.isEmpty() && Integer.parseInt(numeroActual_Entero) >= min && max <= Integer.parseInt(numeroActual_Entero)) {
            evt.consume();
            return true;
        }
        return false;
    }

    public boolean bloquearNumero_Decimal_No_Entre(java.awt.event.KeyEvent evt, int min, int max) {
        if (!numeroActual_Decimal.isEmpty() && Double.parseDouble(numeroActual_Decimal) >= min && max <= Double.parseDouble(numeroActual_Decimal)) {
            evt.consume();
            return true;
        }
        return false;
    }

    public boolean bloquearCaracteresExcesivosDe(java.awt.event.KeyEvent evt, String text, int maxLength) {
        if (!text.isEmpty() && text.length() > maxLength - 1) {
            evt.consume();
            return true;
        }
        return false;
    }

    public boolean isPuntoDecimalActivado() {
        return puntoDecimalActivado;
    }

}
