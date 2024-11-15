/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HACK
 */
public class MCategoria extends M_AccionesModelos{
    private int idCategoria = -1;
    private String nombreCategoria;
    private int estadoCategoria;
    
    public MCategoria(){
        
    }
    

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(int estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }
    
    public boolean estructuraCorrectaNombreCategoria(){
        if (nombreCategoria.isEmpty())
            return false;
        for (int i = 0; i < nombreCategoria.length(); i++) {
            if (Character.isDigit(nombreCategoria.charAt(i))){
                return false;
            }
        }
        
        return true;
    }
}
