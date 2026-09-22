/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public abstract class Persona {
    protected String nombre;
    protected String apellidos;
    
    public Persona(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public String getNombre(){ 
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    
}