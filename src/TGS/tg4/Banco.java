/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TGS.tg4;


/**
 *
 * @author Docente 17082011
 */
public class Banco {
    public static void main(String[] args) {
        try {
            Loan l = new Loan("carlos", 200000, 24);
            l.print();
        } catch (LoanInvalidException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
