/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.ArticuloGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Articulo;


@Named(value = "articuloController")
@SessionScoped
public class ArticuloController extends Articulo implements Serializable {

     public ArticuloController() {
    }
   public String inserta (){
        
        if (ArticuloGestion.insertar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible id duplicada");
            FacesContext.getCurrentInstance().addMessage("editaArticuloForm:id",mensaje);
            return "editar.xhtml";
        } 
    }
    
    public String modifica (){
        
        if (ArticuloGestion.actualiza(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible id duplicada");
            FacesContext.getCurrentInstance().addMessage("editaArticuloForm:id",mensaje);
            return "editar.xhtml";
        }
    }
    
    public String elimina (){
        
        if (ArticuloGestion.eliminar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaArticuloForm:id",mensaje);
            return "editar.xhtml";
        }
    }
    
    
   

    public String edita (String id){
        
        Articulo articulos = ArticuloGestion.getArticulo(id);

        
        if (articulos!=null){
            this.setId(articulos.getId());
            this.setNombre(articulos.getNombre());
            this.setPrecio(articulos.getPrecio());
            this.setDescription(articulos.getDescription());
            
            return "editar.xhtml";
        }else{
              FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm",mensaje);
            return "list.xhtml";
        }
    }
    
        
         public List<Articulo> getArticulo(){
        
        return ArticuloGestion.getArticulos();
        
    
    }
         
          private boolean noImprimir = true; 

    public boolean isNoImprimir() {
        return noImprimir;
    }

    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }
    
    
         public void buscaPlatos (String id){
        
        Articulo articulos = ArticuloGestion.getArticulo(id);
        
        if (articulos !=null){
            this.setId(articulos.getId());
            this.setNombre(articulos.getNombre());
            this.setPrecio(articulos.getPrecio());
            this.setDescription(articulos.getDescription());
            
            this.noImprimir= false;
            
        }else{
            this.setId("");
            this.setNombre("");
            this.setPrecio("");
            this.setDescription("");
            
           
            FacesMessage mensaje = new FacesMessage (FacesMessage.SEVERITY_WARN, "No Encontrado",
                    "Articulo no Encontrado");
            FacesContext.getCurrentInstance().addMessage("datosArticuloForm:id", mensaje);
            this.noImprimir=true;
        }
        
        
    }
    
    
    
}
