
package model;

public class Usuario {

        
    private String idUsuario;
    private String pwUsuario;
    private String nombreUsuario;
    private String correoCliente;

    public Usuario(String idUsuario, String nombreUsuario, String correoCliente) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoCliente = correoCliente;
    }

   
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPwUsuario() {
        return pwUsuario;
    }

    public void setPwUsuario(String pwUsuario) {
        this.pwUsuario = pwUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    
}
