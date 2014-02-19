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
public class TestConnections {
    public static void main(String[] args) {
        IConnection icon = new IPhone("12",12,"gotcha");
        //IConnection icon = new PS3();
        icon.makeConnection();
        
        if( icon instanceof Printeable )
            System.out.println(icon);
    }
}
