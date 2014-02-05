/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.Calendar;

/**
 *
 * @author Docente2014
 */
public class EmpleadoTemporal extends EmpleadoSalariado {
    private Calendar fechaFin;
    
    public EmpleadoTemporal(int c) {
        super(c, 5000);
    }
    
}
