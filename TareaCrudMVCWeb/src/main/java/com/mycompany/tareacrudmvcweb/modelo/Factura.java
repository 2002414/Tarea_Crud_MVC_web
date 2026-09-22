/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

import java.util.Date;

/**
 *
 * @author yulil
 */
public class Factura {
    private int idFactura;
    private int idCliente;
    private int idEmpleado;
    private Date fecha;
    private float total;
    
    public Factura(int idFactura, int idCliente, int idEmpleado, Date fecha, float total){
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.total = total;
    }
    public int getIdFactura(){
        return idFactura; 
    }
    public int getIdCliente(){
        return idCliente;
    }
    public int getIdEmpleado(){
        return idEmpleado;
    }
    public Date getFecha(){
        return fecha;
    }
    public float getTotal(){
        return total;
    }
}
