
package controller;

import gestion.SucursalGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Sucursal;


@Named(value = "sucursalController")
@SessionScoped
public class SucursalController extends Sucursal implements Serializable {

   
    public SucursalController() {
        
    }
    
     public String inserta (){
        
        if (SucursalGestion.insertar(this)){
            return "lista.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible id duplicada");
            FacesContext.getCurrentInstance().addMessage("editaSucursalForm:id",mensaje);
            return "editar.xhtml";
        } 
    }
    
    public String modifica (){
        
        if (SucursalGestion.actualiza(this)){
            return "lista.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible id duplicada");
            FacesContext.getCurrentInstance().addMessage("editaSucursalForm:id",mensaje);
            return "editar.xhtml";
        }
    }
    
    public String elimina (){
        
        if (SucursalGestion.eliminar(this)){
            return "lista.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaSucursalForm:id",mensaje);
            return "editar.xhtml";
        }
    }
    
    
   

    public String edita (String id){
        
        Sucursal sucursales = SucursalGestion.getSucursal(id);

        
        if (sucursales!=null){
            this.setId(sucursales.getId());
            this.setNombreSucursal(sucursales.getNombreSucursal());
            this.setTelefono(sucursales.getTelefono());
            this.setCorreo(sucursales.getCorreo());
            this.setDireccion(sucursales.getDireccion());
            
            return "editar.xhtml";
        }else{
              FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm",mensaje);
            return "lista.xhtml";
        }
    }
    
        
         public List<Sucursal> getSucursal(){
        
        return SucursalGestion.getSucursal();
        
    
    }
  private boolean noImprimir = true; // Para habilitar o deshabilitar el botón que imprime la certificación

    public boolean isNoImprimir() {
        return noImprimir;
    }

    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }
    
    
         public void buscaSucursal (String id){
        
        Sucursal sucursal = SucursalGestion.getSucursal(id);
        
        if (sucursal !=null){
            this.setId(sucursal.getId());
            this.setNombreSucursal(sucursal.getNombreSucursal());
            this.setTelefono(sucursal.getTelefono());
            this.setCorreo(sucursal.getCorreo());
            this.setDireccion(sucursal.getDireccion());
            
            this.noImprimir= false;
            
        }else{
            this.setId("");
            this.setNombreSucursal("");
            this.setTelefono("");
            this.setCorreo("");
            this.setDireccion("");
            
           
            FacesMessage mensaje = new FacesMessage (FacesMessage.SEVERITY_WARN, "No Encontrado",
                    "Sucursal no Encontrada");
            FacesContext.getCurrentInstance().addMessage("datosSucursalForm:id", mensaje);
            this.noImprimir=true;
        }
        
        
    }
         
         @Override
    public String toString() {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       
        return "\"Sucursales\":{\n"
                + "\"Ferreteria CAL San Jose  Telefono:22556685  Correo:adminSJOFCAL@ferreteriaCAL.com Direccion: 100 metros Sur de la municipalidad de San Jose \":\" \n"
                + "\"Ferreteria CAL Heredia  Telefono:25634185  Correo:adminHEREDIAFCAL@ferreteriaCAL.com Direccion: Mall Real Cariari, tienda numero 25 \":\" \n"
                + "\"Ferreteria CAL Cartago  Telefono:28549652  Correo:adminCARTAGOFCAL@ferreteriaCAL.com Direccion: A un costado del maxipali de Cartago Centro \":\" \n"
                + "\"Ferreteria CAL Puntarenas  Telefono:26469832  Correo:adminPTSFCAL@ferreteriaCAL.com Direccion: Frente asociacion copepuntarenas SA \":\" \n";
                
     }

    @Override
    public String getNombreSucursal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


    
    
    


    

