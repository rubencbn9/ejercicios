package com.example.ejercicio2_3.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Controlador {
    
    @GetMapping({"/", "/index", "/home"})
    public String showIndex(Model model) {
        return "indexView";
    }
    
    @GetMapping("/galeria")
    public String showGaleria() {
        return "galeriaView";
    }
    
    
    @GetMapping("/premios")
    public String showPremios() {
        return "premiosView";
    }
    
    
}
