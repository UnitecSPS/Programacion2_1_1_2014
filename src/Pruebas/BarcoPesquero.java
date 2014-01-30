/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pruebas;

/**
 *
 * @author Docente2014
 */
public class BarcoPesquero extends Barco {
    private double precio;
    private int capturados;
    
    public BarcoPesquero(String n, double p){
        super(n);
        precio = p;
        capturados = 0;
    }
    
    @Override
    public double vaciar(){
        double tot = precio * capturados;
        capturados = 0;
        return tot;
    }
}
