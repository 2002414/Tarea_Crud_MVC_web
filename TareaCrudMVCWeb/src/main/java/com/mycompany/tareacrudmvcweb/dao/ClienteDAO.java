/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.dao;

import com.mycompany.tareacrudmvcweb.config.ConexionDB;
import com.mycompany.tareacrudmvcweb.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yulil
 */
public class ClienteDAO  implements CrudDAO<Cliente>{

      @Override
    public boolean insertar(Cliente objeto) {
        String sql = "INSERT INTO CLIENTES (nit, nombre, apellidos, email) values (?,?,?,?)";
    try{
        Connection conn = ConexionDB.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,objeto.getNit());
        ps.setString(2,objeto.getNombre());
        ps.setString(3,objeto.getApellidos());
        ps.setString(4,objeto.getEmail());
        
        ps.executeUpdate();
        return true;
        
    }catch(SQLException e){
        System.err.println("Error al momento de insertar un cliente");
        return false;
    }
    }

    @Override
    public boolean actualizar(Cliente objeto) {
       String sql = "UPDATE clientes SET nit = ?, nombre = ?, apellidos = ?, email = ? WHERE idCliente = ?";
    try{
        Connection conn = ConexionDB.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,objeto.getNit());
        ps.setString(2,objeto.getNombre());
        ps.setString(3,objeto.getApellidos());
        ps.setString(4,objeto.getEmail());
        ps.setInt(5,objeto.getIdCliente());
        ps.executeUpdate();
        return true;
        
    }catch(SQLException e){
        System.err.println("Error al momento de actualizar el cliente");
        return false;
    }
    }

    @Override
    public boolean eliminar(int id) {
       String sql = "DELETE FROM clientes WHERE idCliente = ?";
    try{
        Connection conn = ConexionDB.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        return true;
        
    }catch(SQLException e){
        System.err.println("Error al momento de eliminar un cliente");
        return false;
    }
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT idCliente, nit, nombre, apellidos, email FROM clientes WHERE idCliente = ?";
    try{
        Connection conn = ConexionDB.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return mapearCliente(rs);
        
    }catch(SQLException e){
        System.err.println("Error al buscar por Id a un cliente");

    }
    return null;
    }
  

    @Override
    public List<Cliente> ListarTodos() {
        List<Cliente> clientes = new ArrayList<>();
       String sql = "SELECT idCliente, nit, nombre, apellidos, email FROM clientes";
    try{
        Connection conn = ConexionDB.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
            clientes.add (mapearCliente(rs));
        
    }catch(SQLException e){
        System.err.println("Error al buscar un cliente");
    }
    return clientes;
    }
    private Cliente mapearCliente(ResultSet rs) throws SQLException{
        return new Cliente(
            rs.getInt("idCliente"),
            rs.getString("nit"),
            rs.getString("nombre"),
            rs.getString("apellidos"),
            rs.getString("email")
            
        );
    }
    
}
