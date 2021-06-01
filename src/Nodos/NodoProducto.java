/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import clases.Producto;
import java.io.Serializable;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class NodoProducto implements Serializable
{

    public Producto valorNodo;
    public NodoProducto siguienteNodo;

    public NodoProducto(Producto valorNodo)
    {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }

}
