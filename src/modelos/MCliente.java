/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Vista.util.Mensaje;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HACK
 */
public class MCliente extends M_AccionesModelos{

    private int idCliente;
    private String dniCliente;
    private String nombreCliente;
    private String apellidoPaternoCliente;
    private String apellidoMaternoCliente;
    private String direccionCliente;
    private String telCliente;
    private String emailCliente;
    private int estadoCliente;
    private String errores;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoPaternoCliente() {
        return apellidoPaternoCliente;
    }

    public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
        this.apellidoPaternoCliente = apellidoPaternoCliente;
    }

    public String getApellidoMaternoCliente() {
        return apellidoMaternoCliente;
    }

    public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
        this.apellidoMaternoCliente = apellidoMaternoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(int estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getErrores() {
        return errores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idCliente).append(",");
        sb.append(dniCliente).append(",");
        sb.append(nombreCliente).append(",");
        sb.append(apellidoPaternoCliente).append(",");
        sb.append(apellidoMaternoCliente).append(",");
        sb.append(direccionCliente).append(",");
        sb.append(telCliente).append(",");
        sb.append(emailCliente).append(",");
        sb.append(estadoCliente == 1 ? "Activo" : "Inactivo");
        return sb.toString();
    }

    public boolean esDni(String cadena) {
        if (cadena.matches("[\\d]{6,8}")) {
            return true;
        }
        Mensaje.ADVERTENCIA("Estructura de DNI INCORRECTA.", "Incorrecto");
        return false;
    }

    public boolean esTelefono(String cadena) {
        if (cadena.matches("[\\d]{9}")) {
            return true;
        }
        Mensaje.ADVERTENCIA("Estructura de Teléfono INCORRECTA.", "Incorrecto");
        return false;
    }

    public boolean esEmail(String cadena) {
        if (cadena.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return true;
        }
        Mensaje.ADVERTENCIA("Estructura de Email INCORRECTA.", "Incorrecto");
        return false;
    }

    public boolean emptyField(String cadena) {
        return cadena.isEmpty();
    }

    public boolean emptyField(int num) {
        return String.valueOf(num).length() == 0;
    }

    // ---------------
    public String emptyField(String cadena, String campo) {
        if (MCliente.this.emptyField(cadena)) {
            return "\t* " + campo + " ( Faltante )\n";
        }
        return "";
    }

    public String emptyField(int num, String campo) {
        if (MCliente.this.emptyField(num)) {
            return "\t* " + campo + " ( Faltante )";
        }
        return "";
    }

    private String incorrectoDni(String cadena) {
        if (!cadena.matches("[\\d]{6,8}")) {
            return "\t* Estructura de DNI INCORRECTA.\n";
        }

        return "";
    }

    private String incorrectoTelefono(String cadena) {

        Pattern regex = Pattern.compile("^[\\d]{9}$");
        if (!regex.matcher(cadena).find()) {
            return "\t* Estructura de Teléfono INCORRECTA.\n";
        }
        return "";
    }

    private String incorrectoEmail(String cadena) {
        Pattern regex = Pattern.compile("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+");
        if (!regex.matcher(cadena).find()) {
            return "\t* Estructura de Email INCORRECTA.\n";
        }
        return "";
    }

    public boolean estructuraCamposCorrecta() {
        errores = incorrectoDni(dniCliente) + incorrectoTelefono(telCliente) + incorrectoEmail(emailCliente);
        if (!errores.isEmpty()) {
            errores = "Errores encontrados:\n\n" + errores;
        }
        return errores.isEmpty();
    }

    public boolean emptyFields() {
        errores
                = MCliente.this.emptyField(dniCliente, "DNI")
                + MCliente.this.emptyField(nombreCliente, "Nombre")
                + MCliente.this.emptyField(apellidoPaternoCliente, "Apellido paterno")
                + MCliente.this.emptyField(apellidoMaternoCliente, "Apellido Materno")
                + MCliente.this.emptyField(direccionCliente, "Dirección")
                + MCliente.this.emptyField(telCliente, "Teléfono")
                + MCliente.this.emptyField(emailCliente, "Email");

        if (!errores.isEmpty()) {
            errores = "Campos faltantes:\n\n" + errores;
        }
        return !errores.isEmpty();//true -> campos incompletos
    }

}

/*
private int idCliente;
    private String dniCliente;
    private String nombreCliente;
    private String apellidoPaternoCliente;
    private String apellidoMaternoCliente;
    private String direccionCliente;
    private String telCliente;
    private String emailCliente;
    private int estadoCliente;

 */
