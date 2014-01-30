/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.Date;

/**
 *
 * @author Docente2014
 */
public class Empleado {
    protected int codigo;
    protected String nombre;
    protected Date fechanac;
    protected String puesto;

    public Empleado(int c, String n){
        codigo = c;
        nombre = n;
        fechanac = new Date();
    }
    
    public Empleado(int c){
        this(c,"fulanito");
    }
     
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public void quienSoy(){
        System.out.println("IM YOUR FATHER");
    }
    
    public double calcular(){
        return 0;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nombre=" + nombre + ", fechanac=" + fechanac + ", puesto=" + puesto;
    }
    
    
}
