/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg2;

/**
 *
 * @author Docente2014
 */
public class RentItem {
    protected int codigo;
    protected String nombre;
    protected double precio;

    public RentItem(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "RentItem{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    public double pagoRenta(int dias){
        return 0;
    }
    
    public String subMenu(){
        return "1-Imprimir";
    }
    
    public void ejecutarOpcion(int op){
        switch(op){
            case 1:
                System.out.println(this);
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }
}
