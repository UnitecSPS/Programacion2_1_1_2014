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
public interface IConnection {
    int version = 123;
    void makeConnection();
    String getIP();
}
