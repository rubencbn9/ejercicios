package ejercicio15;

import java.time.LocalDate;

public class Termostato extends Elementos {
    int valorMaximo = 80;
    int valorMinimo = 15;
    int valorInicial = 20;

    public Termostato() {
        super(20, 80, 15, 15, "Termostato");
    }

    public LocalDate Revision(){
        LocalDate fechaRevision = LocalDate.now();
        return fechaRevision;
    }

}
