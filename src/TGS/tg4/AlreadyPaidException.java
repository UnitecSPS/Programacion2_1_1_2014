/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg4;

/**
 *
 * @author Docente 17082011
 */
public class AlreadyPaidException extends RuntimeException{
    public AlreadyPaidException(){
        super("Pago Ya Realizado");
    }
}
