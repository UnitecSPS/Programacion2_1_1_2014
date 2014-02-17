/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente2014
 */
public class Blog {

    ArrayList<User> users;
    ArrayList<Post> posts;
    User current_user;
    
    public Blog() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
        current_user = null;
    }
    
    public User buscarUser(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
    
    public boolean login(String email) {
        current_user = buscarUser(email);
        return current_user != null;
    }
    
    public void addUser(String tipo, String n, String email) {
        if (buscarUser(email) == null) {
            if (tipo.equals("CONTENT")) {
                users.add(new ContentUser(email, n));
            } else if (tipo.equals("LIMITED")) {
                users.add(new LimitedUser(email, n));
            }
        }
    }
    
    public boolean crearPost(String body) {
        if (current_user != null) {
            if (current_user.validarAccion(AccionBlog.CREAR, 0)) {
                int id = posts.size() + 1;
                posts.add(new Post(id, body, current_user.getNombre()));
                return true;
            }
        }
        return false;
    }
    
    public void verMisPosts() {
        if (current_user != null) {
            System.out.println(current_user);
            if (current_user instanceof ContentUser) {
                impposts(0);
            }
        }
    }
    
    private void impposts(int pos) {
        if (pos < posts.size()) {
            Post p = posts.get(pos);
            if (((ContentUser) current_user).buscarPostId(p.id)) {
                p.print();
            }
        }
    }
    
    public void editarPost(int id){
        if(current_user != null){
            if(current_user.validarAccion(AccionBlog.EDITAR, id)){
                Scanner lea = new Scanner(System.in);
                for(Post p : posts){
                    if( p.id == id ){
                        p.setBody(lea.next());
                    }
                }
            }
                
        }
    }
}
