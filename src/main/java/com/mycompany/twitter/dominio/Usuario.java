/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.dominio;

import com.mycompany.twitter.Services.CommonIMPL;
import com.mycompany.twitter.datos.TweetDAO;
import com.mycompany.twitter.Services.iCommon;
import com.mycompany.twitter.datos.LikeDAO;
import com.mycompany.twitter.datos.SeguirDAO;
import com.mycompany.twitter.datos.iTweetDAO;
import com.mycompany.twitter.datos.UsuarioDAO;
import com.mycompany.twitter.datos.iLikeDAO;
import com.mycompany.twitter.datos.iSeguirDAO;
import com.mycompany.twitter.datos.iTweetDAO;
import com.mycompany.twitter.datos.iUsuarioDAO;
import com.sun.tools.javac.Main;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Usuario {

    private int id;
    private String nombre_usuario;
    private String contrasena;
    private String correo_electronico;
    private Date fecha_nacimiento;
    private String biografia;
    private String sitio_web;
    private String ubicacion;
    private int num_seguidores;
    private Date fecha_creacion;

    public Usuario() {
    }

    public Usuario(int id, String nombre_usuario, String contrasena, String correo_electronico, String ubicacion, int num_seguidores) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.correo_electronico = correo_electronico;
        this.ubicacion = ubicacion;
        this.num_seguidores = num_seguidores;
    }

    public Usuario(String nombre_usuario, String contrasena, String correo_electronico, String ubicacion) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.correo_electronico = correo_electronico;
        this.ubicacion = ubicacion;
    }

    public Usuario(int id, String nombre_usuario, String contrasena, String correo_electronico, Date fecha_nacimiento, String biografia, String sitio_web, String ubicacion, int num_seguidores, Date fecha_creacion) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.correo_electronico = correo_electronico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.biografia = biografia;
        this.sitio_web = sitio_web;
        this.ubicacion = ubicacion;
        this.num_seguidores = num_seguidores;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNum_seguidores() {
        return num_seguidores;
    }

    public void setNum_seguidores(int num_seguidores) {
        this.num_seguidores = num_seguidores;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t\t\t\tNOMBRE USUARIO: @").append(nombre_usuario);
        sb.append("\n\t\t\t\t========================================");
        sb.append("\n\t\t\t\t\tID: ").append(id);
        sb.append("\n\t\t\t\t\tCORREO ELECTRONICO: ").append(correo_electronico);
        sb.append("\n\t\t\t\t\tPASSWORD: ").append(contrasena);
        sb.append("\n\t\t\t\t\tUBICACION: ").append(ubicacion);
        sb.append("\n\t\t\t\t\tNUMERO SEGUIDORES: ").append(num_seguidores);
        if (biografia != null) {
        sb.append("\n\t\t\t\t\tBIOGRAFIA: ");
        int MAX_LENGTH = 44; // Longitud máxima de la línea de la biografía
        for (int i = 0; i < biografia.length(); i += MAX_LENGTH) {
            sb.append("\n\t\t\t\t\t\t").append(biografia.substring(i, Math.min(i + MAX_LENGTH, biografia.length())));
        }
        }
        sb.append("\n\t\t\t\t\tSITIO WEB: ").append(sitio_web);
        sb.append("\n\t\t\t\t\tFECHA NACIMIENTO: ").append(fecha_nacimiento);
        sb.append("\n\t\t\t\t\tFECHA CREACION: ").append(fecha_creacion);
        return sb.toString();
    }

