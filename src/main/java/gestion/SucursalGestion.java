
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
     private static final String SQL_INSERT_SUCURSAL = "insert into articulo (id,nombreSucursal,Telefono,Correo, Descripcion) values (?,?,?,?,?)";

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

    private static final String SQL_SELECT_ARTICULO = "select * from articulo where id=?";

    public static Articulo getArticulo(String id) {

        Articulo articulos = null;

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ARTICULO);
            consulta.setString(1, id);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {
                articulos = new Articulo(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulos;

    }
    
       private static final String SQL_UPDATE_ARTICULOS = "update articulo set nombreDevice=?,precio=?,description=? where id=?";
    
    public static boolean actualiza (Articulo articulos){
        
        try{
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_ARTICULOS);
            sentencia.setString(1, articulos.getNombreDevice());
            sentencia.setString(2, articulos.getPrecio());
            sentencia.setString(3, articulos.getDescription());
            sentencia.setString(4, articulos.getId());
            
           
            
            return sentencia.executeUpdate()>0; 
            
        }catch(SQLException ex){
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return false;
                
    }
    
    private static final String SQL_DELETE_ARTICULOS= "delete from articulo where id=?";
    
    public static boolean eliminar (Articulo articulos){
        
        try{
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_ARTICULOS);
            consulta.setString(1, articulos.getId());
            
            return consulta.executeUpdate()>0; 
            
        }catch (SQLException ex){
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return false;
    }
    

    private static final String SQL_SELECT_ARTICULOS = "Select * from articulo";

    public static ArrayList<Articulo> getArticulo() {

        ArrayList<Articulo> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ARTICULOS);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Articulo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
