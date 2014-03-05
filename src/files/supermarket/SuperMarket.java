/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files.supermarket;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Docente 17082011
 */
public class SuperMarket {
    private RandomAccessFile rProd;
    private final String rootFolder = "superfiles";
    private final String rootFacturas = rootFolder + "/facturas";
    
    public SuperMarket(){
        initFolderRoot();
        initRAccess();
        initCodFile();
    }

    private void initFolderRoot() {
        File f = new File(rootFacturas);
        f.mkdirs();
    }

    private void initRAccess() {
        try{
            rProd = new RandomAccessFile(rootFolder+"/productos.smk", "rw");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    private void initCodFile() {
        try(RandomAccessFile rCods= new RandomAccessFile(rootFolder+"/codigos.smk", "rw")){
            
            if(rCods.length() == 0){
                rCods.writeInt(1);
                rCods.writeInt(1);
            }
            
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
