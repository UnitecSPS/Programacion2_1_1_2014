/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.util.InputMismatchException;

/**
 *
 * @author Docente 17082011
 */
public class Test {
    public static void main(String[] args) {
       Clase cla = new Clase();
       
       try{
           cla.metodoA();
       }
       catch(InputMismatchException ex){
           System.out.println("Dato Ingresado incorrecto");
       }
       catch(ArithmeticException ex){
           System.out.println("Error Aritmetico");
       }
       catch(Exception ex){
           System.out.println("ERROR: " + ex.getMessage());
           System.out.println(ex.getStackTrace()[0]);
       }
       
       System.out.println("Terminando Main");
    }
}
