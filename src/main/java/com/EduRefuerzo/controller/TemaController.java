package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Tema;
import com.EduRefuerzo.service.MateriaService;
import com.EduRefuerzo.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaService temaService;
    
    @Autowired
    private MateriaService materiaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var temas = temaService.getTemas(false);
        model.addAttribute("temas", temas);
        return "/tema/listado";
    }

    @GetMapping("/nuevo")
    public String temaNuevo(Tema tema, Model model) {
        var materias = materiaService.getMaterias(true); // Solo materias activas
        model.addAttribute("materias", materias);
        return "/tema/modifica";
    }

    @PostMapping("/guardar")
    public String temaGuardar(Tema tema) {
        temaService.save(tema);
        return "redirect:/tema/listado";
    }

    @GetMapping("/eliminar/{idTema}")
    public String temaEliminar(Tema tema) {
        temaService.delete(tema);
        return "redirect:/tema/listado";
    }

    @GetMapping("/modificar/{idTema}")
    public String temaModificar(Tema tema, Model model) {
        tema = temaService.getTema(tema);
        var materias = materiaService.getMaterias(true);
        model.addAttribute("tema", tema);
        model.addAttribute("materias", materias);
        return "/tema/modifica";
    }
}