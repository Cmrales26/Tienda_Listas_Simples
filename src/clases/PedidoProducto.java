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
public class PedidoProducto implements Serializable
{
    private Integer numeroPedido;
    private Integer identificador;
    private String producto;
    private String numeroIdentificacion;
    private String cantidad;

    public PedidoProducto(Integer numeroPedido, Integer identificador, String producto, String numeroIdentificacion, String cantidad)
    {
        this.numeroPedido = numeroPedido;
        this.identificador = identificador;
        this.producto = producto;
        this.numeroIdentificacion = numeroIdentificacion;
        this.cantidad = cantidad;
    }

    public Integer getNumeroPedido()
    {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido)
    {
        this.numeroPedido = numeroPedido;
    }

    public Integer getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(Integer identificador)
    {
        this.identificador = identificador;
    }

    public String getProducto()
    {
        return producto;
    }

    public void setProducto(String producto)
    {
        this.producto = producto;
    }

    public String getNumeroIdentificacion()
    {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion)
    {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(String cantidad)
    {
        this.cantidad = cantidad;
    }
    
    
}
