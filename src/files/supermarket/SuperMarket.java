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
    
    private int getCod(int offset)throws IOException{
        RandomAccessFile rCods= new RandomAccessFile(rootFolder+"/codigos.smk", "rw");
        rCods.seek(offset);
        int cod = rCods.readInt();
        rCods.seek(offset);
        rCods.writeInt(cod+1);
        rCods.close();
        return cod;
    }
    
    private int getCodProd()throws IOException{
        return getCod(0);
    }
    
    private int getCodFact()throws IOException{
        return getCod(4);
    }
    
    public void agregarProducto(String nombre, double precio, TipoProducto tipo) throws IOException{
        rProd.seek(rProd.length());
        //codigo
        rProd.writeInt(getCodProd());
        //nombre
        rProd.writeUTF(nombre);
        //precio
        rProd.writeDouble(precio);
        //invent
        rProd.writeInt(10);
        //tipo
        rProd.writeUTF(tipo.name());
    }
    
    public void listadoProds()throws IOException{
        rProd.seek(0);
        
        while(rProd.getFilePointer() < rProd.length()){
            int cod = rProd.readInt();
            String n = rProd.readUTF();
            double precio = rProd.readDouble();
            int inv = rProd.readInt();
            String tipo = rProd.readUTF();
            
            System.out.printf("%d- %S Lps. %.2f - %d items - %s\n",
                    cod, n, precio, inv, tipo);
        }
    }
}
