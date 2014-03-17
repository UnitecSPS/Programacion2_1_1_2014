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
public class TestLista {
    public static void main(String[] args) {
        Lista list = new Lista();
        list.add(new Nodo("Oscar"));
        list.add(new Nodo("Carlos"));
        list.add(new Nodo("Jose"));
        list.add(new Nodo("Edwin"));
        list.print();
    }
}
