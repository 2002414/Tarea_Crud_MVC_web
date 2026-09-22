/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.controlador;

import com.mycompany.tareacrudmvcweb.dao.EmpleadoDAO;
import com.mycompany.tareacrudmvcweb.modelo.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author yulil
 */
@Controller
@RequestMapping("/empleados")
public class empleadoControlador {
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoDAO.ListarTodos());
        if (!model.containsAttribute("empleado")) {
            model.addAttribute("empleado", new Empleado());
        }
        return "empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("empleados", empleadoDAO.ListarTodos());
        model.addAttribute("empleado", empleadoDAO.buscarPorId(id));

        return "empleados";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Empleado empleado,
            RedirectAttributes ra) {
        try {
            boolean ok;
            if (empleado.getIdEmpleado() == 0) {
                ok = empleadoDAO.insertar(empleado);
            } else {
                ok = empleadoDAO.actualizar(empleado);
            }
            if (ok) {ra.addFlashAttribute( "mensaje", "Empleado guardado correctamente.");
            } else {
                ra.addFlashAttribute( "error", "No fue posible guardar el empleado.");
            }
        } catch (Exception e) {ra.addFlashAttribute( "error", "Error: " + e.getMessage());
        }
        return "redirect:/empleados";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable int id,
            RedirectAttributes ra) {
        boolean ok = empleadoDAO.eliminar(id);
        if (ok) {
            ra.addFlashAttribute( "mensaje", "Empleado eliminado correctamente.");
        } else {
            ra.addFlashAttribute( "error", "No fue posible eliminar el empleado.");
        }
        return "redirect:/empleados";
    }
}
