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
import model.Conexion;
import model.Articulo;
/**
 *
 * @author Luis
 */
public class ArticuloGestion {
    
    private static final String SQL_SELECT_ARTICULO= "SELECT * FROM articulo";
    
 public static ArrayList<Articulo> getArticulos(){
        
        ArrayList<Articulo> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_ARTICULO);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Articulo (rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                       ));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
 
}

