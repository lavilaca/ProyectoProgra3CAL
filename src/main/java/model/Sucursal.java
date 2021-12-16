
package model;


public class Sucursal {
    
    private String id;
    private String nombreSucursal;
    private String Telefono;
    private String Correo;
    private String Direccion;

    public Sucursal(String id, String nombreSucursal, String Telefono, String Correo, String Direccion) {
        this.id = id;
        this.nombreSucursal = nombreSucursal;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
    }

    public Sucursal() {
    }

    
     public String getDescripcion(){
        
        String texto="";

        texto += this.nombreSucursal!=null?this.nombreSucursal+" ":"";
        
        
        
        
        return texto;      
        
    }
     
      public String getTele(){
        
        String texto="";

        
        texto += this.Telefono!=null?this.Telefono+" ":"";
     
        
        
        
        return texto;      
        
    }
      public String getMail(){
        
        String texto="";

        
        texto += this.Correo!=null?this.Correo+" ":"";
     
        
        
        
        return texto;      
        
    }
      
      public String getDire(){
        
        String texto="";

        
        texto += this.Direccion!=null?this.Direccion+" ":"";
     
        
        
        
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
    
    
    
}
