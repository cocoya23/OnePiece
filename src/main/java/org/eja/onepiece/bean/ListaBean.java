package org.eja.onepiece.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.eja.onepiece.pojo.ArchivoVideo;

@ManagedBean(name = "lista")
@ApplicationScoped
public class ListaBean {

    private String tipo;
    private List<ArchivoVideo> archivos;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ArchivoVideo> getArchivos() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

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

                archivos.add(archivoVideo);
            }
        }
        return archivos;
    }

    public void setArchivos(List<ArchivoVideo> archivos) {
        this.archivos = archivos;
    }

}
