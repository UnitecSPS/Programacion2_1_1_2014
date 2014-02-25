/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

/**
 *
 * @author Docente 17082011
 */
public class Aula {
    public static void main(String[] args) {
        Clase cla = new Clase();
        try{
            cla.pasarLista();
        }
        catch(AndresException e){
            System.out.println("Error: " + e);
        }
    }
}
