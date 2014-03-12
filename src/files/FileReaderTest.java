/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileReaderTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        do{
            System.out.println("Direccion archivo: ");
            String path = lea.next();
            
            FileReader fr;
            
            try{
                File fileToRead = new File(path);
                fr = new FileReader(fileToRead);
                char buffer[] = new char[(int)fileToRead.length()];
                int bytesLeidos = fr.read(buffer);
                
                System.out.println("CONTENIDO:\n--------------");
                System.out.println(buffer);
                System.out.println("\nBytes leidos: " + bytesLeidos + 
                        " size del file: " + fileToRead.length());
                
                bytesLeidos = fr.read(buffer);
                System.out.println("leido la 2 vez: " + bytesLeidos);
                
                //--------------------------------------------
                //COMO LEER CON EL SCANNER
                System.out.println("\nAHORA CON SCANNER\n--------------");
                fr = new FileReader(fileToRead);
                Scanner reader = new Scanner(fr);
                reader.useDelimiter(System.getProperty("line.separator"));
                
                while(reader.hasNext()){
                    System.out.print(reader.next()+" ");
                }
                
            }catch(IOException e){
                System.out.println(e);
            }
            
        }while(true);
    }
}
