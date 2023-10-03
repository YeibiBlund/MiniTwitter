/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.datos;

import static com.mycompany.twitter.datos.Conexion.close;
import static com.mycompany.twitter.datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TweetDAO implements iTweetDAO {

    private static final String SQL_MOSTRAR_TWEETS_SEGUIDOS = "SELECT usuario.nombre_usuario, tweet.* "
            + "FROM tweet "
            + "JOIN usuario ON tweet.usuario_id = usuario.id "
            + "WHERE tweet.usuario_id IN "
            + "(SELECT seguido_id FROM seguir WHERE seguidor_id = ?)";

    private static final String SQL_PUBLICAR_TWEET = "INSERT INTO tweet (texto, fecha_publicacion, usuario_id) VALUES (?, CURRENT_TIMESTAMP, ?)";

    private static final String SQL_EXPLORAR = "SELECT tweet.*, usuario.nombre_usuario, \n"
        + "(SELECT COUNT(*) FROM likes WHERE likes.tweet_id = tweet.id) AS num_likes \n"
        + "FROM tweet \n"
        + "INNER JOIN usuario ON tweet.usuario_id = usuario.id \n"
        + "WHERE usuario.id != ? \n" // Cambiar el valor 1 por el parámetro
        + "ORDER BY fecha_publicacion ASC";

    private static final String SQL_VER_TWEETS_ESCRITOS = "SELECT * FROM tweet WHERE usuario_id = ? ORDER BY fecha_publicacion ASC";

    @Override
    public void mostrarTweetsSeguidos(int seguidor_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_MOSTRAR_TWEETS_SEGUIDOS);
            ps.setInt(1, seguidor_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String texto = rs.getString("texto");
                Timestamp fecha_publicacion = rs.getTimestamp("fecha_publicacion");
                int usuario_id = rs.getInt("usuario_id");
                String nombre_usuario = rs.getString("nombre_usuario");

                // Imprimir el tweet
                System.out.println("\t\t\t\t ======================================================");
                System.out.println("\t\t\t\t| USUARIO: @" + nombre_usuario);
                System.out.println("\t\t\t\t| " + texto);
                System.out.println("\t\t\t\t| FECHA PUBLICACION: " + fecha_publicacion);
                System.out.println("\t\t\t\t| USUARIO ID: " + usuario_id);
                System.out.println("\t\t\t\t| ID TWEET: " + id);
                System.out.println("\t\t\t\t ======================================================");
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

    @Override
    public void publicarTweet(int usuario_id, String texto) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_PUBLICAR_TWEET);
            ps.setString(1, texto);
            ps.setInt(2, usuario_id);
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

    @Override
    public void explorar(int id_usuario) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = getConnection();
        ps = conn.prepareStatement(SQL_EXPLORAR);
        ps.setInt(1, id_usuario); // Establecer el valor del parámetro
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String texto = rs.getString("texto");
            Timestamp fecha_publicacion = rs.getTimestamp("fecha_publicacion");
            String nombre_usuario = rs.getString("nombre_usuario");
            int id_autor = rs.getInt("usuario_id");
            int num_likes = rs.getInt("num_likes");

            // Imprimir el tweet
            System.out.println("\t\t\t\t =============================================================");
            System.out.println("\t\t\t\t| PUBLICADO POR: @" + nombre_usuario + " (ID: " + id_autor + ")");
            System.out.println("\t\t\t\t| " + texto);
            System.out.println("\t\t\t\t| FECHA PUBLICACION: " + fecha_publicacion);
            System.out.println("\t\t\t\t| ID TWEET: " + id);
            System.out.println("\t\t\t\t| NUMERO DE LIKES: " + num_likes);
            System.out.println("\t\t\t\t =============================================================");
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

    @Override
    public void verTweetsEscritos(int usuario_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_VER_TWEETS_ESCRITOS);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String texto = rs.getString("texto");
                Timestamp fecha_publicacion = rs.getTimestamp("fecha_publicacion");

                // Imprimir el tweet
                System.out.println("\t\t\t\t =============================================================");
                System.out.println("\t\t\t\t| ID TWEET: " + id);
                System.out.println("\t\t\t\t| " + texto);
                System.out.println("\t\t\t\t| FECHA PUBLICACION: " + fecha_publicacion);
                System.out.println("\t\t\t\t =============================================================");
//                System.out.println("Usuario ID: " + usuario_id);
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

}
