/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Categoria;

import Vista.util.Mensaje;
import modelos.MCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HACK
 */
public class CCategoria {
    public MCategoria consultar(int idCategoria){
        MCategoria mcat = null;
        
        try (Connection con = Basico.Obtener.Conexion()){
            PreparedStatement ps = con.prepareStatement("select * from Categoria where idCategoria = ?");
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            int i;
            if (rs.next()){
                i = 0;
                mcat = new MCategoria();
                mcat.setIdCategoria(rs.getInt(++i));
                mcat.setNombreCategoria(rs.getString(++i));
                mcat.setEstadoCategoria(rs.getInt(++i));
            }
        }catch (SQLException ex){
            Mensaje.ERROR("ERROR: " + idCategoria, "CONSULTAR CATEGORIA");
        }
        
        return mcat;
    }
    
    public MCategoria consultar(String nombreCategoria){
        MCategoria mcat = null;
        try (Connection con = Basico.Obtener.Conexion()){
            PreparedStatement ps = con.prepareStatement("select * from Categoria where categoria = ?");
            ps.setString(1, nombreCategoria);
            ResultSet rs = ps.executeQuery();
            int i;
            if (rs.next()){
                i = 0;
                mcat = new MCategoria();
                mcat.setIdCategoria(rs.getInt(++i));
                mcat.setNombreCategoria(rs.getString(++i));
                mcat.setEstadoCategoria(rs.getInt(++i));
            }
        }catch (SQLException ex){
            Mensaje.ERROR("ERROR: " + nombreCategoria, "CONSULTAR CATEGORIA");
        }
        
        return mcat;
    }
    
    public int agregar(String categoria){
        int rowsAfected = 0;
        try (Connection con = Basico.Obtener.Conexion()){
            PreparedStatement ps = con.prepareStatement("insert into Categoria values (default, ?, default)");
            ps.setString(1, categoria);
            rowsAfected = ps.executeUpdate();
            System.out.println("Categoria agregada: " + categoria);
        } catch (SQLException ex){
            Mensaje.ERROR("ERROR!!! : al agregar caegoria: " + categoria, "AGREGAR CATEGORIA");
        }
        
        return rowsAfected;
    }
    
    public List<MCategoria> listar(){
        List<MCategoria> mcs = new ArrayList<>();
        MCategoria mc = null;
        
        try (Connection con = Basico.Obtener.Conexion()){
            PreparedStatement ps = con.prepareStatement("select * from Categoria");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mc = new MCategoria();
                mc.setIdCategoria(rs.getInt(1));
                mc.setNombreCategoria(rs.getString(2));
                mc.setEstadoCategoria(rs.getInt(3));
                
                mcs.add(mc);
            }
        }catch (SQLException ex){
            Mensaje.ERROR("No se puede listar categoria: " + ex.getMessage(), "LISTAR CATEGORIA");
        }
        
        return mcs;
    }
}
