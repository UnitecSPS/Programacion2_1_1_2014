/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileWriterTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        do{
            System.out.println("Direccion archivo: ");
            String path = lea.next();
            
            FileWriter fw;
            
            try{
                System.out.println("Append? (s/n): ");
                char app = lea.next().charAt(0);
                
                fw = new FileWriter(path,app == 's');
                
                do{
                    String texto = lea.nextLine();
                    if( texto.equals("%&/"))
                        break;
                    else
                        fw.write(texto+"\n");
                }while(true);
                
                fw.close();
                
            }catch(IOException e){
                System.out.println(e);
            }
            
        }while(true);
    }
}
