/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import Nodos.NodoProducto;
import Nodos.NodoUsuario;
import clases.Producto;
import clases.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class PilaProducto
{

    private NodoProducto raiz;
    private FileOutputStream osF;
    private ObjectOutputStream osB;
    private FileInputStream isF;
    private ObjectInputStream isB;
    private String ruta;

    public PilaProducto(String ruta)
    {
        this.ruta = ruta;
        this.raiz = crearArchivo();
    }

    public NodoProducto getNodoRaizProducto()
    {
        return raiz;
    }
    
    public void recargarRaiz(){
        try {
            this.raiz = leerArchivo();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean insertarProducto(Producto producto)
    {
        try {
            if (!validarExistenciaProducto(producto, 1)) {
                NodoProducto lecturaLista = procesoInsertarNodo(raiz, producto);
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

    public boolean editarProducto(Producto producto)
    {
        try {
            if (validarExistenciaProducto(producto, 2)) {
                NodoProducto nodo = raiz;
                while (nodo != null) {
                    String codigo = nodo.valorNodo.getCodigo();
                    if (codigo.equals(producto.getCodigo())) {
                        nodo.valorNodo = producto;
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

    public Integer cantidadNodos()
    {
        try {
            int cantidad = 0;
            NodoProducto nodo = raiz;
            while (nodo != null) {        
                cantidad++;
                nodo = nodo.siguienteNodo;
            }
            return cantidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private boolean validarExistenciaProducto(Producto producto, int tipoAnalisis)
    {
        try {
            boolean encontrado = false;
            NodoProducto nodo = raiz;
            switch (tipoAnalisis) {
                case 1:
                    while (nodo != null) {
                        Producto prodcutoNodo = nodo.valorNodo;
                        if (prodcutoNodo.getCodigo().equals(producto.getCodigo())) {
                            encontrado = true;
                            break;
                        }
                        nodo = nodo.siguienteNodo;
                    }
                    break;
                case 2:
                    String codigo = producto.getCodigo();
                    while (nodo != null) {
                        Producto prodcutoNodo = nodo.valorNodo;
                        if (codigo.equals(prodcutoNodo.getCodigo())) {
                            encontrado = true;
                            break;
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

    private NodoProducto procesoInsertarNodo(NodoProducto raiz, Producto producto)
    {
        try {
            NodoProducto nodo;
            nodo = new NodoProducto(producto);
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

    private NodoProducto crearArchivo()
    {
        try {
            if (!existenciaArchivo()) {
                boolean tarea = escribirArchivo(null);
                if (tarea) {
                    return null;
                }
            } else {
                NodoProducto nodoRaiz = leerArchivo();
                return nodoRaiz;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private NodoProducto leerArchivo()
    {
        try {
            NodoProducto nodo;
            isF = new FileInputStream(ruta);
            isB = new ObjectInputStream(isF);
            nodo = (NodoProducto) isB.readObject();
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
        NodoProducto nodo = raiz;
        while (nodo != null) {
            Producto us = nodo.valorNodo;

            System.out.println("\n------------\n"
                    + "NOMBRE: " + us.getNombre() + "\n"
                    + "CODIGO" + us.getCodigo() + "\n"
                    + "PRECIO: " + us.getPrecio());
            nodo = nodo.siguienteNodo;
        }
    }
}
