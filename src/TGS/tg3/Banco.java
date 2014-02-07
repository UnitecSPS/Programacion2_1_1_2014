/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente2014
 */
public class Banco {
    static ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op, codigo;
        
        do{
            System.out.println("1- Agregar");
            System.out.println("2- Depositar");
            System.out.println("3- Retirar");
            System.out.println("4- Listar");
            System.out.println("5- Registrar Intereses");
            System.out.println("6- Limpiar Libreta");
            System.out.println("7- Salir");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Tipo (AHORRO-CHEQUE): ");
                    String tipo = lea.next();
                    agregarCuenta(tipo);
                    break;
                case 2:
                    System.out.println("Codigo: ");
                    codigo = lea.nextInt();
                    depositarEn(codigo);
                    break;
                case 3:
                    System.out.println("Codigo: ");
                    codigo = lea.nextInt();
                    retirarEn(codigo);
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    registrarInts();
                    break;
                case 6:
                    System.out.println("Codigo: ");
                    codigo = lea.nextInt();
                    limpiarEn(codigo);
                    
            }
        }while(op!=7);
    }
    
    private static CuentaBancaria buscar(int cod){
        for(CuentaBancaria cb : cuentas){
            if( cb.codigo == cod)
                return cb;
        }
        return null;
    }

    private static void agregarCuenta(String tipo) {
        System.out.println("Nom: ");
        String nom = lea.next();
        System.out.println("Codigo: ");
        int cod = lea.nextInt();
        
        if( buscar(cod) == null ){
            if(tipo.equals("AHORRO")){
                System.out.println("Tasa: ");
                double tasa = lea.nextDouble();
                cuentas.add( new CuentaAhorro(cod, nom, tasa));
            }
            else if(tipo.equals("CHEQUE")){
                cuentas.add( new CuentaCheques(cod, nom));
            }
        }
        else
            System.out.println("Codigo ya existe");
    }

    private static void depositarEn(int codigo) {
        CuentaBancaria cb = buscar(codigo);
        
        if( cb != null ){
            cb.deposito(codigo);
        }
        else
            System.out.println("No existe cuenta");
    }

    private static void retirarEn(int codigo) {
        CuentaBancaria cb = buscar(codigo);
        
        if( cb != null ){
            if( cb.retiro(codigo) )
                System.out.println("Retiro exitoso");
            else
                System.out.println("No se puede retirar");
        }
    }

    private static void listar() {
        for(CuentaBancaria cb : cuentas)
            cb.imprimir();
    }

    private static void registrarInts() {
        for(CuentaBancaria cb : cuentas){
            if( cb instanceof CuentaAhorro){
                ((CuentaAhorro)cb).verEstado();
                ((CuentaAhorro)cb).registrarIntereses();
            }
                
        }
    }

    private static void limpiarEn(int codigo) {
        CuentaBancaria cb = buscar(codigo);
        
        if( cb instanceof CuentaCheques ){
            ((CuentaCheques)cb).cambiarLibreta();
        }
        else
            System.out.println("No existe esa cuenta de cheques");
    }
    
}
