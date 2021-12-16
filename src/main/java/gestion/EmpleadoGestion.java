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
import model.Empleado;


/**
 *
 * @author arivera
 */
public class EmpleadoGestion {
   private static final String SQL_SELECT_EMPLEADO = "select * from empleados where id=?";

    public static Empleado getEmpleado(String id) {

        Empleado empleado = null;

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_EMPLEADO);
            consulta.setString(1, id);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {
                empleado= new Empleado(
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
        return empleado;

    }
    
    private static final String SQL_SELECT_EMPLEADOS = "Select * from empleados";

    public static ArrayList<Empleado> getEmpleado() {

        ArrayList<Empleado> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_EMPLEADOS);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Empleado(rs.getString(1),
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

