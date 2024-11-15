/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HACK
 */
public class MTrabajador {

    private int idTrabajador;
    private String dniTrabajador;
    private String nombreTrabajador;
    private String apellidoPaternoTrabajador;
    private String apellidoMaternoTrabajador;
    private String direccionTrabajador;
    private String telTrabajador;
    private String emailTrabajador;
    private int idCargoTrabajador;
    private int idUsuario;
    private int estado;

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getDniTrabajador() {
        return dniTrabajador;
    }

    public void setDniTrabajador(String dniTrabajador) {
        this.dniTrabajador = dniTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoPaternoTrabajador() {
        return apellidoPaternoTrabajador;
    }

    public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
        this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
    }

    public String getApellidoMaternoTrabajador() {
        return apellidoMaternoTrabajador;
    }

    public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
        this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
    }

    public String getDireccionTrabajador() {
        return direccionTrabajador;
    }

    public void setDireccionTrabajador(String direccionTrabajador) {
        this.direccionTrabajador = direccionTrabajador;
    }

    public String getTelTrabajador() {
        return telTrabajador;
    }

    public void setTelTrabajador(String telTrabajador) {
        this.telTrabajador = telTrabajador;
    }

    public String getEmailTrabajador() {
        return emailTrabajador;
    }

    public void setEmailTrabajador(String emailTrabajador) {
        this.emailTrabajador = emailTrabajador;
    }

    public int getIdCargoTrabajador() {
        return idCargoTrabajador;
    }

    public void setIdCargoTrabajador(int idCargoTrabajador) {
        this.idCargoTrabajador = idCargoTrabajador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MTrabajador{" + "idTrabajador=" + idTrabajador + ", dniTrabajador=" + dniTrabajador + ", nombreTrabajador=" + nombreTrabajador + ", apellidoPaternoTrabajador=" + apellidoPaternoTrabajador + ", apellidoMaternoTrabajador=" + apellidoMaternoTrabajador + ", direccionTrabajador=" + direccionTrabajador + ", telTrabajador=" + telTrabajador + ", emailTrabajador=" + emailTrabajador + ", idCargoTrabajador=" + idCargoTrabajador + ", idUsuario=" + idUsuario + ", estado=" + estado + '}';
    }
    
    
}
