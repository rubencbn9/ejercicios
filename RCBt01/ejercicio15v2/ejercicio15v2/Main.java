package ejercicio15v2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        ArrayList<Domotica> edificio = new ArrayList<>();

        edificio.add(new Termostato());
        edificio.add(new Ascensor());
        edificio.add(new Radio());

        do {

            System.out.println("Seleccione la accion a realizar:");
            System.out.println("0. Salir del programa");
            System.out.println("1. Subir un dispositivo");
            System.out.println("2. Bajar un dispositivo");
            System.out.println("3. resetear un dispositivo");
            System.out.println("4. revisar termostato");
            System.out.println("---------------------------");

            for (Domotica E : edificio) {
                System.out.println(E.verEstado());
            }

            int valor = teclado.nextInt();

            if (valor == 0) {
                break;
            }

            
            System.out.println("Seleccione el dispositivo a utilizar");
            System.out.println("0 Termostato");
            System.out.println("1 Ascensor");
            System.out.println("2 Radio");

            int seleccionDispositivo = teclado.nextInt();
            if (seleccionDispositivo < 0 || seleccionDispositivo >= edificio.size()) {
                System.out.println("valor incorrecto prueba de nuevo");
                continue;
            }

            switch (valor) {
                case 1:
                    if(edificio.get(seleccionDispositivo).Subir()){
                        System.out.println("Valor subido correctamente");
                    }else{
                        System.out.println("El valor esta en el nivel máximo");
                    }
                   
                    break;
                case 2: 
                if(edificio.get(seleccionDispositivo).Bajar()){
                    System.out.println("Valor bajado correctamente");
                }else{
                    System.out.println("El valor esta en el nivel mínimo");
                }
                break;
                case 3:
                edificio.get(seleccionDispositivo).reset();
                System.out.println("Dispositivo reseteado a valor inicial");
                break;
                case 4:
                if(edificio.get(seleccionDispositivo) instanceof Termostato){
                    Termostato termostato = (Termostato) edificio.get(seleccionDispositivo);
                    termostato.Revision();
                }
                break;
                default:
                System.out.println("opcion no valida");
                    break;
            }

        } while (true);
        teclado.close();
    }

}
