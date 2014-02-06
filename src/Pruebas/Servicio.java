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
public abstract class Servicio {
    protected String nombre;
    
    public Servicio(String n){
        nombre = n;
    }
    
    public abstract double pagar();
}
