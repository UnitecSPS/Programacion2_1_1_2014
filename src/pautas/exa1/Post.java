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
public class Post {
    public int id;
    public String body;
    public String autor;
    public Date creadoEn;
    
    public Post(int c, String b, String a){
        id = c;
        body = b;
        autor = a;
        creadoEn = new Date();
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getAutor() {
        return autor;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public void print(){
        System.out.println("Autor: " + autor);
        System.out.println(body);
        System.out.println("Creado en: " + creadoEn);
    }
}
