/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listas;

/**
 *
 * @author Docente 17082011
 */
public class TestNodo {
    public static void main(String[] args) {
        Nodo a = new Nodo("Carlos");
        Nodo b = a;
        b.nombre = "Lardizabal";
        System.out.println("b = " + b.nombre);   
        System.out.println("b = " + a.nombre);
        
        if( a == b )
            System.out.println("ESTAN EN EL MISMO ESPACIO");
    }
}
