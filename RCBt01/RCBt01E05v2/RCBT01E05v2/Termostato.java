package RCBT01E05v2;
import java.time.LocalDate;

public class Termostato implements Domotica{
    private final static int valorMinimo=15;
    private final static int valorMaximo=80;
    private final static int valorInicial=20;
    public int temperatura;
    public LocalDate revision;

    public Termostato(){
        this.temperatura=valorInicial;
    }

    @Override
    public Boolean Subir() {
        if(temperatura<valorMaximo){
            temperatura++;
            return true;
        }return false;
        
    }
    @Override
    public Boolean Bajar() {
        if(temperatura > valorMinimo){
            temperatura--;
            return true;
        }return false;
    }
    @Override
    public void reset() {
        temperatura=valorInicial;
        
    }
    @Override
    public String verEstado() {
       return "El termostato tiene una temperatura de "+temperatura +" ºC";
    }

    public void Revision(){
        revision=LocalDate.now();
    }
    
}
