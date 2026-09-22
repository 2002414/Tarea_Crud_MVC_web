/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.dao;

import java.util.List;

/**
 *
 * @author yulil
 */
public interface CrudDAO <T> {
    boolean insertar(T objeto);
    boolean actualizar(T objeto);
    boolean eliminar(int id);
    T buscarPorId(int id);
    List<T> ListarTodos();
            
}
