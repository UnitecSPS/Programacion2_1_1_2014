/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listas;

/**
 *
 * @author Docente 17082011
 */
public class Lista {
    private Nodo inicio = null;
    
    public void add(Nodo obj){
        if( inicio == null ){
            inicio = obj;
        }
        else{
            Nodo tmp = inicio;
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            tmp.siguiente = obj;
        }
    }
    
    public void print(){
        Nodo tmp = inicio;
        while(tmp != null){
            System.out.println("-"+tmp.nombre);
            tmp = tmp.siguiente;
        }
    }
    
    public boolean remove(String nombre){
        return false;
    }
}
