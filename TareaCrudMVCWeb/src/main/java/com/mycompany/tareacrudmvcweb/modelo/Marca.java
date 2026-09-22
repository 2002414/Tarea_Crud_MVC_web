/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public class Marca {
    private int idMarca;
    private String nombre;
    
    public Marca(int idMarca, String nombre){
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    public int getIdMarca(){
        return idMarca; 
    }
    public String getNombre(){
        return nombre; 
    }
}
