/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

import java.util.Date;

/**
 *
 * @author Docente2014
 */
public abstract class User {
    protected String nombre;
    protected String email;
    protected Date usuarioDesde;

    public User(String email, String nombre) {
        this.nombre = nombre;
        this.email = email;
        usuarioDesde = new Date();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Date getUsuarioDesde() {
        return usuarioDesde;
    }
    
    @Override
    public String toString(){
        return email + "-" + nombre;
    }
    
    public abstract boolean validarAccion(AccionBlog accion,int idPost);
}
