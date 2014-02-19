/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author Docente2014
 */
public class Phone {
    protected String numero;
    protected int serial;

    public Phone(String numero, int serial) {
        this.numero = numero;
        this.serial = serial;
    }

    public String getNumero() {
        return numero;
    }

    public int getSerial() {
        return serial;
    }
    
    public void call(int num){
        System.out.println("Calling..."+num);
    }
}
