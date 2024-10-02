import java.util.Scanner;
import java.util.TreeMap;

public class Letras {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la cadena de caracteres a comprobar: ");
        String cadena = teclado.nextLine();
        int cantVecesLetraActual;
        TreeMap<Character, Integer> comprobar = new TreeMap<>();

        for (int i = 0; i <= cadena.length()-1; i++) {
            char letraActual = cadena.charAt(i);
            cantVecesLetraActual = comprobar.getOrDefault(letraActual, 0) + 1;
            comprobar.put(letraActual, cantVecesLetraActual);
        }

        System.out.println(comprobar);

    }
}