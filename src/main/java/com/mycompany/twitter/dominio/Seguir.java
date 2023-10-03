/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.dominio;

/**
 *
 * @author PC
 */
public class Seguir {
    
    private int seguidor_id;
    private int seguido_id;

    public Seguir() {
    }

    public Seguir(int seguidor_id, int seguido_id) {
        this.seguidor_id = seguidor_id;
        this.seguido_id = seguido_id;
    }

    public int getSeguidor_id() {
        return seguidor_id;
    }

    public void setSeguidor_id(int seguidor_id) {
        this.seguidor_id = seguidor_id;
    }

    public int getSeguido_id() {
        return seguido_id;
    }

    public void setSeguido_id(int seguido_id) {
        this.seguido_id = seguido_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguir{");
        sb.append("seguidor_id=").append(seguidor_id);
        sb.append(", seguido_id=").append(seguido_id);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
