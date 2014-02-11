/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente2014
 */
public class Recursiones {
    public static void main(String[] args) {
        
        int x=843, res;
        
        do{
            res = x % 10;
            System.out.println("x: " + res);
            x /= 10;
        }while(res>0);
                
        int sum = suma(123456789);
        System.out.println("Suma: " + sum);
        alrevez(1500);
    }

    private static int suma(int x) {
        if( x > 0){
            int res = x % 10;
            return res + suma(x/10);
        }
        return 0;
    }
    
    private static void alrevez(int x) {
        if( x > 0){
            int res = x % 10;
            System.out.print(res);
            alrevez(x/10);
        }
    }
    
   
}