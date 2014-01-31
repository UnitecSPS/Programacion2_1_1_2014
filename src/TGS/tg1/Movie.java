/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg1;

import java.util.Scanner;

/**
 *
 * @author Docente2014
 */
public class Movie extends RentItem {
    private String estado;

    public Movie(int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        estado = "ESTRENO";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + " estado=" + 
                estado + " -MOVIE";
    }
    
    @Override
    public double pagoRenta(int dias) {
        double tot = this.precio;
        
        if( estado.equals("ESTRENO")){
            if(dias > 2)
                tot += (dias-2) * 50;
        }
        else{
            if(dias > 5)
                tot += (dias-5) * 30;
        }
        return tot;
    }
    
    @Override
    public String subMenu() {
        return super.subMenu() + "\n2-Cambiar Estado.";
    }
   
    @Override
    public void ejecutarOpcion(int op) {
        Scanner lea = new Scanner(System.in);
        
        switch(op){
            case 1:
                System.out.println(this);
                break;
            case 2:
                System.out.println("Ingrese estado: ");
                setEstado(lea.next());
                break;
            case 3:
                System.out.println("OPCION NO VALIDA");
        }
    }
   
}
