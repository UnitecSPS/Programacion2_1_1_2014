/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

/**
 *
 * @author Docente2014
 */
public class Perro extends Animal {

    public Perro(){
        super("Perro",4);
    }
    
    @Override
    public void hablar() {
        System.out.println("Guau Guau Guau");
    }
    
    public void esconderHueso(){
        System.out.println("escabar y esconder");
    }
    
}
