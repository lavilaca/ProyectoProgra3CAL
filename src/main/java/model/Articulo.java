/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Articulo {

     private String id;
     private String nombre;
     private String description;
     private String precio;
     

 
     
    public Articulo(String id,String nombre, String description, String precio){
 this.id = id;
 this.nombre=nombre;
  this.description = description;  
   this.precio = precio;     
}

public Articulo() {
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

      public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }}

   

    
