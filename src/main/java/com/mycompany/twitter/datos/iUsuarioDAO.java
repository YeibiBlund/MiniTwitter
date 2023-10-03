/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.twitter.datos;

import com.mycompany.twitter.dominio.Usuario;
import java.sql.Date;

/**
 *
 * @author PC
 */
public interface iUsuarioDAO {

    public int insertar(Usuario usuario);

    public void modificarNombreUsuario(int id, String nuevo_nombre);

    public int comprobarDatos1(String nombre, int opcion);
    
    public Usuario comprobarInicioSesion(String nombre, int opcion);

    public void modificarContrasenaUsuario(int id, String nueva_contrasena);

    public void modificarCorreoElectronicoUsuario(int id, String nuevo_correo);
    
    public Usuario iniciarSesion(String correo_electronico, String contrasena);
    
    public void modificarUsuario(int id, String nueva_biografia, String nuevo_sitio_web, Date nueva_fecha_nacimiento);

    public void mostrarUsuariosSeguidos(int seguidor_id);

    public Usuario comprobarDatos(String correo_electronico);

}
