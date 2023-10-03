/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.twitter.Services;

import com.mycompany.twitter.dominio.Usuario;

/**
 *
 * @author PC
 */
public interface iCommon {
    
    public void dibujoMenuInicio();
    
    public void dibujoCrearUsuarioNombre();

    public void dibujoCrearUsuarioContrasnia();

    public void dibujoCrearUsuarioCorreo();

    public void dibujoCrearUsuarioUbicacion();
    
    public void imprimirEspacios();
    
    public void continuar();

    public void dibujoMenuUsuario();
    
    public void dibujoMenuUsuario2(Usuario usuario);

    public void dibujoSubMenu();

    public void dibujoMenuCRUD();

    public void dibujoMenuBuscar();

    public void dibujoFinal();
    
}
