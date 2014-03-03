/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg4;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Bill {
    private Date fecha;
    private double monto;
    private boolean pagado;

    public Bill(Date fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
        pagado = false;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isPagado() {
        return pagado;
    }
    
    public void payThisBill(){
        pagado = true;
    }
    
}
