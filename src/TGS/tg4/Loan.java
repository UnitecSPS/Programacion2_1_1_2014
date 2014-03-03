/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg4;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Loan implements Pagable, Serializable{
    
    private String nombre;
    private double montoTotal;
    private int cantidad;
    private Date fechaCreacion;
    private Bill cuotas[];

    public Loan(String nombre, double montoTotal, int cantidad) throws LoanInvalidException {
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.cantidad = cantidad;
        
        if(montoTotal < 5000 || cantidad < 5)
            throw new LoanInvalidException(montoTotal);
        
        fechaCreacion = new Date();
        cuotas = new Bill[cantidad];
        initBills();
    }
    
    private void initBills() {
        Calendar c = Calendar.getInstance();
        
        for(int m=0; m < cantidad; m++){
            double montoCuota = montoTotal / cantidad;
            c.add(Calendar.MONTH, 1);
            cuotas[m] = new Bill(c.getTime(), montoCuota);
        }
    }
    
    public void print(){
        System.out.println(nombre);
        System.out.println(montoTotal);
        System.out.println(fechaCreacion);
        System.out.println(cantidad);
        
        Date now = new Date();
        for(int b=0; b < cantidad; b++){
            System.out.println("No de Bill " + (b+1));
            
            if(cuotas[b].isPagado())
                System.out.println(cuotas[b].getMonto()+" PAGADO EN ");
            else if(now.before(cuotas[b].getFecha()))
                System.out.println(cuotas[b].getMonto()+" Aun pendiente de pago en ");
            else
                System.out.println(cuotas[b].getMonto()+" Ya se tuvo que haber pagado en ");
            
            
            System.out.println(cuotas[b].getFecha());
        }
    }
    
    @Override
    public void pay() {
        int no = (int)noDeBill();
        try{
            if( cuotas[no].isPagado() )
                throw new AlreadyPaidException();
            cuotas[no].payThisBill();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Posicion mala");
        }
    }

    @Override
    public double balanceDue() {
        double suma = 0;
        for(Bill b : cuotas){
            if(b.isPagado())
                suma += b.getMonto();
        }
        return montoTotal - suma;
    }

    private double noDeBill() {
        Date now = new Date();
        long diff = now.getTime() - fechaCreacion.getTime();
        double s = diff/1000;
        double min = s/60;
        double ho = min/60;
        double d = ho/24;
        double m = d/30;
        return m;
    }

    
    
}
