/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.eja.onepiece.bean;

import java.io.File;
import java.util.regex.Matcher;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.eja.onepiece.pojo.ArchivoVideo;

/**
 *
 * @author quique
 */
@ManagedBean
@RequestScoped
public class Visor {

    private String rutaVideo;
    private String tipo;
    private String capitulo;
    
    public Visor() {
        
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        tipo = request.getParameter("tipo");
        capitulo = request.getParameter("capitulo");
        
        
        rutaVideo = tipo+"/"+capitulo+".mp4";        
        
    }

    public String getRutaVideo() {
        return rutaVideo;
    }

    public void setRutaVideo(String rutaVideo) {
        this.rutaVideo = rutaVideo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    
}
