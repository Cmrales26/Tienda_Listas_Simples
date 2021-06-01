/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import clases.PedidoProducto;
import java.io.Serializable;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class NodoPedidoProducto implements Serializable
{

    public PedidoProducto valorNodo;
    public NodoPedidoProducto siguienteNodo;

    public NodoPedidoProducto(PedidoProducto valorNodo)
    {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }
}
