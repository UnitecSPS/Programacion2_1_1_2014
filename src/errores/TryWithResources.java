/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.io.IOException;

/**
 *
 * @author Docente 17082011
 */
public class TryWithResources {
    public static void main(String[] args) {
        try(Clase a = new Clase()){
            a.metodoA();
        }
        catch(IOException e){
            
        }
    }
}
