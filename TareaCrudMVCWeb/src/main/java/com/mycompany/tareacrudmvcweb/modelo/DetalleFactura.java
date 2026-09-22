/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public class DetalleFactura {
    private int idDetalle;
    private int idFactura;
    private int idProducto;
    private int cantidad;
    private float precioUnitario;
    private float subtotal;

    public DetalleFactura(int idDetalle, int idFactura, int idProducto, int cantidad, float precioUnitario, float subtotal) {
        this.idDetalle = idDetalle;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() { return idDetalle; }
    public int getIdFactura() { return idFactura; }
    public int getIdProducto() { return idProducto; }
    public int getCantidad() { return cantidad; }
    public float getPrecioUnitario() { return precioUnitario; }
    public float getSubtotal() { return subtotal; }
}
