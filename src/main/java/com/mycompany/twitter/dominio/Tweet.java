/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.dominio;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Tweet {
    
    private int id;
    private String texto;
    private Date fechaPublicacion;
    private int usuario_id;

    public Tweet() {
    }
    
    public Tweet(String texto, Date fechaPublicacion, int usuario_id) {
        this.texto = texto;
        this.fechaPublicacion = fechaPublicacion;
        this.usuario_id = usuario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tweet{");
        sb.append("id=").append(id);
        sb.append(", texto=").append(texto);
        sb.append(", fechaPublicacion=").append(fechaPublicacion);
        sb.append(", usuario_id=").append(usuario_id);
        sb.append('}');
        return sb.toString();
    }
    
    
    

}
