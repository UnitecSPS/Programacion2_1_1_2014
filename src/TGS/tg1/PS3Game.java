/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg1;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Docente2014
 */
public class PS3Game extends RentItem {
    private Calendar fechapublic;

    public PS3Game(int c, String n) {
        super(c,n, 30);
        fechapublic = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return super.toString() + " fechapublic=" + 
                fechapublic.getTime() + " - PS3 GAME";
    }

    @Override
    public double pagoRenta(int dias) {
        return dias * precio;
    }

    @Override
    public String subMenu() {
        return super.subMenu() + 
                "\n2-Cambiar Fecha.";
    }
    
    public void setFechaPublic(int y, int m, int d){
        fechapublic.set(y, m-1, d);
    }

    @Override
    public void ejecutarOpcion(int op) {
        Scanner lea = new Scanner(System.in);
        
        switch(op){
            case 1:
                System.out.println(this);
                break;
            case 2:
                System.out.println("Ingrese Anio: ");
                int y = lea.nextInt();
                System.out.println("Ingrese Mes: ");
                int m = lea.nextInt();
                System.out.println("Ingrese dia: ");
                int d = lea.nextInt();
                setFechaPublic(y, m, d);
                break;
            case 3:
                System.out.println("OPCION NO VALIDA");
        }
    }
    
    
}
