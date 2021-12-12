/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Articulo;
import model.Conexion;
import model.Sucursales;

/**
 *
 * @author Luis
 */
public class SucursalesGestion {
    
    private static final  String SQL_SELECT_Sucursales = 
            "SELECT * FROM Sucursales";
    
    
    
     public static ArrayList<Sucursales> getSucursales(){
        
        ArrayList<Sucursales> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_Sucursales);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Sucursales (rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                       ));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(SucursalesGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
 
}
    
 
        
    

