/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente2014
 */
public class MasPruebas {
    public static void main(String[] args) {
        ArrayList<Empleado> emps = new ArrayList<>();
        
        //salario
        emps.add( new EmpleadoSalariado(1, 5000) );
        //hora
        EmpleadoPorHora eph = new EmpleadoPorHora(2,"hola");
        emps.add( eph );
        
        for(Empleado e : emps){
            System.out.println(e);
        }
        
        EmpTest.main(args);
    }
}
