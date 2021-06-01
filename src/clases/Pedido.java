/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class Pedido implements Serializable
{
    private Integer numeroPedido;
    private String usuario;
    private String numeroIdentificacion;
    private String fecha;

    public Pedido(Integer numeroPedido, String usuario, String numeroIdentificacion, String fecha)
    {
        this.numeroPedido = numeroPedido;
        this.usuario = usuario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fecha = fecha;
    }

    public Integer getNumeroPedido()
    {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido)
    {
        this.numeroPedido = numeroPedido;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getNumeroIdentificacion()
    {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion)
    {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }
    
    
}
