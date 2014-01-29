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
public class EmpTest {
    public static void main(String[] args) {
       //UP CASTING
       Empleado em = new EmpleadoSalariado(1, 5000);
       em.quienSoy();
       Empleado em2 = new EmpleadoPorHora(2, "Andres");
       em2.quienSoy();
       Empleado em3 = new Empleado(3);
       em3.quienSoy();
       
       //
        System.out.println("PF de Sal: " + 
                em.calcular());
        System.out.println("PF de x Hora: " + 
                em2.calcular());
        System.out.println("PF de Emp: " + 
                em3.calcular());
    }
}
