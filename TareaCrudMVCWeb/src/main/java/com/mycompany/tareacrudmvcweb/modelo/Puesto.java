/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public class Puesto {
    private int idPuesto;
    private String nombre;
    private float salarioBase;

    public Puesto(int idPuesto, String nombre, float salarioBase) {
        this.idPuesto = idPuesto;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

     public int getIdPuesto() {
        return idPuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

   
    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }
}
