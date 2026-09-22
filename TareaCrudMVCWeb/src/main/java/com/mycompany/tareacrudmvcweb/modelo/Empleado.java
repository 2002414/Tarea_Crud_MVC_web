/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.modelo;

/**
 *
 * @author yulil
 */
public class Empleado extends Persona{
    private int idEmpleado;
    private int idPuesto;
    private String fechaContratacion;
    
    public Empleado(int idEmpleado, int idPuesto, String nombre, String apellidos, String fechaContratacion){
        super(nombre, apellidos);
        this.idEmpleado = idEmpleado;
        this.idPuesto = idPuesto;
        this.fechaContratacion = fechaContratacion;
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

  
    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

   
    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String getApellidos() {
        return super.getApellidos();
    }
}