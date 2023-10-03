package com.mycompany.twitter.datos;

import static com.mycompany.twitter.datos.Conexion.close;
import static com.mycompany.twitter.datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class SeguirDAO implements iSeguirDAO {

    private static final String SQL_SEGUIR = "INSERT INTO seguir (seguidor_id, seguido_id) VALUES (?, ?)";

    private static final String SQL_COMPROBAR_SEGUIDO = "SELECT 1 FROM seguir WHERE seguidor_id = ? AND seguido_id = ?";

    private static final String SQL_ACTUALIZAR_SEGUIDORES = "UPDATE usuario SET num_seguidores = (SELECT COUNT(s.seguidor_id) FROM seguir s WHERE s.seguido_id = usuario.id)";

    @Override
    public void seguir(int seguidor_id, int seguido_id) {
        // Comprobar si el usuario ya sigue al otro usuario
        boolean sigue = comprobarSeguido(seguidor_id, seguido_id);
        if (sigue) {
            System.out.println("YA ERES SEGUIDOR.");
        } else {
            Connection conn = null;
            PreparedStatement ps = null;

            try {
                conn = getConnection();
                ps = conn.prepareStatement(SQL_SEGUIR);
                ps.setInt(1, seguidor_id);
                ps.setInt(2, seguido_id);
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

    @Override
    public boolean comprobarSeguido(int seguidor_id, int seguido_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean sigue = false;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_COMPROBAR_SEGUIDO);
            ps.setInt(1, seguidor_id);
            ps.setInt(2, seguido_id);
            rs = ps.executeQuery();

            sigue = rs.next();

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

        return sigue;
    }

    @Override
    public void actualizarNumeroSeguidores() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ACTUALIZAR_SEGUIDORES);
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
