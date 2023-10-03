

package com.mycompany.twitter;

import com.mycompany.twitter.Services.CommonIMPL;
import com.mycompany.twitter.Services.iCommon;
import com.mycompany.twitter.datos.UsuarioDAO;
import com.mycompany.twitter.datos.iUsuarioDAO;
import com.mycompany.twitter.dominio.Usuario;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Twitter {

    public static void main(String[] args) {
        iUsuarioDAO IUsuarioDAO = new UsuarioDAO();
        iCommon iCommon = new CommonIMPL();
        iCommon ddd = new CommonIMPL();
        
        menu(IUsuarioDAO, iCommon);

    }

    private static void menu(iUsuarioDAO IUsuarioDAO, iCommon iCommon) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            
            iCommon.dibujoMenuInicio();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("CREAR NUEVO USUARIO: ");
                    Usuario usuario = new Usuario();
                    usuario.crearUsuario(IUsuarioDAO);
                    break;
                    
                case 2:
                    System.out.println("INICIAR SESION: ");
                    Usuario usuario1 = new Usuario();
                    usuario1 = usuario1.iniciarSesion();
                    System.out.println(usuario1);
                    usuario1.menuUsuario(usuario1);
                    break;
                case 0:
                    System.out.println("CERRANDO...");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }
}
