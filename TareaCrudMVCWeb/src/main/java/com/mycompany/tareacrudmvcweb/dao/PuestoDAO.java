/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.dao;

import com.mycompany.tareacrudmvcweb.config.ConexionDB;
import com.mycompany.tareacrudmvcweb.modelo.Puesto;
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
public class PuestoDAO implements CrudDAO<Puesto> {

    @Override
    public boolean insertar(Puesto objeto) {
        String sqlId = "SELECT COALESCE(MAX(idPuesto), 0) + 1 AS siguienteId FROM puestos";

        String sql = "INSERT INTO puestos (idPuesto, nombre, salarioBase) VALUES (?, ?, ?)";

        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement psId = conn.prepareStatement(sqlId);
            ResultSet rs = psId.executeQuery();
            int siguienteId = 1;
            if (rs.next()) {
                siguienteId = rs.getInt("siguienteId");
            }

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, siguienteId);
            ps.setString(2, objeto.getNombre());
            ps.setFloat(3, objeto.getSalarioBase());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al momento de insertar un puesto");
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Puesto objeto) {
        String sql = "UPDATE puestos SET nombre = ?, salarioBase = ? WHERE idPuesto = ?";
        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, objeto.getNombre());
            ps.setFloat(2, objeto.getSalarioBase());
            ps.setInt(3, objeto.getIdPuesto());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al momento de actualizar el puesto");
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM puestos WHERE idPuesto = ?";
        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al momento de eliminar un puesto");
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Puesto buscarPorId(int id) {
        String sql = "SELECT idPuesto, nombre, salarioBase FROM puestos WHERE idPuesto = ?";
        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearPuesto(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar por Id a un puesto");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Puesto> ListarTodos() {
        List<Puesto> puestos = new ArrayList<>();
        String sql = "SELECT idPuesto, nombre, salarioBase FROM puestos";
        try {
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                puestos.add(mapearPuesto(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar los puestos");
            System.err.println(e.getMessage());
        }
        return puestos;
    }

    private Puesto mapearPuesto(ResultSet rs) throws SQLException {
        return new Puesto(
                rs.getInt("idPuesto"),
                rs.getString("nombre"),
                rs.getFloat("salarioBase")
        );
    }
    
}
