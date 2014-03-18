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
        if(inicio != null){
            if(inicio.nombre.equals(nombre)){
                inicio = inicio.siguiente;
                return true;
            }
            else{
                Nodo tmp = inicio;
                while(tmp.siguiente != null){
                    if(tmp.siguiente.nombre.equals(nombre)){
                        tmp.siguiente = tmp.siguiente.siguiente;
                        return true;
                    }
                    else
                        tmp = tmp.siguiente;
                }
            }
        }
        return false;
    }
    
    public void addInTheMiddle(Nodo obj, String nombre){
        Nodo tmp = inicio;
        while(tmp != null){
            if(tmp.nombre.equals(nombre)){
                obj.siguiente = tmp.siguiente;
                tmp.siguiente = obj;
                break;
            }
            else
                tmp = tmp.siguiente;
        }
    }
    
    public boolean contains(String nombre){
       Nodo tmp = inicio;
        while(tmp != null){
            if(tmp.nombre.equals(nombre)){
                return true;
            }
            else
                tmp = tmp.siguiente;
        }
        return false;
    }
    
    public void clear(){
        System.out.println("Borrando lista");
        inicio = null;
    }
}
