package pilas;

import Nodos.NodoUsuario;
import clases.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class PilaUsuario
{

    NodoUsuario raiz;
    FileOutputStream osF;
    ObjectOutputStream osB;
    FileInputStream isF;
    ObjectInputStream isB;
    String ruta;

    public PilaUsuario(String ruta)
    {
        this.ruta = ruta;
        this.raiz = crearArchivo();
    }

    public void recargarRaiz()
    {
        try {
            raiz = leerArchivo();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean insertarUsuario(Usuario usuario)
    {
        try {
            if (!validarExistenciaUsuario(usuario, 1)) {
                NodoUsuario lecturaLista = procesoInsertarNodo(raiz, usuario);
                this.raiz = lecturaLista;
                boolean guardarRaiz = escribirArchivo(raiz);
                if (guardarRaiz) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean editarUsuario(Usuario usuario)
    {
        try {
            if (!validarExistenciaUsuario(usuario, 2)) {
                NodoUsuario nodo = raiz;
                while (nodo != null) {
                    String numeroIdentificacionNodo = nodo.valorNodo.getNumeroIdentificacion();
                    if (numeroIdentificacionNodo.equals(usuario.getNumeroIdentificacion())) {
                        nodo.valorNodo = usuario;
                    }
                    nodo = nodo.siguienteNodo;
                }
                boolean tarea = escribirArchivo(raiz);
                return tarea;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Usuario obtenerUsuario(String usuarioCliente, String contrasenaCliente)
    {
        try {
            NodoUsuario nodo = raiz;
            Usuario encontrado = null;
            while (nodo != null) {
                Usuario usuarioNodo = nodo.valorNodo;
                if (usuarioCliente.equals(usuarioNodo.getUsuario()) && contrasenaCliente.equals(usuarioNodo.getContrasena())) {
                    encontrado = usuarioNodo;
                    break;
                }
                nodo = nodo.siguienteNodo;
            }

            return encontrado;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean validarExistenciaUsuario(Usuario usuario, int tipoAnalisis)
    {
        try {
            boolean encontrado = false;
            NodoUsuario nodo = raiz;
            switch (tipoAnalisis) {
                case 1:
                    while (nodo != null) {
                        Usuario usuarioNodo = nodo.valorNodo;
                        if (usuarioNodo.getUsuario().equals(usuario.getUsuario()) || usuarioNodo.getNumeroIdentificacion().equals(usuario.getNumeroIdentificacion())) {
                            encontrado = true;
                            break;
                        }
                        nodo = nodo.siguienteNodo;
                    }
                    break;
                case 2:
                    String numeroIdentificacion = usuario.getNumeroIdentificacion();
                    while (nodo != null) {
                        Usuario usuarioNodo = nodo.valorNodo;
                        if (!numeroIdentificacion.equals(usuarioNodo.getNumeroIdentificacion())) {
                            if (usuario.getUsuario().equals(usuarioNodo.getUsuario())) {
                                encontrado = true;
                                break;
                            }
                        }
                        nodo = nodo.siguienteNodo;
                    }
                    break;
                case 3:
                    String usuarioLog = usuario.getUsuario();
                    String contrasenaLog = usuario.getContrasena();
                    while (nodo != null) {
                        Usuario usuarioNodo = nodo.valorNodo;
                        if (usuarioLog.equals(usuarioNodo.getUsuario()) && contrasenaLog.equals(usuarioNodo.getContrasena())) {
                            encontrado = true;
                        }
                        nodo = nodo.siguienteNodo;
                    }

                    break;
            }

            return encontrado;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private NodoUsuario procesoInsertarNodo(NodoUsuario raiz, Usuario usuario)
    {
        try {
            NodoUsuario nodo;
            nodo = new NodoUsuario(usuario);
            if (raiz == null) {
                nodo.siguienteNodo = null;
            } else {
                nodo.siguienteNodo = raiz;
            }
            return nodo;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private NodoUsuario crearArchivo()
    {
        try {
            if (!existenciaArchivo()) {
                boolean tarea = escribirArchivo(null);
                if (tarea) {
                    return null;
                }
            } else {
                NodoUsuario nodoRaiz = leerArchivo();
                return nodoRaiz;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private NodoUsuario leerArchivo()
    {
        try {
            NodoUsuario nodo;
            isF = new FileInputStream(ruta);
            isB = new ObjectInputStream(isF);
            nodo = (NodoUsuario) isB.readObject();
            isB.close();
            isF.close();
            return nodo;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    private boolean escribirArchivo(Object dato)
    {
        try {
            osF = new FileOutputStream(ruta);
            osB = new ObjectOutputStream(osF);
            osB.writeObject(dato);
            osB.close();
            osF.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    private boolean existenciaArchivo()
    {
        try {
            File file = new File(ruta);
            if (file.exists()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void imprimir()
    {
        NodoUsuario nodo = raiz;
        while (nodo != null) {
            Usuario us = nodo.valorNodo;
            System.out.println("\n------------\n"
                    + "Nombre: " + us.getNombre() + "\n"
                    + "Apellidos" + us.getApellidos() + "\n"
                    + "usuario: " + us.getUsuario() + "\n"
                    + "contrasena: " + us.getContrasena() + "\n"
                    + "corre: " + us.getCorreoElectronico() + "\n"
                    + "numero ID: " + us.getNumeroIdentificacion());
            nodo = nodo.siguienteNodo;
        }
    }
}
