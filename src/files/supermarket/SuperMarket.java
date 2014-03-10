/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files.supermarket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Docente 17082011
 */
public class SuperMarket {
    private RandomAccessFile rProd;
    private final String rootFolder = "superfiles";
    private final String rootFacturas = rootFolder + "/facturas/";
    public static final double TASA_IMPUESTO = 0.15;
    
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
    
    public void facturar(String cliente)throws IOException{
        double st=0, imp, tp;
        int codfact = getCodFact();
        RandomAccessFile rFact = new RandomAccessFile(rootFacturas+"factura_"+codfact+".smk", "rw");
        //codfactura
        rFact.writeInt(codfact);
        //fecha
        rFact.writeLong(new Date().getTime());
        //cliente
        rFact.writeUTF(cliente);
        //impuesto
        rFact.writeDouble(TASA_IMPUESTO);
        
        do{
            String res = JOptionPane.showInputDialog("Ingrese Codigo Procuto: ");
            int codprod = Integer.parseInt(res);
            if( buscarProd(codprod) )
            {
                //lo encontre
                rFact.writeInt(codprod);
                System.out.print("Producto: " +
                        rProd.readUTF());
                //precio del producto-------
                double precio = rProd.readDouble();
                rFact.writeDouble(precio);
                System.out.print(" Precio "+precio);
                //cantidad--------------------------
                res = JOptionPane.showInputDialog("Ingrese Cantidad: ");
                int cantidad = Integer.parseInt(res);
                rFact.writeInt(cantidad);
                int inv = rProd.readInt();
                rProd.seek(rProd.getFilePointer()-4);
                rProd.writeInt(inv-cantidad);
                //total del item------------------------
                double stitem = precio * cantidad;
                st += stitem;
                //imprimir datos del item
                System.out.println(" "+cantidad + " - Lps"+stitem);
                //ahora le preguntamos al usuario si quiere otro
                int op = JOptionPane.showConfirmDialog(null, "Desea Ingresar Otro", 
                        "Alerta", JOptionPane.YES_NO_OPTION);
                
                if(op != JOptionPane.YES_OPTION)
                    break;
            }
            else{
                JOptionPane.showMessageDialog(null, "Alertaa", 
                        "Producto no Existe", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
        System.out.println("Subtotal de Factura: " + st);
        imp = st * TASA_IMPUESTO;
        System.out.println("Impuesto: " + imp);
        tp = st + imp;
        System.out.println("Total Pagar: " + tp);
    }

    /**
     * TODO: Van a buscar dentro del archivo de productos
     * si ese producto con ese codigo, existe o no.
     * Si existe el puntero queda justo despues de leer el
     * codigo
     * @param codProducto Codigo de el producto
     * @return Si producto existe retorna true, sino, false.
     */
    private boolean buscarProd(int codProducto) throws IOException {
        rProd.seek(0);
        while(rProd.getFilePointer() < rProd.length()){
            int cod = rProd.readInt();
            if(cod==codProducto)
                return true;
            else{
                //mover el puntero hasta final del registro
                rProd.readUTF();
                //Precio + Inv
                rProd.seek(rProd.getFilePointer()+12);
                rProd.readUTF();
            }
        }
        return false;
    }
    
    private RandomAccessFile buscarFactura(int codFactura) throws FileNotFoundException{
        String nombreFile = rootFacturas+"factura_"+codFactura+".smk";
        //recorro todo el folder de facturas, buscando
        //dicho archivo------------------
        File f = new File(nombreFile);
        if(f.exists()){
            return new RandomAccessFile(f, "rw");
        }
        return null;
    }
    
    /**
     * Busca el producto, si existe ADICIONA al inventario
     * la cantidad de items que recibe de parametro
     * @param codProd Codigo Producto
     * @param cantItems Cantidad de Itemas a adicionar
     * @return 
     * @throws java.io.IOException 
     */
    public boolean comprarItems(int codProd,int cantItems) throws IOException{
        if( buscarProd(codProd) ){
            rProd.readUTF();
            rProd.readDouble();
            int inv = rProd.readInt();
            rProd.seek(rProd.getFilePointer()-4);
            rProd.writeInt(inv+cantItems);
            return true;
        }
        return false;
    }
    
    /**
     * Recibe el codigo de la factura, Si esta existe,
     * se imprime la factura con todos sus datos
     * incluyendo subtotal items, subtotal factura, impuesto
     * y total a pagar.
     * Cada item se imprime: 
     * COD PROD - NOMBRE PROD - CANT LLEVADA - PRECIO - ST PROD 
     * @param codFact 
     * @throws java.io.IOException 
     */
    public void mostrarFactura(int codFact) throws IOException{
        //busco la factura
        RandomAccessFile rFact = buscarFactura(codFact);
        //valido que exista
        if( rFact != null ){
            rFact.readInt();//codigo factura
            Date fecha = new Date(rFact.readLong());//fecha
            String cliente = rFact.readUTF();
            double tasaImpUsada = rFact.readDouble();
            System.out.println(codFact+" - " + cliente +
                    " - " + fecha);
            //---------Luego imprimir sus items comprados
            System.out.println("ITEMS\n-------");
            double st=0;
            while(rFact.getFilePointer() < rFact.length()){
                int codprod = rFact.readInt();
                String nombreprod = getNombreProd(codprod);
                double precio = rFact.readDouble();
                int cantidad = rFact.readInt();
                double stitem = precio * cantidad;
                System.out.println(codprod+" - "+nombreprod+
                        " - " + cantidad + " Lps." + precio +
                        " - Lps." + stitem);
                st += stitem;
            }
            //imprimir datos finales------------------------
            System.out.println("Subtotal: " + st);
            double imp = st * tasaImpUsada;
            System.out.println("Impuesto: "+imp);
            System.out.println("Total: " + (st+imp));
        }
        else
            System.out.println("Factura NO Existe\n");
    }

    private String getNombreProd(int codprod) throws IOException {
        if(buscarProd(codprod))
            return rProd.readUTF();
        else
            return "Producto No Encontrado";
    }
    
    /**
     * Recorre todas las facturas generadas y retorna el monto total
     * generado entre todas ellas
     * @return Monto Total
     * @throws IOException Si algo con el archivo falla 
     */
    public double montoGenerado() throws IOException{
        File folder = new File(rootFacturas);
        double tp =0;
        for(File factura : folder.listFiles()){
            tp += totalDefactura(factura);
        }
        return tp;
    }
    
    public double totalDefactura(File fact)throws IOException{
        RandomAccessFile rf = new RandomAccessFile(fact, "r");
        rf.seek(12);
        rf.readUTF();
        double imp = rf.readDouble();
        double st = 0;
        
        while(rf.getFilePointer() < rf.length()){
            rf.readInt();
            double precio = rf.readDouble();
            int cantidad = rf.readInt();
            st += precio * cantidad;
        }
        
        return st + (st*imp);
    }

    void cerrar() throws IOException {
        rProd.close();
    }
    
    
}
