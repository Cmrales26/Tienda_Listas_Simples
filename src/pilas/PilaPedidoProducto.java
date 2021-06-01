/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import Nodos.NodoPedido;
import Nodos.NodoPedidoProducto;
import clases.Pedido;
import clases.PedidoProducto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class PilaPedidoProducto
{

    private NodoPedidoProducto raiz;
    private FileOutputStream osF;
    private ObjectOutputStream osB;
    private FileInputStream isF;
    private ObjectInputStream isB;
    private String ruta;

    public PilaPedidoProducto(String ruta)
    {
        this.ruta = ruta;
        this.raiz = crearArchivo();
    }

    public NodoPedidoProducto getNodoRaizPedidoProducto()
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

    public boolean insertarPedidoProducto(PedidoProducto pedidoProducto)
    {
        try {
            NodoPedidoProducto nodoLista = procesoInsertarNodo(raiz, pedidoProducto);
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

    public boolean editarPedidoProducto(PedidoProducto pedidoProducto)
    {
        try {
            NodoPedidoProducto nodo = raiz;
            while (nodo != null) {
                PedidoProducto pedidoProductoNode = nodo.valorNodo;
                if (Objects.equals(pedidoProductoNode.getNumeroPedido(), pedidoProducto.getNumeroPedido())
                        && Objects.equals(pedidoProductoNode.getIdentificador(), pedidoProducto.getIdentificador())
                        && pedidoProductoNode.getNumeroIdentificacion().equals(pedidoProducto.getNumeroIdentificacion())) {
                    nodo.valorNodo = pedidoProducto;
                    break;
                }
                nodo = nodo.siguienteNodo;
            }
            
            boolean tarea = escribirArchivo(raiz);
            return tarea;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Integer cantidadNodos()
    {
        try {
            int cantidad = 0;
            NodoPedidoProducto nodo = raiz;
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

    private NodoPedidoProducto procesoInsertarNodo(NodoPedidoProducto raiz, PedidoProducto pedidoProducto)
    {
        try {
            NodoPedidoProducto nodo;
            nodo = new NodoPedidoProducto(pedidoProducto);
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

    private NodoPedidoProducto crearArchivo()
    {
        try {
            if (!existenciaArchivo()) {
                boolean tarea = escribirArchivo(null);
                if (tarea) {
                    return null;
                }
            } else {
                NodoPedidoProducto nodoRaiz = leerArchivo();
                return nodoRaiz;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private NodoPedidoProducto leerArchivo()
    {
        try {
            NodoPedidoProducto nodo;
            isF = new FileInputStream(ruta);
            isB = new ObjectInputStream(isF);
            nodo = (NodoPedidoProducto) isB.readObject();
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