//================================================================================================================================
//                                              CONJUNTO DE METODOS DEL USUARIO:
//================================================================================================================================
    public void crearUsuario(iUsuarioDAO IUsuarioDAO) {
        iCommon iCommon = new CommonIMPL();
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        int opcion;
        int numUsuariosConMismoNombre;

//VALIDACION NOMBRE DE USUARIO
        do {
            iCommon.dibujoCrearUsuarioNombre();
            System.out.print("NOMBRE DE USUARIO: ");
            nombre_usuario = scanner.nextLine();
            opcion = 1;
            numUsuariosConMismoNombre = IUsuarioDAO.comprobarDatos1(nombre_usuario, opcion);

            if (numUsuariosConMismoNombre > 0) {
                System.out.println("EL NOMBRE DE USUARIO YA EXISTE");
                iCommon.continuar();
            }
        } while (numUsuariosConMismoNombre > 0);
        usuario.setNombre_usuario(nombre_usuario);

// VALIDACION CONTRASEÑA
        boolean contrasenaValida = false;
        while (!contrasenaValida) {
            iCommon.dibujoCrearUsuarioContrasnia();
            System.out.print("PASSWORD: ");
            String password = scanner.nextLine();

            if (password.matches("(?=.*[a-zA-Z])(?=.*\\d).{8,}")) {
                usuario.setContrasena(password);
                opcion = 0;
                contrasenaValida = true; // ACTUALIZO LA VARIABLE PARA ROMPER EL CICLO
            } else {
                System.out.println("LA PASSWORD DEBE TENER AL MENOS 8 CARACTERES Y CONTENER UNA LETRA Y UN NUMERO.");
                iCommon.continuar();
            }
        }

// VALIDACION CORREO ELECTRONICO
        while (true) {
            iCommon.dibujoCrearUsuarioCorreo();
            System.out.print("CORREO ELECTRONICO: ");
            String email = scanner.nextLine();

            if (email.matches("^[A-Za-z0-9+_.-]+@(.*\\.)*(com|es|net)$")) {
                int coincidencias = IUsuarioDAO.comprobarDatos1(email, 2);
                if (coincidencias > 0) {
                    System.out.println("EL CORREO ELECTRONICO YA ESTA EN USO.");
                    iCommon.continuar();
                } else {
                    usuario.setCorreo_electronico(email);
                    break;
                }
            } else {
                System.out.println("FORMATO DE CORREO NO VALIDO.");
                iCommon.continuar();
            }
        }

        iCommon.dibujoCrearUsuarioUbicacion();
        System.out.print("UBICACION: ");
        usuario.setUbicacion(scanner.nextLine());
        IUsuarioDAO.insertar(usuario);

        System.out.println("USUARIO CREADO CORRECTAMENTE.");
        iCommon.continuar();
    }

    public Usuario iniciarSesion() {
        iUsuarioDAO IUsuarioDAO = new UsuarioDAO();
        iCommon iCommon = new CommonIMPL();
        Scanner scanner = new Scanner(System.in);
        boolean correo_existe = false;
        boolean contraseniaCorrecta = false;
        Usuario usuario1 = null;
        int opcion = 1;

        do {
            while (!correo_existe) {
                System.out.println("INTRODUCE EL CORREO ELECTRONICO: ");
                String correo_electronico = scanner.nextLine();

                usuario1 = IUsuarioDAO.comprobarDatos(correo_electronico);

                if (usuario1 != null) {
                    correo_existe = true;
                } else {
                    System.out.println("EL CORREO ELECTRONICO INTRODUCIDO NO EXISTE EN LA BASE DE DATOS");
                    iCommon.continuar();

                }
            }
            System.out.println(usuario1);

            while (!contraseniaCorrecta) {

                System.out.println("INTRODUCE LA PASSWORD: ");
                String contrasenia = scanner.nextLine();

                if (contrasenia.equals(usuario1.getContrasena())) {
                    contraseniaCorrecta = true;
                    opcion = 2;
                } else {
                    System.out.println("PASSWORD INCORRECTA");
                    iCommon.continuar();
                }

            }

        } while (opcion == 1);

        return usuario1;
    }

    public void menuUsuario(Usuario usuario1) {
        Scanner scanner = new Scanner(System.in);
        iCommon iCommon = new CommonIMPL();
        iTweetDAO iTweetDAO = new TweetDAO();

        int opcion;
        iUsuarioDAO IUsuarioDAO = new UsuarioDAO();

        do {
            usuario1 = IUsuarioDAO.iniciarSesion(usuario1.getCorreo_electronico(), usuario1.getContrasena());
            iCommon.dibujoMenuUsuario();
//            iCommon.dibujoMenuUsuario2(usuario1);
            String input = scanner.nextLine();

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    // VER PERFIL DE USUARIO
                    iCommon.imprimirEspacios();
                    operacionesUsuarioCRUD(usuario1);
                    iCommon.continuar();
                    break;
                case 2:
                    iCommon.imprimirEspacios();
                    iTweetDAO.mostrarTweetsSeguidos(usuario1.getId());
                    submenuOpciones(usuario1);
                    break;
                case 3:
                    iCommon.imprimirEspacios();
                    System.out.println("USUARIOS A LOS QUE SIGUES: ");
                    IUsuarioDAO.mostrarUsuariosSeguidos(usuario1.getId());
                    iCommon.continuar();
                    break;
                case 4:
                    //PUBLICAR TWEET
                    iCommon.imprimirEspacios();
                    System.out.print("ESCRIBE TU TWEET: ");
                    String texto = scanner.nextLine();
                    iTweetDAO.publicarTweet(usuario1.getId(), texto);
                    iCommon.continuar();
                    break;
                case 5:
                    iCommon.imprimirEspacios();
                    System.out.println("MIS TWEETS: ");
                    // IUsuarioDAO.verTweetsEscritos(usuario1.getId());
                    iTweetDAO.verTweetsEscritos(usuario1.getId());
                    iCommon.continuar();
                    break;
                case 6:
                    iCommon.imprimirEspacios();
                    submenuOpciones(usuario1);
                    break;
                case 7:
                    iCommon.imprimirEspacios();
                    menuBuscar(usuario1);
                    break;
                case 0:
                    System.out.println("CERRANDO SESION...");
                    iCommon.dibujoFinal();
                    System.exit(0);

                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private void submenuOpciones(Usuario usuario1) {
        Scanner scanner = new Scanner(System.in);
        iCommon iCommon = new CommonIMPL();
        iSeguirDAO iSeguirDAO = new SeguirDAO();
        iLikeDAO iLikeDAO = new LikeDAO();
        iTweetDAO iTweetDAO = new TweetDAO();
        int opcion;
        iUsuarioDAO IUsuarioDAO = new UsuarioDAO();

        do {
            iTweetDAO.explorar(usuario1.getId());
            iCommon.dibujoSubMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    iCommon.imprimirEspacios();
                    System.out.println("INTRODUCE EL ID DEL TWEET AL QUE QUIERES DAR LIKE: ");
                    int tweet_id = scanner.nextInt();
                    iLikeDAO.darLike(usuario1.getId(), tweet_id);
                    iCommon.continuar();
                    break;
                case 2:
                    iCommon.imprimirEspacios();
                    System.out.println("INTRODUCE EL ID DEL USUARIO AL QUE DESEES SEGUIR: ");
                    int seguido_id = scanner.nextInt();
                    iSeguirDAO.seguir(usuario1.getId(), seguido_id);
                    iSeguirDAO.actualizarNumeroSeguidores();
                    iCommon.continuar();
                    break;
                case 3:
                    iCommon.imprimirEspacios();

                    iCommon.continuar();
                    break;
                case 4:
                    // Publicar tweet
                    iCommon.imprimirEspacios();

                    iCommon.continuar();
                    break;
                case 0:
                    menuUsuario(usuario1);
                default:
                    System.out.println("OPCION INVALIDA");
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();

    }

    private void operacionesUsuarioCRUD(Usuario usuario1) {
        Scanner scanner = new Scanner(System.in);
        iCommon iCommon = new CommonIMPL();
        int opcion;
        iUsuarioDAO IUsuarioDAO = new UsuarioDAO();

        do {
            usuario1 = IUsuarioDAO.iniciarSesion(usuario1.getCorreo_electronico(), usuario1.getContrasena());
            System.out.println(usuario1);
            iCommon.dibujoMenuCRUD();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            switch (opcion) {
                case 1:
                    //ACTUALIZAR NOMBRE USUARIO
                    iCommon.imprimirEspacios();
                    scanner.nextLine(); // consume el carácter de nueva línea pendiente
                    System.out.print("PARA CAMBIAR EL NOMBRE DE USUARIO PRIMERO INTROUDCE TU PASSWORD: ");
                    String contrasenia = scanner.nextLine();
                    if (contrasenia.equals(usuario1.getContrasena())) {
                        System.out.print("INTRODUCE EL NUEVO NOMBRE DE USUARIO: ");
                        String nuevo_nombre = scanner.nextLine();
                        System.out.println("NUEVO NOMBRE: " + nuevo_nombre);
                        IUsuarioDAO.modificarNombreUsuario(usuario1.getId(), nuevo_nombre);
                    } else {
                        System.out.println("PASSWORD INCORRECTA");
                    }
                    iCommon.continuar();
                    break;
                case 2:
                    //ACTUALIZAR PASSWORD
                    iCommon.imprimirEspacios();
                    scanner.nextLine(); // consume el carácter de nueva línea pendiente
                    System.out.print("INTRODUCE LA NUEVA PASSWORD: ");
                    String contrasenia2 = scanner.nextLine();
                    usuario1.setContrasena(contrasenia2);
                    System.out.println(contrasenia2);
                    IUsuarioDAO.modificarContrasenaUsuario(usuario1.getId(), contrasenia2);
                    iCommon.continuar();
                    break;
                case 3:
                    //ACTUALIZAR NOMBRE USUARIO
                    iCommon.imprimirEspacios();
                    scanner.nextLine(); // consume el carácter de nueva línea pendiente
                    System.out.print("INTRODUCE EL NUEVO CORREO ELECTRONICO: ");
                    String nuevo_nombre = scanner.nextLine();
                    usuario1.setCorreo_electronico(nuevo_nombre);
                    System.out.println("NUEVO CORREO: " + nuevo_nombre);
                    IUsuarioDAO.modificarCorreoElectronicoUsuario(usuario1.getId(), nuevo_nombre);

                    iCommon.continuar();
                    break;
                case 4:
                    //ACTUALIZAR RESTO DEL PERFIL
                    iCommon.imprimirEspacios();
                    System.out.print("Introduce la nueva biografía: ");
                    String nuevaBiografia = scanner.nextLine();
                    usuario1.setBiografia(nuevaBiografia);

                    System.out.print("Introduce el nuevo sitio web: ");
                    String nuevoSitioWeb = scanner.nextLine();
                    usuario1.setSitio_web(nuevoSitioWeb);

                    System.out.print("Introduce la fecha de nacimiento en formato yyyy-mm-dd: ");
                    String fechaNacimientoString = scanner.nextLine();
                    java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoString);
                    IUsuarioDAO.modificarUsuario(usuario1.getId(), nuevaBiografia, nuevoSitioWeb, fechaNacimiento);
                    System.out.println("USUARIO ACTUALIZADO.");
                    iCommon.continuar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("OPCION INVALIDA");
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();

    }

    private void menuBuscar(Usuario usuario1) {
        Scanner scanner = new Scanner(System.in);
        iCommon iCommon = new CommonIMPL();
        int opcion;
        iUsuarioDAO IUsuarioDAO = new UsuarioDAO();

        do {

            iCommon.dibujoMenuBuscar();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            switch (opcion) {
                case 1:
                    //ACTUALIZAR NOMBRE USUARIO
                    iCommon.imprimirEspacios();

                    iCommon.continuar();
                    break;
                case 2:
                    //ACTUALIZAR PASSWORD
                    iCommon.imprimirEspacios();

                    iCommon.continuar();
                    break;
                case 3:
                    //ACTUALIZAR NOMBRE USUARIO
                    iCommon.imprimirEspacios();

                    iCommon.continuar();
                    break;
                case 4:
                    //ACTUALIZAR RESTO DEL PERFIL
                    iCommon.imprimirEspacios();

                    iCommon.continuar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("OPCION INVALIDA");
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();

    }

}
