
package controller;

import gestion.SucursalGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible id duplicada");
            FacesContext.getCurrentInstance().addMessage("editaArticuloForm:id",mensaje);
            return "edit.xhtml";
        } 
    }
    
    public String modifica (){
        
        if (SucursalGestion.actualiza(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible id duplicada");
            FacesContext.getCurrentInstance().addMessage("editaArticuloForm:id",mensaje);
            return "edit.xhtml";
        }
    }
    
    public String elimina (){
        
        if (SucursalGestion.eliminar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaArticuloForm:id",mensaje);
            return "edit.xhtml";
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
            
            return "edit.xhtml";
        }else{
              FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm",mensaje);
            return "list.xhtml";
        }
    }
    
        
         public List<Sucursal> getSucursal(){
        
        return SucursalGestion.getSucursal();
        
    
    }
      
    
}

    

