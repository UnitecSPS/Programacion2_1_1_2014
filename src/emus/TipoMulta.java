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
public enum TipoMulta {
    GRAVE(1000), LEVE(200), MEDIANA(500), MORDIDA(50);
    double precio;
    TipoMulta(double p){
        precio = p;
    }
}
