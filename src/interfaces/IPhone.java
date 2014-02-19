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
public class IPhone extends Phone implements IConnection, Printeable{
    private String itunes;
    
    public IPhone(String numero, int serial, String i) {
        super(numero, serial);
        itunes = i;
    }

    public String getItunes() {
        return itunes;
    }

    @Override
    public void makeConnection() {
        System.out.println("Loading Safari");
    }

    @Override
    public String getIP() {
        
        return "192.168.36.25";
    }

    @Override
    public String toString() {
        return "IPhone{" + "itunes=" + itunes + '}';
    }
}
