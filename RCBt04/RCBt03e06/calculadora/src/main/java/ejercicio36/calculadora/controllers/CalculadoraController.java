package ejercicio36.calculadora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CalculadoraController {

    private StringBuilder operando1 = new StringBuilder();
    private StringBuilder operando2 = new StringBuilder();
    private int resultado;
    private CalculadoraEstado estado = CalculadoraEstado.OPERANDO_1;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operando1", operando1.toString());
        model.addAttribute("operando2", operando2.toString());
        model.addAttribute("resultado", estado == CalculadoraEstado.RESULTADO ? resultado : "");
        model.addAttribute("estado", estado.name());
        return "indexView";
    }

    @GetMapping("/digito/{num}")
    public String agregarDigito(@PathVariable("num") int num) {
        if (estado == CalculadoraEstado.OPERANDO_1) {
            operando1.append(num);
        } else if (estado == CalculadoraEstado.OPERANDO_2) {
            operando2.append(num);
        }
        return "redirect:/";
    }

    @GetMapping("/suma")
    public String suma() {
        if (estado == CalculadoraEstado.OPERANDO_1 && operando1.length() > 0) {
            estado = CalculadoraEstado.OPERANDO_2;
        }
        return "redirect:/";
    }

    @GetMapping("/igual")
    public String igual() {
        if (estado == CalculadoraEstado.OPERANDO_2 && operando2.length() > 0) {
            int op1 = Integer.parseInt(operando1.toString());
            int op2 = Integer.parseInt(operando2.toString());
            resultado = op1 + op2;
            estado = CalculadoraEstado.RESULTADO;
        }
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        operando1.setLength(0);
        operando2.setLength(0);
        resultado = 0;
        estado = CalculadoraEstado.OPERANDO_1;
        return "redirect:/";
    }
}
