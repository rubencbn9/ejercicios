import java.util.Scanner;
import java.util.TreeSet;

public class Primitiva implements Comparable<Primitiva> {

    private static TreeSet<Integer> premio;

    public Primitiva() {
        premio = new TreeSet<>();
        completo();
    }

    public int generadorNumero() {
        return (int) (Math.random() * 49 + 1);
    }

    @Override
    public int compareTo(Primitiva otra) {
        // Comparar de menor a mayor por el valor de numero
        return Integer.compare(this.premio.size(), otra.premio.size());
    }

    @Override
    public String toString() {
        return premio.toString();
    }

    public void completo() {
        while (premio.size() < 6) {
            int numeroGenerado = generadorNumero();
            premio.add(numeroGenerado);
        }
    }


   public static int contarAciertos(TreeSet<Integer> combinacion){
    int aciertos = 0;

    for(int numero: combinacion){
        if(premio.contains(numero)){
            aciertos ++;
        }
    }
    return aciertos;
   }


   public static void ingresarCombinacion(){
    Scanner sc = new Scanner(System.in);

    TreeSet<Integer> combinacionUsuario = new TreeSet<>();

    System.out.println("Introduce una combinacion de 6 numeros sin repetir(del 1 al 49): ");
    while(combinacionUsuario.size()<6){
        try {
            int numero = sc.nextInt();
            if(numero <1 || numero > 49){
                System.out.println("El numero debe estar entre 1 y 49");;
            }else if(combinacionUsuario.contains(numero)){
                System.out.println("el numero esta repetido intenta otro");
            }
            combinacionUsuario.add(numero);
        } catch (Exception e) {
            System.out.println("Entrada no valida. Introduce un número entero: ");
            sc.next();
        }
    }
    int aciertos = contarAciertos(combinacionUsuario);
    System.out.println("El numero de aciertos es: "+aciertos);
   }

public static void main(String[] args) {
    Primitiva nueva = new Primitiva();
    ingresarCombinacion();
    System.out.println(premio);
}

}