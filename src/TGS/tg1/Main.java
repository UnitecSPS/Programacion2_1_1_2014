/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente2014
 */
public class Main {
    static ArrayList<RentItem> items = new ArrayList<>();
        
    public static void main(String[] args) {
        int op;
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Agregar");
            System.out.println("2- Rentar");
            System.out.println("3- SubMenu");
            System.out.println("4- Salir");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Tipo?: ");
                    String tipo = lea.next();
                    addItem(tipo);
                    break;
                case 2:
                    System.out.println("Codigo: ");
                    int cod = lea.nextInt();
                    rentarItem(cod);
                    break;
                case 3:
                    System.out.println("Codigo: ");
                    cod = lea.nextInt();
                    subMenuItem(cod);
                    break;
            }
            
        }while(op!=4);
    }

    private static void addItem(String tipo) {
    }

    private static void rentarItem(int cod) {
    }

    private static void subMenuItem(int cod) {
    }
}
