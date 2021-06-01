/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import Nodos.NodoPedido;
import clases.Pedido;
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
public class PilaPedido
{

    private NodoPedido raiz;
    private FileOutputStream osF;
    private ObjectOutputStream osB;
    private FileInputStream isF;
    private ObjectInputStream isB;
    private String ruta;

    public PilaPedido(String ruta)
    {
        this.ruta = ruta;
        this.raiz = crearArchivo();
    }

    public NodoPedido getNodoRaizProducto()
    {
        return raiz;
    }

    public void recargarRaiz()
    {
        try {
            this.raiz = leerArchivo();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean insertarPedido(Pedido pedido)
    {
        try {
            NodoPedido nodoLista = procesoInsertarNodo(raiz, pedido);
            this.raiz = nodoLista;
            boolean guardarRaiz = escribirArchivo(raiz);
            if (guardarRaiz) {
                return true;
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
            NodoPedido nodo = raiz;
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

    private NodoPedido procesoInsertarNodo(NodoPedido raiz, Pedido pedido)
    {
        try {
            NodoPedido nodo;
            nodo = new NodoPedido(pedido);
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

    private NodoPedido crearArchivo()
    {
        try {
            if (!existenciaArchivo()) {
                boolean tarea = escribirArchivo(null);
                if (tarea) {
                    return null;
                }
            } else {
                NodoPedido nodoRaiz = leerArchivo();
                return nodoRaiz;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private NodoPedido leerArchivo()
    {
        try {
            NodoPedido nodo;
            isF = new FileInputStream(ruta);
            isB = new ObjectInputStream(isF);
            nodo = (NodoPedido) isB.readObject();
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
}
