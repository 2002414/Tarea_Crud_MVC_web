/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public class Producto {
    private int idProducto;
    private int idMarca;
    private String nombre;
    private float precio;
    private int stock;

    public Producto(int idProducto, int idMarca, String nombre, float precio, int stock) {
        this.idProducto = idProducto;
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdProducto() { 
        return idProducto; 
    }
    public int getIdMarca() { 
        return idMarca; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public float getPrecio() { 
        return precio; 
    }
    public int getStock() { 
        return stock; 
    }
}
