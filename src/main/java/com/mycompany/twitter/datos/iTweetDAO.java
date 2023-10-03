/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.twitter.datos;

/**
 *
 * @author PC
 */
public interface iTweetDAO {
    
    public void mostrarTweetsSeguidos(int seguidor_id);
    
    public void publicarTweet(int usuario_id, String texto);
    
    public void explorar(int id_usuario);
    
    public void verTweetsEscritos(int usuario_id);
    
}
