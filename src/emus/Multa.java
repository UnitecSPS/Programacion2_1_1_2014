/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emus;

/**
 *
 * @author Docente2014
 */
public class Multa {
    TipoMulta tm;
    
    public Multa(String t){
        tm = TipoMulta.valueOf(t);
    }
    
    public Multa(TipoMulta t){
        tm = t;
    }
    
    public void cuantoPago(){
        System.out.println("Pago " + tm.precio);
    }
}
