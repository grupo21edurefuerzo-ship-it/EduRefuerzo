package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Materia;
import com.EduRefuerzo.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var materias = materiaService.getMaterias(false);
        model.addAttribute("materias", materias);
        return "/materia/listado";
    }

    @GetMapping("/nuevo")
    public String materiaNuevo(Materia materia) {
        return "/materia/modifica";
    }

    @PostMapping("/guardar")
    public String materiaGuardar(Materia materia) {
        materiaService.save(materia);
        return "redirect:/materia/listado";
    }

    @GetMapping("/eliminar/{idMateria}")
    public String materiaEliminar(Materia materia) {
        materiaService.delete(materia);
        return "redirect:/materia/listado";
    }

    @GetMapping("/modificar/{idMateria}")
    public String materiaModificar(Materia materia, Model model) {
        materia = materiaService.getMateria(materia);
        model.addAttribute("materia", materia);
        return "/materia/modifica";
    }
}