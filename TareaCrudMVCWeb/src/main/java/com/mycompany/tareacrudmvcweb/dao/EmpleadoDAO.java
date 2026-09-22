/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.dao;

import com.mycompany.tareacrudmvcweb.config.ConexionDB;
import com.mycompany.tareacrudmvcweb.modelo.Empleado;
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
public class EmpleadoDAO implements CrudDAO<Empleado> {
    
    String sqlId = "SELECT COALESCE(MAX(idEmpleado), 0) + 1 AS siguienteId FROM empleados";

    @Override
    public boolean insertar(Empleado objeto) {
        String sql = "INSERT INTO empleados(idEmpleado, idPuesto, nombre, apellidos, fechaContratacion) values (?,?,?,?,?)";

        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, objeto.getIdEmpleado());
            ps.setInt(2, objeto.getIdPuesto());
            ps.setString(3, objeto.getNombre());
            ps.setString(4, objeto.getApellidos());
            ps.setString(5, objeto.getFechaContratacion());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al momento de insertar un empleado");
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Empleado objeto) {
        String sql = "UPDATE empleados SET, idPuesto = ?,nombre = ?, apellidos = ?, fechaContratacion = ?, WHERE idEmpleado = ?";

        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, objeto.getIdPuesto());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellidos());
            ps.setString(4, objeto.getFechaContratacion());
            ps.setInt(5, objeto.getIdEmpleado());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al momento de actualizar el empleado");
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE idEmpleado = ?";

        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al momento de eliminar un empleado");
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Empleado buscarPorId(int id) {
        String sql = "SELECT idEmpleado, idPuesto, nombre,apellidos, fechaContratacion FROM empleados WHERE idEmpleado = ?";

        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapearEmpleado(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar por Id a un empleado");
            System.err.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Empleado> ListarTodos() {
        List<Empleado> empleados = new ArrayList<>();

        String sql = "SELECT idEmpleado, idPuesto, nombre, apellidos, fechaContratacion FROM empleados";

        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                empleados.add(mapearEmpleado(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar un empleado");
            System.err.println(e.getMessage());
        }

        return empleados;
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getInt("idEmpleado"),
                rs.getInt("idPuesto"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("fechaContratacion")
        );
    }
}