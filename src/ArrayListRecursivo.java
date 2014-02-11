
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente2014
 */
public class ArrayListRecursivo {
    static ArrayList<String> cadenas;
    
    public static void main(String[] args) {
        cadenas = new ArrayList<>();
        cadenas.add("Andres");
        cadenas.add("Carlos");
        cadenas.add("Leonel");
        
        alrevez(cadenas.size()-1);
        
        if( buscar("Carlos", 0))
            System.out.println("ENCONTRADO");
        
        if( !buscar("Alejandro", 0) )
            System.out.println("NO ENCONTRADO");
        
    }

    private static void alrevez(int pos) {
        if(pos >= 0){
            int longi = cadenas.get(pos).length() - 1;
            cadenaAlRevez(cadenas.get(pos), longi);
            System.out.println("");
            alrevez(pos-1);
        }
    }

    private static void cadenaAlRevez(String cadena,int pos) {
        if(pos >= 0){
            System.out.print(cadena.charAt(pos));
            cadenaAlRevez(cadena, pos-1);
        }
    }
    
    private static boolean buscar(String busc, int pos){
        if(pos < cadenas.size()){
            if( busc.equals(cadenas.get(pos)))
                return true;
            return buscar(busc,pos+1);
        }
        return false;
    }
}
