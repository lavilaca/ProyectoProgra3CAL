
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import gestion.UsuarioGestion;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;



@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    
    public UsuarioController() {
        super ("","","","");      
        
    }
    
    public String valida(){
        
        Usuario usuario= UsuarioGestion.Valida(this.getIdUsuario(), this.getPwUsuario());
        
        if (usuario!=null){
            this.setIdUsuario(usuario.getIdUsuario());
            this.setNombreUsuario(usuario.getNombreUsuario());
            this.setCorreoCliente(usuario.getCorreoCliente());
       
            return "principal.xhtml";
        }else{
            
            FacesMessage msg = new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error","Usuario o "
                    + "Contraseña inválidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "index.xhtml";
            
        }
        
        
        
    }
    
    
    
}
