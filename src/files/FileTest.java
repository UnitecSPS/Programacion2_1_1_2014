/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileTest {
    public static void main(String[] args) {
        int op=0;
        MiFile mf = new MiFile();
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Seleccionar archivo");
            System.out.println("2- Info de file");
            System.out.println("3- Crear Archivo");
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        System.out.println("Ingrese path: ");
                        mf.setFile(lea.next());
                        break;
                    case 2:
                        mf.info();
                        break;
                    case 3:
                        if( mf.crearArchivo() )
                            System.out.println("Se creo bien");
                        else
                            System.out.println("No se creo bien");
                }
            }
            catch(Exception e){
                System.out.println("ERROR: " + e);
            }
        }while(op != 7);
    }
}
