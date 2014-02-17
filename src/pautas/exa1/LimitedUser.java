/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

/**
 *
 * @author Docente2014
 */
public class LimitedUser extends User {

    public LimitedUser(String email, String nombre) {
        super(email, nombre);
    }
    
    @Override
    public String toString(){
        return super.toString() + "-LimitedUser";
    }
    
    @Override
    public boolean validarAccion(AccionBlog accion, int idPost) {
        return accion == AccionBlog.IMPRIMIR;
    }
    
}
