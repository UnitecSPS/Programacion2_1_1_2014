/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files.supermarket;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class LaColonia {
    public static void main(String[] args) {
        SuperMarket sm = new SuperMarket();
        Scanner lea = new Scanner(System.in);
        
        int op=0;
        
        do{
            System.out.println("1- Agegar Producto");
            System.out.println("2- Listar Producto");
            System.out.println("3- Salir");
            System.out.println("Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        System.out.println("Nombre: ");
                        String n = lea.next();
                        System.out.println("Precio: ");
                        double p = lea.nextDouble();
                        System.out.println("Tipo: ");
                        TipoProducto t = TipoProducto.valueOf(lea.next().toUpperCase());
                        sm.agregarProducto(n, p, t);
                        break;
                    case 2:
                        sm.listadoProds();
                        break;
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }while(op != 3);
    }
}
