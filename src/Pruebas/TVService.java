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
public class TVService extends Servicio {
    private int canales;
    
    public TVService(String n, int cc){
        super(n);
        canales = cc;
    }
    
    @Override
    public double pagar(){
        return canales * 10;
    }
}
