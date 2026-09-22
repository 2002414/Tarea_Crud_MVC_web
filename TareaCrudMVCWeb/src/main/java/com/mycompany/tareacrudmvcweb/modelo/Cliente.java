/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public class Cliente extends Persona{
    private int idCliente;
    private String nit;
    private String email;
    
    public Cliente(int idCliente, String nit, String nombre, String apellidos, String email ){
        super(nombre, apellidos);
        this.idCliente = idCliente;
        this.nit = nit;
        this.email = email;
    }

    public Cliente() {
        super("", "");
    }
     public int getIdCliente() {
        return idCliente; 
    }

    public String getNit() {
        return nit; 
    }

    public String getEmail() {
        return email; 
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}