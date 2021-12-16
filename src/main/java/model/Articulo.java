
package model;

public class Articulo {

    private String id;
    private String nombreDevice;
    private String precio;
    private String description;
    

    public Articulo(String id, String nombreDevice, String precio,String description) {
        this.id = id;
        this.nombreDevice = nombreDevice;
        this.precio = precio;
        this.description = description;
        
    }

    public Articulo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDevice() {
        return nombreDevice;
    }

    public void setNombreDevice(String nombreDevice) {
        this.nombreDevice = nombreDevice;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}