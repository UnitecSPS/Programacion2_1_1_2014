/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Clase {
    Scanner lea = new Scanner(System.in);
    ArrayList<String> als;
    
    public Clase(){
        als = new ArrayList<>();
        als.add("Alejandro");
        als.add("Edwin");
        als.add("Leonel");
    }
    
    public void metodoA(){
        metodoB();   
        System.out.println("Terminando Metodo A");
    }
    
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
    
    public void pasarLista(){
        if(!als.contains("Andres"))
            throw new AndresException();
    }
}