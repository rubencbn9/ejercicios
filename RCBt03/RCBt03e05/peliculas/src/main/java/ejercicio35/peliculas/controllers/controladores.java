package ejercicio35.peliculas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class controladores {

    private int[]votos ={0,0,0};
    
   @GetMapping("/")
   public String cantidadMg(Model model) {
    model.addAttribute("votos",votos);
       return "indexView";
   }
   
   @GetMapping("/voto")
   public String añadir(@RequestParam("foto")int foto, Model model) {
        if(foto>=0 && foto< votos.length){
            votos[foto]++;
        }
        model.addAttribute("votos",votos);
       return "indexView";
   }
   
    

}
