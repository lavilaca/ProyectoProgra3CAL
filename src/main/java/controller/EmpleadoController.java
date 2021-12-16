/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.EmpleadoGestion;
import gestion.SucursalGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empleado;




/**
 *
 * @author arivera
 */
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController extends Empleado implements Serializable {

    /**
     * Creates a new instance of EmpleadoController
     */
    public EmpleadoController() {
    }
     public List<Empleado> getEmpleado(){
        
        return EmpleadoGestion.getEmpleado();
        
    
    }
    
     private boolean noImprimir = true; // Para habilitar o deshabilitar el botón que imprime la certificación

    public boolean isNoImprimir() {
        return noImprimir;
    }

    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }
    
    
    
    
  public void buscaEmpleados (String id){
        
        Empleado empleado = EmpleadoGestion.getEmpleado(id);
        
        if (empleado !=null){
            this.setId(empleado.getId());
            this.setNombreSucursal(empleado.getNombreSucursal());
            this.setNombreEmpleado(empleado.getNombreEmpleado());
            this.setPuestoEmpleado(empleado.getPuestoEmpleado());
            this.setSalarioEmpleado(empleado.getSalarioEmpleado());
            
            this.noImprimir= false;
            
        }else{
             this.setId("");
            this.setNombreSucursal("");
            this.setNombreEmpleado("");
            this.setPuestoEmpleado("");
            this.setSalarioEmpleado("");
            
           
            FacesMessage mensaje = new FacesMessage (FacesMessage.SEVERITY_WARN, "No Encontrado",
                    "Empleado no Encontrado");
            FacesContext.getCurrentInstance().addMessage("datosEmpleadoForm:id", mensaje);
            this.noImprimir=true;
        }
  }
}

