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
public class Gato extends Felino {
    public Gato(){
        super("Gato");
    }

    @Override
    public void hablar() {
        System.out.println("miau miau miau");
    }
    
    
}
