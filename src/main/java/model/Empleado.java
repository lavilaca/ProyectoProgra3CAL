/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author arivera
 */
public class Empleado {

    private String id;
    private String nombreSucursal;
    private String nombreEmpleado;
    private String puestoEmpleado;
    private String salarioEmpleado;

    public Empleado(String id, String nombreSucursal, String nombreEmpleado, String puestoEmpleado, String salarioEmpleado) {
        this.id = id;
        this.nombreSucursal = nombreSucursal;
        this.nombreEmpleado = nombreEmpleado;
        this.puestoEmpleado = puestoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
    }

    public Empleado() {
    }

 
   public String getSucursal(){
        
        String texto="";

        texto += this.nombreSucursal!=null?this.nombreSucursal+" ":"";
        
        return texto;      
        
    }
   public String getNombre(){
        
        String texto="";

        texto += this.nombreEmpleado!=null?this.nombreEmpleado+" ":"";
        
        return texto;      
        
    }
   public String getPuesto(){
        
        String texto="";

        texto += this.puestoEmpleado!=null?this.puestoEmpleado+" ":"";
        
        return texto;      
        
    }
   public String getSalario(){
        
        String texto="";

        texto += this.salarioEmpleado!=null?this.salarioEmpleado+" ":"";
        
        return texto;      
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public String getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(String salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }
    
    
    
    

}
