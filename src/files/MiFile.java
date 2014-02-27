/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class MiFile {
    private File file;
    
    public void setFile(String path){
        file = new File(path);
    }
    
    public void info(){
        try{
            if( file.exists() ){
                System.out.println("Nombre: " + file.getName());
                System.out.println("Dir Absoluta: " + file.getAbsolutePath());
                System.out.println("Path: " + file.getPath());
                System.out.println("Parent: " + file.getAbsoluteFile().getParent());
                System.out.println("Size: " + file.length());
                
                if(file.isDirectory())
                    System.out.println("ES UN DIRECTORIO");
                else if(file.isFile())
                    System.out.println("ES UN ARCHIVO");
                
                if(file.isHidden())
                    System.out.println("ESTA OCULTO");
                
                Date d = new Date(file.lastModified());
                System.out.println("Ultima Fecha Modif: " + d);
            }
            else{
                System.out.println("Archivo no existe");
            }
        }catch(NullPointerException e){
            System.out.println("Seleccione un path primero");
        }
    }
    
    public boolean crearArchivo() throws IOException{
        try{
            return file.createNewFile();
        }catch(NullPointerException e){
            System.out.println("Seleccione un path primero");
            return false;
        }
    }
}
