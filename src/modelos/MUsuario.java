/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.JPasswordField;

/**
 *
 * @author HACK
 */
public class MUsuario extends M_AccionesModelos{
    private int idUsuario;
    private String usuario;
    private String pwd;
    private int idTipoUsuario;
    private int estado;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int tipoUsuario) {
        this.idTipoUsuario = tipoUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public boolean validarContrasena(JPasswordField pwd){
        return String.valueOf(pwd).equals(this.pwd);
    }

    @Override
    public String toString() {
        return "MUsuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", pwd=" + pwd + ", idTipoUsuario=" + idTipoUsuario + ", estado=" + estado + '}';
    }
    
    
}
