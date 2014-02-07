/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg3;

import java.util.Date;

/**
 *
 * @author Docente2014
 */
public class CuentaAhorro extends CuentaBancaria {

    private double tasaInteres;
    private Date ultimaModif;
    private boolean activa;

    public CuentaAhorro(int codigo, String nombre, double tasaInteres) {
        super(codigo, nombre, 500);
        this.tasaInteres = tasaInteres;
        ultimaModif = new Date();
        activa = true;
    }

    @Override
    public void deposito(double monto) {
        if(activa){
            saldo += monto;
        }
        else{
            saldo += monto * 0.8;
            activa = true;
        }
        ultimaModif = new Date();    
    }

    @Override
    public boolean retiro(double monto) {
        if(activa && saldo > monto){
            saldo -= monto;
            ultimaModif = new Date(); 
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        super.imprimir(); 
        System.out.println(" Ts=" + tasaInteres + " uf="+
                ultimaModif + " activa=" + activa);
    }
    
    public final void registrarIntereses(){
        if(activa)
            saldo += saldo * tasaInteres;
    }
    
    public final void verEstado(){
        Date now = new Date();
        long diff = now.getTime() - ultimaModif.getTime();
        double segs = diff/1000.0;
        double mins = segs/60.0;
        double horas = mins/60.0;
        double dias = horas/24.0;
        
        if(dias>=200)
            activa = false;
    }
}
