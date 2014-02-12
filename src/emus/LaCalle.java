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
public class LaCalle {
    public static void main(String[] args) {
        Multa m1 = new Multa("LEVE");
        Multa m2 = new Multa(TipoMulta.GRAVE);
        
        m1.cuantoPago();
        m2.cuantoPago();
        
        if( m1.tm == TipoMulta.GRAVE ){
            
        }
        
        if( m1.tm.name().equals("GRAVE")){
            
        }
        
        if(m1.tm.ordinal() == 0){
            
        }
    }
}
