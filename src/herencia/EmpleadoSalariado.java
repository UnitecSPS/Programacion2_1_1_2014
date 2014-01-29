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
public class EmpleadoSalariado extends Empleado{
    public double salario;

    public EmpleadoSalariado(int cod, double salario) {
        super(cod, "Patito");
        this.salario = salario;
    }
    
    @Override
    public void quienSoy(){
        System.out.println("I AM EMP SAL, YOUR SON");
    }
    
    @Override
    public double calcular(){
        return salario - (salario*0.035);
    }
}
