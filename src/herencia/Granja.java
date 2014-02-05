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
public class Granja {
    public static void main(String[] args) {
        Animal a = Animal.getInstance("perro");
        Animal b = Animal.getInstance("gato");
        
        a.hablar();
        Perro p = (Perro)a;
        p.esconderHueso();
        
        b.hablar();
        
        ///-----------funciones On Demand
        Animal c = new Animal("Tazmania",2){
            @Override
            public void hablar(){
                test();
                System.out.println("Gerr Grwr3e 543%$%");
            }
            
            public void test(){
                System.out.println("Huy");
            }
        };
        
        c.hablar();
        
        Animal d = new Animal("Fonzy",2) {

            @Override
            public void hablar() {
                System.out.println("Ihhh Ahhhh Ohhhh");
            }
        };
        
        d.hablar();
    }
}
