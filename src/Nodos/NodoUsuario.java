/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import clases.Usuario;
import java.io.Serializable;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class NodoUsuario implements Serializable
{

    public Usuario valorNodo;
    public NodoUsuario siguienteNodo;

    public NodoUsuario()
    {
    }

    public NodoUsuario(Usuario valorNodo)
    {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }
}
