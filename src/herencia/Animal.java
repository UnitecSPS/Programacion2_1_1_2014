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
public abstract class Animal {
    protected String nombre;
    protected int patas;

    public Animal(String nombre, int patas) {
        this.nombre = nombre;
        this.patas = patas;
    }
    
    public static Animal getInstance(String ani){
        if(ani.equals("perro"))
            return new Perro();
        else if(ani.equals("gato"))
            return new Gato();
        else
            return null;
    }
    
    public abstract void hablar();
}
