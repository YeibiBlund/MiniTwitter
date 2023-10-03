/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.datos;

import static com.mycompany.twitter.datos.Conexion.close;
import static com.mycompany.twitter.datos.Conexion.getConnection;
import com.mycompany.twitter.dominio.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class UsuarioDAO implements iUsuarioDAO {

    // 1. Definir la consulta que quiero realizar
    private static final String SQL_INICIAR_SESION = "SELECT * FROM usuario WHERE correo_electronico = ? AND contrasena = ?";

    private static final String SQL_BUSCAR_POR_NOMBRE = "SELECT COUNT(*) AS count FROM usuario WHERE nombre_usuario = ?";
    
    private static final String SQL_BUSCAR_POR_CORREO = "SELECT COUNT(*) AS count FROM usuario WHERE correo_electronico = ?";
    
    private static final String SQL_MODIFICAR_USUARIO = "UPDATE usuario SET biografia = ?, sitio_web = ?, fecha_nacimiento = ? WHERE id = ?";

    private static final String SQL_INSERT = "INSERT INTO usuario (nombre_usuario, contrasena, correo_electronico, ubicacion)"
            + "VALUES (?,?,?,?)";

    private static final String SQL_MOSTRAR_USUARIOS_SEGUIDOS = "SELECT u.nombre_usuario, u.num_seguidores "
            + "FROM usuario u "
            + "INNER JOIN seguir s ON u.id = s.seguido_id "
            + "WHERE s.seguidor_id = ? "
            + "ORDER BY u.num_seguidores DESC";

    @Override
    public int insertar(Usuario usuario) {

        //Declaro las variables que necesito para insertar una persona
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            // Establecemos la conexión
            conn = getConnection();
            // Praparar la instruccion con la sentencia SQL que quiero ejecutar
            stmt = conn.prepareStatement(SQL_INSERT);
            // Ahora tenemos que pasar los valores a los interrogantes(?)
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getCorreo_electronico());
            stmt.setString(4, usuario.getUbicacion());

            // Ejecutamos la consulta
            registro = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    
    public Usuario iniciarSesion(String correo_electronico, String contrasena) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INICIAR_SESION);
            ps.setString(1, correo_electronico);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre_usuario = rs.getString("nombre_usuario");
                String contrasenia = rs.getString("contrasena");
                String correo = rs.getString("correo_electronico");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                String biografia = rs.getString("biografia");
                String sitio_web = rs.getString("sitio_web");
                String ubicacion = rs.getString("ubicacion");
                int num_seguidores = rs.getInt("num_seguidores");
                Date fecha_creacion = rs.getDate("fecha_creacion");
                
                
                usuario = new Usuario(id, nombre_usuario, contrasena, correo_electronico, fecha_nacimiento, biografia, sitio_web, ubicacion, num_seguidores, fecha_creacion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    @Override
    public void mostrarUsuariosSeguidos(int seguidor_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_MOSTRAR_USUARIOS_SEGUIDOS);
            ps.setInt(1, seguidor_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombre_usuario = rs.getString("nombre_usuario");
                int num_seguidores = rs.getInt("num_seguidores");
                System.out.println(" ====================================================");
                System.out.println("| USUARIO: @" + nombre_usuario);
                System.out.println("| SEGUIDORES: " + num_seguidores);
                System.out.println(" ====================================================");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Usuario comprobarDatos(String correoElectronico) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Usuario usuario = null;

    try {
        conn = getConnection();
        ps = conn.prepareStatement("SELECT * FROM usuario WHERE correo_electronico = ?");
        ps.setString(1, correoElectronico);
        rs = ps.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombre_usuario(rs.getString("nombre_usuario"));
            usuario.setContrasena(rs.getString("contrasena"));
            usuario.setCorreo_electronico(rs.getString("correo_electronico"));
            usuario.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
            usuario.setBiografia(rs.getString("biografia"));
            usuario.setSitio_web(rs.getString("sitio_web"));
            usuario.setUbicacion(rs.getString("ubicacion"));
            usuario.setNum_seguidores(rs.getInt("num_seguidores"));
            usuario.setFecha_creacion(rs.getDate("fecha_creacion"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            close(rs);
            close(ps);
            close(conn);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    return usuario;
}

    public int comprobarDatos1(String nombre, int opcion) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int coincidencias = 0;

        try {
            conn = getConnection();
            if (opcion == 1) {
                ps = conn.prepareStatement(SQL_BUSCAR_POR_NOMBRE);
            } else {
                ps = conn.prepareStatement(SQL_BUSCAR_POR_CORREO);
            }
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                coincidencias = rs.getInt("count");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return coincidencias;
    }
    
    public Usuario comprobarInicioSesion(String nombre, int opcion) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = getConnection();
            if (opcion == 1) {
                ps = conn.prepareStatement(SQL_BUSCAR_POR_NOMBRE);
            } else {
                ps = conn.prepareStatement(SQL_BUSCAR_POR_CORREO);
            }
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre_usuario = rs.getString("nombre_usuario");
                String contrasena = rs.getString("contrasena");
                String correo_electronico = rs.getString("correo_electronico");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                String biografia = rs.getString("biografia");
                String sitio_web = rs.getString("sitio_web");
                String ubicacion = rs.getString("ubicacion");
                int num_seguidores = rs.getInt("num_seguidores");
                Date fecha_creacion = rs.getDate("fecha_creacion");
                usuario = new Usuario(id, nombre_usuario, contrasena, correo_electronico, fecha_nacimiento, biografia, sitio_web, ubicacion, num_seguidores, fecha_creacion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    public void modificarNombreUsuario(int id, String nuevo_nombre) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement("UPDATE usuario SET nombre_usuario = ? WHERE id = ?");
            ps.setString(1, nuevo_nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void modificarUsuario(int id, String nueva_biografia, String nuevo_sitio_web, Date nueva_fecha_nacimiento) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = getConnection();
        ps = conn.prepareStatement(SQL_MODIFICAR_USUARIO);
        ps.setString(1, nueva_biografia);
        ps.setString(2, nuevo_sitio_web);
        ps.setDate(3, nueva_fecha_nacimiento);
        ps.setInt(4, id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            close(ps);
            close(conn);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    public void modificarContrasenaUsuario(int id, String nueva_contrasena) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement("UPDATE usuario SET contrasena = ? WHERE id = ?");
            ps.setString(1, nueva_contrasena);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificarCorreoElectronicoUsuario(int id, String nuevo_correo) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement("UPDATE usuario SET correo_electronico = ? WHERE id = ?");
            ps.setString(1, nuevo_correo);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(ps);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
