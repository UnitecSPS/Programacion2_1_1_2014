/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg3;

/**
 *
 * @author Docente2014
 */
public abstract class CuentaBancaria {
    protected int codigo;
    protected String nombre;
    protected double saldo;

    public CuentaBancaria(int codigo, String nombre, double saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public final int getCodigo() {
        return codigo;
    }

    public final String getNombre() {
        return nombre;
    }

    public final double getSaldo() {
        return saldo;
    }
    
    public abstract void deposito(double monto);
    
    public abstract boolean retiro(double monto);
    
    public void imprimir(){
        System.out.println("C=" + codigo+" N=" + nombre+
                " sal=" + saldo);
    }
}
