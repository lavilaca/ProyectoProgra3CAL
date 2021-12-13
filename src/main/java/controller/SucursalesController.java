/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import gestion.SucursalesGestion;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Sucursales;

/**
 *
 * @author Luis
 */
@Named(value = "sucursalesController")
@SessionScoped
public class SucursalesController extends Sucursales implements Serializable {
    
     public SucursalesController() {
    }
    
    public List<Sucursales> getSucursales(){
        
        return SucursalesGestion.getSucursales();
        
    }
}
