/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg3;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Docente2014
 */
public class CuentaCheques extends CuentaBancaria {
    private ArrayList<String> cheques;

    public CuentaCheques(int codigo, String nombre) {
        super(codigo, nombre, 5000);
        cheques = new ArrayList<>();
    }

    @Override
    public void deposito(double monto) {
        saldo += monto;
    }

    @Override
    public boolean retiro(double monto) {
        if(saldo > monto){
            saldo -= monto;
            cheques.add("Cheque: " + (cheques.size()+1)+
                    " cobrado por el monto de Lps." +
                    monto + " el " + new Date());
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        super.imprimir(); 
        for(String che : cheques)
            System.out.println("-"+che);
    }
    
    public void cambiarLibreta(){
        cheques.clear();
    }
}
