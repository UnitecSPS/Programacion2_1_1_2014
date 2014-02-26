/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Clase implements Closeable {
    Scanner lea = new Scanner(System.in);
    ArrayList<String> als;
    
    public Clase(){
        als = new ArrayList<>();
        als.add("Alejandro");
        als.add("Edwin");
        als.add("Leonel");
    }
    
    public void metodoA(){
        this.metodoB();
        System.out.println("Terminando Metodo A");
    }
    
    /**
     * @throws ArithmeticException Si se ingresa 0
     * @throws InputMismatchException Si no ingreso un entero
     * @throws ArrayIndexOutOfBoundsException Si ingreso un valor menor 10
     */
    public void metodoB(){
        int x= lea.nextInt();
        int y = 10/x;
        int arr[] = {1,2};
        int z = arr[y];
        System.out.println("Terminando Metodo B");
    }
    
    public void cerrarConexion(){
        System.out.println("Cerrando conexion.....");
    }
    
    public void lista() throws AndresException{
        pasarLista();
    }
    
    /**
     * Esta funcion sirve para pasar lista
     * @throws AndresException  Si Andres no esta en la clase
     */
    public void pasarLista()throws AndresException{
        try{        
            if(!als.contains("Andres"))
                throw new AndresException();
            throw new IOException();
        }
        catch(IOException e){
            //throw e;
        }
    }

    @Override
    public void close() throws IOException {
        cerrarConexion();
    }
}
