package ejercicio1.calculos.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class servicio {
    

    public boolean primos(int numero){
        
        if ( numero < 2 ){
            return false;
        }
        for(int i = 2;i<numero;i++){
            int resultado= numero%i;
            if(resultado == 0){
                return false;
            }
        }     
        return true;
    }

    public double hipotenusa(int numero1, int numero2){

        double resultado = Math.sqrt((numero1*numero1)+(numero2*numero2));

        return resultado;
    }


public List<Integer> Divisores(int numero1) {
    if (numero1 <= 0) {
        throw new IllegalArgumentException("El número debe ser mayor que 0");
    }
    List<Integer> lista = new ArrayList<>();
    for (int i = 1; i <= numero1; i++) {
        if (numero1 % i == 0) {
            lista.add(i);
        }
    }
    return lista;
}


}
