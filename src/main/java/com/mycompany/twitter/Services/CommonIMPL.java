/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.Services;

import com.mycompany.twitter.dominio.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class CommonIMPL implements iCommon {

    @Override
    public void dibujoMenuInicio() {
        imprimirEspacios();
        System.out.println("\t\t\t\t\t      _____        _ _   _              _______\n"
                + "\t\t\t\t\t     |_   _|_ __ _(_) |_| |_ ___ _ _   |       |\n"
                + "\t\t\t\t\t       | | \\ V  V / |  _|  _/ -_) '_|  |  >o)  |\n"
                + "\t\t\t\t\t       |_|  \\_/\\_/|_|\\__|\\__\\___|_|    |  (_>  |\n"
                + "\t\t\t\t\t                                       |_______|");

        System.out.println("\t\t\t ==============================================================================");
        System.out.println("\t\t\t|                        ________________________________                      |");
        System.out.println("\t\t\t|                       |                                |                     |");
        System.out.println("\t\t\t|                       |       1. CREAR USUARIO         |                     |");
        System.out.println("\t\t\t|                       |________________________________|                     |");
        System.out.println("\t\t\t|                        ________________________________                      |");
        System.out.println("\t\t\t|                       |                                |                     |");
        System.out.println("\t\t\t|                       |       2. INICIAR SESION        |                     |");
        System.out.println("\t\t\t|                       |________________________________|                     |");
        System.out.println("\t\t\t|                              _____________________                           |");
        System.out.println("\t\t\t|                             |                     |                          |");
        System.out.println("\t\t\t|                             |      0. SALIR       |                          |");
        System.out.println("\t\t\t|                             |_____________________|                          |");
        System.out.println("\t\t\t|                                                                              |");
        System.out.println("\t\t\t ==============================================================================");

    }

    @Override
    public void imprimirEspacios() {
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
    }

    public void continuar() {
        Scanner scanner = new Scanner(System.in);
        String apellidos = scanner.nextLine();
    }

    @Override
    public void dibujoCrearUsuarioNombre() {
        imprimirEspacios();
        System.out.println("\t\t\t                             _____        _ _   _           \n"
                + "\t\t\t                            |_   _|_ __ _(_) |_| |_ ___ _ _ \n"
                + "\t\t\t                              | | \\ V  V / |  _|  _/ -_) '_|\n"
                + "\t\t\t                              |_|  \\_/\\_/|_|\\__|\\__\\___|_|  \n"
                + "\t\t\t                                                            ");

        System.out.println("\t\t\t  ===========================================================================");
        System.out.println("\t\t\t |                   __________________________________________              |");
        System.out.println("\t\t\t |                  |                                          |             |");
        System.out.println("\t\t\t |                  |       INTRODUCE NOMBRE DE USUARIO        |             |");
        System.out.println("\t\t\t |                  |__________________________________________|             |");
        System.out.println("\t\t\t |                                                                           |");
        System.out.println("\t\t\t  ===========================================================================");

    }

    @Override
    public void dibujoCrearUsuarioContrasnia() {
        imprimirEspacios();
        System.out.println("\t\t\t                             _____        _ _   _           \n"
                + "\t\t\t                            |_   _|_ __ _(_) |_| |_ ___ _ _ \n"
                + "\t\t\t                              | | \\ V  V / |  _|  _/ -_) '_|\n"
                + "\t\t\t                              |_|  \\_/\\_/|_|\\__|\\__\\___|_|  \n"
                + "\t\t\t                                                            ");

        System.out.println("\t\t\t  ===========================================================================");
        System.out.println("\t\t\t |                   __________________________________________              |");
        System.out.println("\t\t\t |                  |                                          |             |");
        System.out.println("\t\t\t |                  |          INTRODUCE TU PASSWORD           |             |");
        System.out.println("\t\t\t |                  |__________________________________________|             |");
        System.out.println("\t\t\t |                                                                           |");
        System.out.println("\t\t\t  ===========================================================================");
    }

    @Override
    public void dibujoCrearUsuarioCorreo() {
        imprimirEspacios();
        System.out.println("\t\t\t                             _____        _ _   _           \n"
                + "\t\t\t                            |_   _|_ __ _(_) |_| |_ ___ _ _ \n"
                + "\t\t\t                              | | \\ V  V / |  _|  _/ -_) '_|\n"
                + "\t\t\t                              |_|  \\_/\\_/|_|\\__|\\__\\___|_|  \n"
                + "\t\t\t                                                            ");

        System.out.println("\t\t\t  ===========================================================================");
        System.out.println("\t\t\t |                   __________________________________________              |");
        System.out.println("\t\t\t |                  |                                          |             |");
        System.out.println("\t\t\t |                  |       INTRODUCE CORREO ELECTRONICO       |             |");
        System.out.println("\t\t\t |                  |__________________________________________|             |");
        System.out.println("\t\t\t |                                                                           |");
        System.out.println("\t\t\t  ===========================================================================");
    }

    @Override
    public void dibujoCrearUsuarioUbicacion() {
        imprimirEspacios();
        System.out.println("\t\t\t                             _____        _ _   _           \n"
                + "\t\t\t                            |_   _|_ __ _(_) |_| |_ ___ _ _ \n"
                + "\t\t\t                              | | \\ V  V / |  _|  _/ -_) '_|\n"
                + "\t\t\t                              |_|  \\_/\\_/|_|\\__|\\__\\___|_|  \n"
                + "\t\t\t                                                            ");

        System.out.println("\t\t\t  ===========================================================================");
        System.out.println("\t\t\t |                   __________________________________________              |");
        System.out.println("\t\t\t |                  |                                          |             |");
        System.out.println("\t\t\t |                  |           INTRODUCE UBICACION            |             |");
        System.out.println("\t\t\t |                  |__________________________________________|             |");
        System.out.println("\t\t\t |                                                                           |");
        System.out.println("\t\t\t  ===========================================================================");
    }

    @Override
    public void dibujoMenuUsuario() {
        imprimirEspacios();
        System.out.println("\t\t\t\t\t      _____        _ _   _              _______\n"
                + "\t\t\t\t\t     |_   _|_ __ _(_) |_| |_ ___ _ _   |       |\n"
                + "\t\t\t\t\t       | | \\ V  V / |  _|  _/ -_) '_|  |  >o)  |\n"
                + "\t\t\t\t\t       |_|  \\_/\\_/|_|\\__|\\__\\___|_|    |  (_>  |\n"
                + "\t\t\t\t\t                                       |_______|");
        System.out.println("\t\t\t ===============================================================================");
        System.out.println("\t\t\t|   ________________________________          ________________________________  |");
        System.out.println("\t\t\t|  |                                |        |                                | |");
        System.out.println("\t\t\t|  |         1. VER PERFIL          |        |         2. VER TWEETS          | |");
        System.out.println("\t\t\t|  |________________________________|        |________________________________| |");
        System.out.println("\t\t\t|   ________________________________          ________________________________  |");
        System.out.println("\t\t\t|  |                                |        |                                | |");
        System.out.println("\t\t\t|  |  3. VER GENTE A LA QUE SIGO    |        |       4. PUBLICAR TWEET        | |");
        System.out.println("\t\t\t|  |________________________________|        |________________________________| |");
        System.out.println("\t\t\t|   ________________________________          ________________________________  |");
        System.out.println("\t\t\t|  |                                |        |                                | |");
        System.out.println("\t\t\t|  |       5. VER MIS TWEETS        |        |          6. EXPLORAR           | |");
        System.out.println("\t\t\t|  |________________________________|        |________________________________| |");
        System.out.println("\t\t\t|   ________________________________          ________________________________  |");
        System.out.println("\t\t\t|  |                                |        |                                | |");
        System.out.println("\t\t\t|  |           7. VACIO             |        |           8. VACIO             | |");
        System.out.println("\t\t\t|  |________________________________|        |________________________________| |");
        System.out.println("\t\t\t|   ________________________________          ________________________________  |");
        System.out.println("\t\t\t|  |                                |        |                                | |");
        System.out.println("\t\t\t|  |           9. VACIO             |        |          10. VACIO             | |");
        System.out.println("\t\t\t|  |________________________________|        |________________________________| |");
        System.out.println("\t\t\t|                              _____________________                            |");
        System.out.println("\t\t\t|                             |                     |                           |");
        System.out.println("\t\t\t|                             |      0. SALIR       |                           |");
        System.out.println("\t\t\t|                             |_____________________|                           |");
        System.out.println("\t\t\t|                                                                               |");
        System.out.println("\t\t\t ===============================================================================");

    }

    public void dibujoMenuUsuario2(Usuario usuario) {
        imprimirEspacios();
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Fecha actual: " + formatoFecha.format(fechaActual));

        System.out.println("\t      _____        _ _   _              _______\n"
                + "\t     |_   _|_ __ _(_) |_| |_ ___ _ _   |       |\n"
                + "\t       | | \\ V  V / |  _|  _/ -_) '_|  |  >o)  |\n"
                + "\t       |_|  \\_/\\_/|_|\\__|\\__\\___|_|    |  (_>  |\n"
                + "\t                                       |_______|");
        System.out.println("\t ===================================================");
        System.out.println("\t|       1.       |                                  |       USER:  @" + usuario.getNombre_usuario() + "                                        ");
        System.out.println("\t|   VER PERFIL   |                                  | SEGUIDORES:  " + usuario.getNum_seguidores() + "         ");
        System.out.println("\t|                |                                  |  BIOGRAFIA:  " + usuario.getBiografia() + "                                    ");
        System.out.println("\t|________________|                                  |  SITIO WEB:  " + usuario.getSitio_web() + "                                          ");
        System.out.println("\t|       2.       |                                  |                                                ");
        System.out.println("\t|   VER TWEETS   |                                  |=================================================");
        System.out.println("\t|                |                                                    /                             \\|");
        System.out.println("\t|________________|                                                   |            6.BUSCAR        -º  |");
        System.out.println("\t|       3.       |                                                    \\ ____________________________/|");
        System.out.println("\t|  VER USUARIOS  |                                                                                   |");
        System.out.println("\t|    SEGUIDOS    |                                                                                   |");
        System.out.println("\t|________________|                                                                                   |");
        System.out.println("\t|       4.       |                                                                                   |");
        System.out.println("\t|    VER MIS     |                                                                                   |");
        System.out.println("\t|     TWEETS     |                                                                                   |");
        System.out.println("\t|________________|                                                                                   |");
        System.out.println("\t|       5.       |                                                                                   |");
        System.out.println("\t|    EXPLORAR    |                                                                                   |");
        System.out.println("\t|                |                                                                                   |");
        System.out.println("\t|________________|                                                                                   |");
        System.out.println("\t|       0.       |                                                         __________________________|");
        System.out.println("\t|     CERRAR     |                                                        |                          |");
        System.out.println("\t|     SESION     |                                                        |     7. PUBLICAR TWEET    |");
        System.out.println("\t|                |                                                        |                          |");
        System.out.println("\t ====================================================================================================");
    }

    @Override
    public void dibujoSubMenu() {
        System.out.println("\t\t\t ===============================================================================");
        System.out.println("\t\t\t|      _____________     _____________     _____________     _____________      |");
        System.out.println("\t\t\t|     |       1.    |   |      2.     |   |       3     |   |      4      |     |   _______");
        System.out.println("\t\t\t|     |   DAR LIKE  |   |    SEGUIR   |   |   RETWEET   |   |    VACIO    |     |  |       |");
        System.out.println("\t\t\t|     |_____________|   |_____________|   |_____________|   |_____________|     |  |  >o)  |");
        System.out.println("\t\t\t|                              _____________________                            |  |  (_>  |");
        System.out.println("\t\t\t|                             |                     |                           |  |_______|");
        System.out.println("\t\t\t|                             |      0. VOLVER      |                           |   TWITTER      ");
        System.out.println("\t\t\t|                             |_____________________|                           |");
        System.out.println("\t\t\t|                                                                               |");
        System.out.println("\t\t\t ===============================================================================");
    }

    @Override
    public void dibujoMenuCRUD() {

        System.out.println("\t\t\t =================================================== ");
        System.out.println("\t\t\t|      _____________             _____________      |");
        System.out.println("\t\t\t|     |      1.     |           |      2.     |     |");
        System.out.println("\t\t\t|     |   CAMBIAR   |           |   CAMBIAR   |     |");
        System.out.println("\t\t\t|     |   NOMBRE    |           |   PASSWORD  |     |");
        System.out.println("\t\t\t|     |_____________|           |_____________|     |");
        System.out.println("\t\t\t|      _____________             _____________      |");
        System.out.println("\t\t\t|     |      3.     |           |      4.     |     |");
        System.out.println("\t\t\t|     |   CAMBIAR   |           |  COMPLETAR  |     |");
        System.out.println("\t\t\t|     |   CORREO    |           |   USUARIO   |     |   _______");
        System.out.println("\t\t\t|     |_____________|           |_____________|     |  |       |");
        System.out.println("\t\t\t|                    ___________                    |  |  >o)  |");
        System.out.println("\t\t\t|                   |     0     |                   |  |  (_>  |");
        System.out.println("\t\t\t|                   |   VOLVER  |                   |  |_______|");
        System.out.println("\t\t\t|                   |___________|                   |   TWITTER ");
        System.out.println("\t\t\t =================================================== ");

    }

    @Override
    public void dibujoMenuBuscar() {

        System.out.println("\t\t\t =================================================== ");
        System.out.println("\t\t\t|      _____________             _____________      |");
        System.out.println("\t\t\t|     |      1.     |           |      2.     |     |");
        System.out.println("\t\t\t|     |    BUSCAR   |           |    BUSCAR   |     |");
        System.out.println("\t\t\t|     |   USUARIO   |           |    TWEET    |     |   _______");
        System.out.println("\t\t\t|     |_____________|           |_____________|     |  |       |");
        System.out.println("\t\t\t|                    ___________                    |  |  >o)  |");
        System.out.println("\t\t\t|                   |     0     |                   |  |  (_>  |");
        System.out.println("\t\t\t|                   |   VOLVER  |                   |  |_______|");
        System.out.println("\t\t\t|                   |___________|                   |   TWITTER ");
        System.out.println("\t\t\t =================================================== ");
    }

    @Override
    public void dibujoFinal() {
        imprimirEspacios();
        System.out.println("\t\t\t                             _____        _ _   _           \n"
                + "\t\t\t                            |_   _|_ __ _(_) |_| |_ ___ _ _ \n"
                + "\t\t\t                              | | \\ V  V / |  _|  _/ -_) '_|\n"
                + "\t\t\t                              |_|  \\_/\\_/|_|\\__|\\__\\___|_|  \n"
                + "\t\t\t                                                            ");

        System.out.println("\t\t\t  ===========================================================================");
        System.out.println("\t\t\t |                   __________________________________________              |");
        System.out.println("\t\t\t |                  |                                          |             |");
        System.out.println("\t\t\t |                  |               HASTA PRONTO               |             |");
        System.out.println("\t\t\t |                  |__________________________________________|             |");
        System.out.println("\t\t\t |                                                                           |");
        System.out.println("\t\t\t  ===========================================================================");

    }
}
