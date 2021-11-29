/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario;


public class UsuarioGestion {
    
    private static final String SQL_VALIDA="select nombreUsuario,idRol from usuario where idUsuario=? and pwUsuario=MD5(?)";
    
    public static Usuario Valida (String idUsuario, String password){
        
        Usuario usuario=null;
        
        try{
            
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_VALIDA);
            sentencia.setString(1, idUsuario);
            sentencia.setString(2, password);
            ResultSet rs= sentencia.executeQuery();
            
            if (rs.next()){
                usuario = new Usuario(idUsuario,rs.getString(1),rs.getString(2));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE,null,ex);
            
        }

        return usuario;
    }
    
    
}
