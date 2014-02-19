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
public class PS3 implements IConnection {
    private String modelo;
    
    public void loadGame(){
        System.out.println("Loading Game....");
    }
    
    public void exitGame(){
        System.out.println("GoodBye");
    }

    @Override
    public void makeConnection() {
        System.out.println("Connection PS3 to Internet");
    }

    @Override
    public String getIP() {
        return "192.168.3.5";
    }
}
