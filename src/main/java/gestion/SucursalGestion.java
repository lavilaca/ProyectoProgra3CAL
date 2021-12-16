
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Sucursal;


public class SucursalGestion {
     private static final String SQL_INSERT_SUCURSAL = "insert into sucursales (id,nombreSucursal,Telefono,Correo, Descripcion) values (?,?,?,?,?)";

    public static boolean insertar(Sucursal sucursal) {

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_SUCURSAL);

            sentencia.setString(1, sucursal.getId());
            sentencia.setString(2, sucursal.getNombreSucursal());
            sentencia.setString(3, sucursal.getTelefono());
            sentencia.setString(4, sucursal.getCorreo());
            sentencia.setString(5, sucursal.getDireccion());
            

            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    private static final String SQL_SELECT_SUCURSAL = "select * from sucursales where id=?";

    public static Sucursal getSucursal(String id) {

        Sucursal sucursales = null;

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SUCURSAL);
            consulta.setString(1, id);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {
                sucursales = new Sucursal(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucursales;

    }
    
       private static final String SQL_UPDATE_SUCURSALES = "update sucursales set nombreSucursal=?,Telefono=?,Correo=?,Direccion=? where id=?";
    
    public static boolean actualiza (Sucursal sucursales){
        
        try{
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_SUCURSALES);
            sentencia.setString(1, sucursales.getNombreSucursal());
            sentencia.setString(2, sucursales.getTelefono());
            sentencia.setString(3, sucursales.getCorreo());
            sentencia.setString(4, sucursales.getDireccion());
            sentencia.setString(5, sucursales.getId());
            
           
            
            return sentencia.executeUpdate()>0; 
            
        }catch(SQLException ex){
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return false;
                
    }
    
    private static final String SQL_DELETE_SUCURSALES= "delete from sucursales where id=?";
    
    public static boolean eliminar (Sucursal sucursales){
        
        try{
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_SUCURSALES);
            consulta.setString(1, sucursales.getId());
            
            return consulta.executeUpdate()>0; 
            
        }catch (SQLException ex){
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return false;
    }
    

    private static final String SQL_SELECT_SUCURSALES = "Select * from sucursales";

    public static ArrayList<Sucursal> getSucursal() {

        ArrayList<Sucursal> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SUCURSALES);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Sucursal(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
