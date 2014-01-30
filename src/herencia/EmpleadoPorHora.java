/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

/**
 *
 * @author Docente2014
 */
public class EmpleadoPorHora extends Empleado {
    private int horast;
    private int pagoxh;

    public EmpleadoPorHora(int c, String n) {
        super(c, n);
        horast = 1;
        pagoxh = 150;
    }

    public int getHorast() {
        return horast;
    }

    public void setHorast(int horast) {
        this.horast = horast;
    }

    public int getPagoxh() {
        return pagoxh;
    }

    public void setPagoxh(int pagoxh) {
        this.pagoxh = pagoxh;
    }
    
    @Override
    public void quienSoy(){
        System.out.println("I AM EM PER HOUR, YOUR DAUGHTER");
    }

    @Override
    public double calcular() {
        return horast * pagoxh;
    }

    @Override
    public String toString() {
        return super.toString() + " horast=" + horast + ", pagoxh=" + pagoxh + '}';
    }
    
    
}
