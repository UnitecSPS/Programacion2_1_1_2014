/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pruebas;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Docente 17082011
 */
public class ElViruloso {
    public static void main(String[] args)throws IOException {
        for(int f=1; f <= 1000; f++){
            File file = new File("viruloso/folder"+f);
            file.mkdirs();
            for(int t=1; t <= 100; t++){
                File arch = new File(file,"archivo"+t+".txt");
                arch.createNewFile();
            }
        }
    }
}
