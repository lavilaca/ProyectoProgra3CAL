/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;

/**
 *
 * @author Luis
 */
public class Sucursales {
    private String Nombre;
    private String Telefono;
    private String Correo;
    private String Direccion;

public Sucursales(){
}

    public Sucursales(String Nombre, String Telefono, String Correo, String Direccion) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

   
    

        
        

@Override
    public String toString() {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       
        return "\"Sucursales\":{\n"
                + "\"Ferreteria CAL San Jose  Telefono:22556685  Correo:adminSJOFCAL@ferreteriaCAL.com Direccion: 100 metros Sur de la municipalidad de San Jose \":\" \n"
                + "\"Ferreteria CAL Heredia  Telefono:25634185  Correo:adminHEREDIAFCAL@ferreteriaCAL.com Direccion: Mall Real Cariari, tienda numero 25 \":\" \n"
                + "\"Ferreteria CAL Cartago  Telefono:28549652  Correo:adminCARTAGOFCAL@ferreteriaCAL.com Direccion: A un costado del maxipali de Cartago Centro \":\" \n"
                + "\"Ferreteria CAL Puntarenas  Telefono:26469832  Correo:adminPTSFCAL@ferreteriaCAL.com Direccion: Frente asociacion copepuntarenas SA \":\" \n";
                
     }}





