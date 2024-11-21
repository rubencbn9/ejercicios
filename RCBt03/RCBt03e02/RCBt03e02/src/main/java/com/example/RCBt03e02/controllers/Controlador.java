package com.example.ejercicio2_3.controllers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Controlador {
    
    @GetMapping({"/", "/index", "/home"})
    public String showIndex(Model model) {
        model.addAttribute("anhoActual", LocalDate.now().getYear());
        return "indexView";
    }
    
    @GetMapping("/galeria")
    public String showGaleria() {
        return "galeriaView";
    }
    
    
    @GetMapping("/premios")
    public String showPremios(Model model) {
        ArrayList<String> premiosGanados = new ArrayList<>(Arrays.asList("Canadian Screen Award al mejor Drama Internacional: 2015 y 2016",
        "Canadian Screen Award por los mejores Efectos Visuales: 2014, 2015 y 2016"));
        model.addAttribute("premiosGanados", premiosGanados);
        
        ArrayList<String> premiosNominados = new ArrayList<>(Arrays.asList("Canadian Screen Award a la Mejor Dirección en una Serie Dramática: 2014, 2015, 2016"
        ,"Canadian Screen Award a la Mejor Fotografía en un Programa o Serie Dramática: 2014"));
        model.addAttribute("premiosNominados", premiosNominados);
        return "premiosView";
    }
    
    
}
