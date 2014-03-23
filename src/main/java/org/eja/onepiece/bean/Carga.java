/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.onepiece.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author quique
 */
@ManagedBean
@ApplicationScoped
public class Carga {
    
    public static File CAPITULOS_DIRECTORY;
    public static File PELICULAS_DIRECTORY;
    public static InputStream is;
    public static FileOutputStream fos;
    public static byte[] datos;
    public static File archivoSalida;
    
    public void subeCapitulos(FileUploadEvent event) {
        
        CAPITULOS_DIRECTORY = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/capitulos"));
        
        if(!CAPITULOS_DIRECTORY.exists())CAPITULOS_DIRECTORY.mkdir();
        
        try {
            UploadedFile file = event.getFile();
            
            is = file.getInputstream();
            
            datos = new byte[is.available()];
            
            is.read(datos);
            
            archivoSalida = new File(CAPITULOS_DIRECTORY,file.getFileName());
            
            fos = new FileOutputStream(archivoSalida);
            
            fos.write(datos);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.flush();
                fos.close();
                is.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    public void subePeliculas(FileUploadEvent event) {
        
        PELICULAS_DIRECTORY = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/peliculas"));
        
        if(!PELICULAS_DIRECTORY.exists())PELICULAS_DIRECTORY.mkdir();
        
        try {
            UploadedFile file = event.getFile();
            
            is = file.getInputstream();
            
            datos = new byte[is.available()];
            
            is.read(datos);
            
            archivoSalida = new File(PELICULAS_DIRECTORY,file.getFileName());
            
            fos = new FileOutputStream(archivoSalida);
            
            fos.write(datos);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.flush();
                fos.close();
                is.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
