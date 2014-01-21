
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente2014
 */
public class ArreglosDinamicos {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Carlos");
        arr.add("Patito");
        arr.add("Estalin");
        arr.add("Jorge");
        System.out.println("Long: " + arr.size());
        System.out.println(arr.get(0));
        
        if(arr.contains("Carlos"))
            System.out.println("Esta guardado Carlos");
        
        arr.remove(0);
        System.out.println(arr.get(0));
        
        for(String val : arr)
            System.out.println("-" + val);
    }
}
