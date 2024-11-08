package tabla.ejerciciotabla.Controllers;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ControladorNumeros {
    
    Random random = new Random();
    public Set<Integer> lista = new LinkedHashSet<>();


    @GetMapping({"/","/indexView"})
    public String showList(Model model) {
        model.addAttribute("cantidadTotal",lista.size());
        model.addAttribute("listaNumeros",lista);
        return "indexView";
    }

    @GetMapping("/new")
    public String numeroNuevo() {
        boolean añadido;
        do{ añadido = lista.add(random.nextInt(100)+1);
        }while(!añadido);
        return "redirect:/indexView";
    }
    
    @GetMapping({"/delete/{id}"})
    public String borrado(@PathVariable Integer id) {
        lista.remove(id);
        return "redirect:/indexView";
    }
    
    
}
