/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import clases.Pedido;
import java.io.Serializable;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class NodoPedido implements Serializable
{
    public Pedido valorNodo;
    public NodoPedido siguienteNodo;

    public NodoPedido(Pedido valorNodo)
    {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }
}
