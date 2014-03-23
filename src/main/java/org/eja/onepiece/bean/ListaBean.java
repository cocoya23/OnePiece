package org.eja.onepiece.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.eja.onepiece.pojo.ArchivoVideo;

@ManagedBean(name = "lista")
@RequestScoped
public class ListaBean {

    private String tipo;
    private List<ArchivoVideo> archivos;

    public ListaBean() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        tipo = request.getParameter("tipo");

        File carpeta = new File(facesContext.getExternalContext().getRealPath("/" + tipo));
        
        if(!carpeta.exists())carpeta.mkdir();

        archivos = new ArrayList<ArchivoVideo>();

        ArchivoVideo archivoVideo = null;

        Pattern p = Pattern.compile("-?\\d+");

        for (String nombreCompleto : carpeta.list()) {

            if (nombreCompleto.endsWith(".mp4")) {
                archivoVideo = new ArchivoVideo();

                archivoVideo.setNombre(nombreCompleto.replace(".mp4", ""));
                Matcher m = p.matcher(nombreCompleto);
                if (m.find()) {
                    archivoVideo.setNumero(m.group());
                }
                archivoVideo.setRutaVisor("/visor.xhtml?tipo="+tipo+"&capitulo="+archivoVideo.getNombre());

                archivos.add(archivoVideo);
            }
        }

    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ArchivoVideo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoVideo> archivos) {
        this.archivos = archivos;
    }

}
