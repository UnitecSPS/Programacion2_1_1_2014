/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente2014
 */
public class Main {
    static ArrayList<RentItem> items = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);
        
    public static void main(String[] args) {
        int op;
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Agregar");
            System.out.println("2- Rentar");
            System.out.println("3- SubMenu");
            System.out.println("4- Ingresar Actores");
            System.out.println("5- Cambiar Genero");
            System.out.println("6- Salir");
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
                case 4:
                    System.out.println("Codigo: ");
                    cod = lea.nextInt();
                    actores(cod);
                    break;
                case 5:
                    System.out.println("Codigo: ");
                    cod = lea.nextInt();
                    cambiarGenero(cod);
                    break;
                    
            }
            
        }while(op!=6);
    }

    private static void addItem(String tipo) {
        int codigo = lea.nextInt();
        
        if( buscar(codigo) == null ){
            String n = lea.next();

            if( tipo.equalsIgnoreCase("MOVIE")){
                double precio = lea.nextDouble();
                items.add( new Movie(codigo, n, precio) );
            }
            else if( tipo.equalsIgnoreCase("PS3")){
                items.add( new PS3Game(codigo, n) );
            }
        }
        else{
            System.out.println("CODIGO YA EXISTE");
        }
    }

    private static void rentarItem(int cod) {
        RentItem ri = buscar(cod);
        if( ri != null ){
            int dias = lea.nextInt();
            double result = ri.pagoRenta(dias);
            System.out.println(result);
        }
    }

    private static void subMenuItem(int cod) {
        RentItem ri = buscar(cod);
        if( ri != null ){
            System.out.println(ri.subMenu());
            System.out.println("Elija opcion: ");
            int op = lea.nextInt();
            ri.ejecutarOpcion(op);
        }
    }
    
    private static RentItem buscar(int cod){
        for(RentItem ri : items){
            if(ri.codigo == cod)
                return ri;
        }
        return null;
    }

    private static void actores(int cod) {
        RentItem ri = buscar(cod);
        
        if(ri instanceof Movie){
            //downcasting indirecto
            Movie movie = (Movie)ri;
            movie.ingresarActores();
        }
        else
            System.out.println("No Existe o Item No es Movie");
    }

    private static void cambiarGenero(int cod) {
        RentItem ri = buscar(cod);
        
        if(ri instanceof PS3Game){
            //downcasting directo
            ((PS3Game)ri).setGenero(lea.next());
        }
        else
            System.out.println("No Existe o Item NO es PS3 Game");
    }
}
