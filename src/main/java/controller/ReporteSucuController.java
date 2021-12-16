
package controller;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Conexion;
import model.Sucursal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@Named(value = "reporteSucuController")
@SessionScoped
public class ReporteSucuController implements Serializable {

 
    public ReporteSucuController() {
    }
    
public void verPdf(){
        
        try{           
            File jasper = new File (FacesContext.getCurrentInstance()
            .getExternalContext().getRealPath("/prospecto/ProspectoJueves.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),null, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo= respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper,flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        }catch (JRException ex){
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE,null,ex);
        }catch (IOException ex){
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
 
    public void descargarPdf(){
        
        try{           
            File jasper = new File (FacesContext.getCurrentInstance()
            .getExternalContext().getRealPath("/prospecto/ProspectoJueves.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),null, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.addHeader("Content-disposition", "attachement; filename=reporte.pdf");
            ServletOutputStream flujo= respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper,flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        }catch (JRException ex){
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE,null,ex);
        }catch (IOException ex){
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
    
     public void planillas(Sucursal sucursal){
        
        Map<String,Object>  parametros = new HashMap<>();
        parametros.put("id", sucursal.getId());
        parametros.put("nombreSucursal", sucursal.getNombreSucursal());
        
         
        try{           
            File jasper = new File (FacesContext.getCurrentInstance()
            .getExternalContext().getRealPath("/reportes/empleados.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),parametros, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo= respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper,flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        }catch (JRException ex){
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE,null,ex);
        }catch (IOException ex){
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
    
    
}

