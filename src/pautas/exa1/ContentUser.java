/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

import java.util.ArrayList;

/**
 *
 * @author Docente2014
 */
public class ContentUser extends User {
    
    ArrayList<Integer> ids;

    public ContentUser(String email, String nombre) {
        super(email, nombre);
        ids = new ArrayList<>();
    }

    @Override
    public boolean validarAccion(AccionBlog accion, int idPost) {
        if(accion == AccionBlog.EDITAR || accion == AccionBlog.ELIMINAR){
            return buscarPostId(idPost);
        }
        return true;
    }
    
    public void addPostId(int id){
        if(!ids.contains(id))
            ids.add(id);
    }
    
    @Override
    public String toString(){
        return super.toString() + "-ContentUser";
    }

    /**
     * 
     * @param idPost
     * @return 
     */
    public boolean buscarPostId(int idPost){
        
        return buscarPostId(idPost,0);
    }

    /**
     * Esta funcion retorna si se encuentra el id en el arreglo de
     * posts ids
     * @param idPost Es el id del post
     * @param pos es la posicion de la recursion
     * @return <code>true</code> Si se encuentra
     */
    private boolean buscarPostId(int idPost, int pos) {
        if( pos < ids.size() ){
            if( idPost == ids.get(pos) )
                return true;
            return buscarPostId(idPost, pos + 1);
        }
        return false;
    }
    
}
