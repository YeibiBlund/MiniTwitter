/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.datos;

import static com.mycompany.twitter.datos.Conexion.close;
import static com.mycompany.twitter.datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class LikeDAO implements iLikeDAO {
    
    private static final String SQL_DAR_LIKE = "INSERT INTO likes (usuario_id, tweet_id, fecha_like) VALUES (?, ?, NOW())";
    
    @Override
    public void darLike(int usuario_id, int tweet_id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_DAR_LIKE);
            ps.setInt(1, usuario_id);
            ps.setInt(2, tweet_id);
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
