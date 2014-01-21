
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente2014
 */
public class Fechas {
    public static void main(String[] args) {
        Date antes = new Date(12121);
        Date ahora = new Date();
        
        long diff = ahora.getTime() - antes.getTime();
        long ms = 1000;
        long s = 60;
        long m = 60;
        long h = 24;
        long a = 365;
        long div = ms*s*m*h*a;
        System.out.println("Formula: " + diff + "/" + div);
        double tiempo = diff/div;
        System.out.println("Ha pasado: " + tiempo);
        
        System.out.println(antes);
        
        if(ahora.getTime() > antes.getTime())
            System.out.println("Ahora paso despues que antes");
        
        if(ahora.after(antes))
          System.out.println("Ahora paso despues que antes");
          
        
        Calendar c = Calendar.getInstance();
        c.set(1982, Calendar.AUGUST, 10);
        System.out.println(c.getTime());
        int y = c.get(Calendar.DAY_OF_YEAR);
        System.out.println(y);
        c.add(Calendar.YEAR, 10);
        System.out.println(c.getTime());
        
        
    }
}
