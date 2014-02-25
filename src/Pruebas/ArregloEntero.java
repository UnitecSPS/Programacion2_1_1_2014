/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pruebas;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class ArregloEntero implements ArrayActions {
    ArrayList<Integer> nums = new ArrayList<>();

    @Override
    public int suma() {
        int sum=0;
        for(int x : nums)
            sum += x;
        return sum;
    }

    @Override
    public boolean isValid(Object n) {
        if( n instanceof Integer )
            return true;
        return false;
    }

    @Override
    public void print() {
        for(int x : nums)
            System.out.println(x);
    }
    
    
}
