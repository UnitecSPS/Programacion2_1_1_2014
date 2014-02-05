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
public class Pollo extends Animal {
    public Pollo(){
        super("Pollo",2);
    }

    @Override
    public void hablar() {
        System.out.println("Pio Pio Pio");
    }
}
