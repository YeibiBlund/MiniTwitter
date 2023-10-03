/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.twitter.datos;

/**
 *
 * @author PC
 */
public interface iSeguirDAO {
    
    public void seguir(int seguidor_id, int seguido_id);
    
    public boolean comprobarSeguido(int seguidor_id, int seguido_id);
    
    public void actualizarNumeroSeguidores();
    
}
