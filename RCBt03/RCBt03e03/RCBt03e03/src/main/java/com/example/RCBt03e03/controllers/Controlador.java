package com.example.RCBt03e03.controllers;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controlador {
    
   

    // @GetMapping({"/", "/index"})
    // public String getMethodName(@RequestParam(required = false) String usuario, Model model) {
    //     return "indexView";
    // }
    

    // @GetMapping({"/", "/index"})
    // public String getMethodName(@RequestParam(required = false) String usuario, Model model) {
    //     if (usuario != null && !usuario.isEmpty()) {
    //         model.addAttribute("mensaje", "Bienvenido " + usuario + " a nuestra web");
    //     } else {
    //         model.addAttribute("mensaje", "Bienvenido a nuestra web");
    //     }
    //     return "indexView";
    // }

    @GetMapping({"/", "/index"})
public String getMethodName(@RequestParam Optional<String> usuario, Model model) {
    String mensaje = usuario
            .map(u -> "Bienvenido " + u + " a nuestra web")
            .orElse("Bienvenido a nuestra web");
    model.addAttribute("mensaje", mensaje);
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
