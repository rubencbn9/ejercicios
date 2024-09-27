package ejercicio15;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        

        ArrayList<Elementos> domotica = new ArrayList<>();

        domotica.add(new Termostato());
        domotica.add(new Ascensor());
        domotica.add(new Radio());
    
        Scanner sc = new Scanner(System.in);
do{
        System.out.println("Introduce la accion a realizar: ");
        
        System.out.println("Menú:");
        System.out.println("0. Salir");
        System.out.println("1: subir un dispositivo");
        System.out.println("2: bajar un dispositivo");
        System.out.println("3: resetear un dispositivo");
        System.out.println("4:revisar termostato");
        System.out.println("----------------------");
        for(Elementos elemento: domotica){
            System.out.println(elemento.verEstado());
        }
        System.out.println("----------------------");
        int opcion = sc.nextInt();

        if(opcion == 0){
            break;
        }
        

        System.out.println("Introduce el dispositivo( 0: termostato, 1: ascensor, 2: radio)");
        int dispositivoIndex = sc.nextInt();

       if(dispositivoIndex < 0 || dispositivoIndex >= domotica.size()){
        System.out.println("Indice de dispositivo no valido");
        continue;
    }

    switch (opcion) {
        case 1:
            if(domotica.get(dispositivoIndex).Subir(1)){
                System.out.println("Dispositivo subido correctamente");
            }else{
                System.out.println("NO se puede subir mas del máximo");
            }
            break;

            case 2:
            if (domotica.get(dispositivoIndex).Bajar(1)) {
                System.out.println("Dispositivo bajado correctamente.");
            } else {
                System.out.println("No se puede bajar más allá del mínimo.");
            }
            break;

        case 3:
            domotica.get(dispositivoIndex).reset();
            System.out.println("Dispositivo reseteado.");
            break;

        case 4:
            // Revisa el termostato solo si es el índice 0
            if (dispositivoIndex == 0 && domotica.get(dispositivoIndex) instanceof Termostato) {
                ((Termostato) domotica.get(dispositivoIndex)).Revision();
                System.out.println("Fecha de revisión actualizada para el termostato.");
            } else {
                System.out.println("Solo puedes revisar el termostato.");
            }
            break;

        default:
            System.out.println("Opción no válida.");
            break; 
            
    }


    }while(true);
    sc.close();
}

}
