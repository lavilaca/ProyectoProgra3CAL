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
import model.Articulo;

/**
 *
 * @author Luis
 */
@Named(value = "articuloController")
@SessionScoped
public class ArticuloController extends Articulo implements Serializable {

    /**
     * Creates a new instance of ArticuloController
     */
    public ArticuloController() {
    }
    
    public List<Articulo> getArticulos(){
        
        return ArticuloGestion.getArticulos();
        
    }
}
