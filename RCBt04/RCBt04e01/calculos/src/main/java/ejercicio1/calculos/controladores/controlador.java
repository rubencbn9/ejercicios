package ejercicio1.calculos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ejercicio1.calculos.servicios.servicio;


@Controller
public class controlador {
    @Autowired 
    private servicio servicio;

    @GetMapping("/")
    public String Home() {

        return "index";
    }
    

    @GetMapping("/calculos/primo")
    public String primo(@RequestParam(required = false) Integer numero, Model model) {
        if(numero == null){
            model.addAttribute("errorPrimo", "tienes que indicar un numero para valoracion");
            return "error";
        }
        model.addAttribute("primo", servicio.primos(numero));
        return "calculo";
    }

    @GetMapping("/calculos/hipotenusa/{numero1}/{numero2}")
    public String getMethodName(@PathVariable Integer numero1,
     @PathVariable Integer numero2, Model model) {
       model.addAttribute("hipotenusa", servicio.hipotenusa(numero1, numero2));
        return "calculo";
    }
    

   @GetMapping("/calculos/divisores/{numero1}")
public String getDivisores(@PathVariable Integer numero1, Model model) {
    model.addAttribute("Divisores", servicio.Divisores(numero1));
    return "calculo";
}
    
    
}
