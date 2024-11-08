import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Persona> personas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        while (personas.size() < 6) {
            Persona nuevaPersona = teclado(teclado);
            personas.add(nuevaPersona);
        }

        int seleccion;
        do {
            System.out.println("Escoge la opcion");
            System.out.println("------------------");
            System.out.println("1-Edad del mayor");
            System.out.println("2-Edad media");
            System.out.println("3-Nombre del mayor");
            System.out.println("4-Datos del mayor");
            System.out.println("5-Datos de mayores de edad");
            System.out.println("6-Personas con edad mayor o igual a la media");
            System.out.println("0-Acabar programa");

            seleccion = teclado.nextInt();

            switch (seleccion) {
                case 1:
                    int posicionMayor = obtenerMayor(personas);
                    System.out.println("La edad del mayor es: " + personas.get(posicionMayor).getEdad());
                    break;
                case 2:
                    System.out.println("La edad media es: " + edadMedia(personas));
                    break;
                case 3:
                    posicionMayor = obtenerMayor(personas);
                    System.out.println("El nombre del mayor es: " + personas.get(posicionMayor).getNombre());
                    break;
                case 4:
                    posicionMayor = obtenerMayor(personas);
                    System.out.println("Los datos de la persona mayor son: " + personaMayor(personas));
                    break;
                case 5:
                    System.out.println("Las personas mayores de edad son: ");
                    imprimirListaPersonas(listaMayores(personas));
                    break;
                case 6:
                    System.out.println("Las personas con edad mayor o igual a la media son: ");
                    imprimirListaPersonas(listaMedia(personas));
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Número no encontrado");
            }

        } while (seleccion != 0);

        teclado.close();
    }

    public static Persona teclado(Scanner sc) {
        System.out.println("Escribe un DNI para la persona: ");
        String dni = sc.next();
        System.out.println("Escribe un nombre para la persona: ");
        String nombre = sc.next();
        System.out.println("Escribe una edad para la persona: ");
        double edad = sc.nextDouble();

        return new Persona(dni, nombre, edad);
    }

    public static int obtenerMayor(ArrayList<Persona> personas) {
        int guardarPosicion = 0;
        double edadMaxima = personas.get(0).getEdad();

        for (int i = 1; i < personas.size(); i++) {
            if (personas.get(i).getEdad() > edadMaxima) {
                edadMaxima = personas.get(i).getEdad();
                guardarPosicion = i;
            }
        }
        return guardarPosicion;  // Devolver la posición del mayor
    }

    public static double edadMedia(ArrayList<Persona> personas) {
        double contador = 0;
        for (Persona p : personas) {
            contador += p.getEdad();
        }
        return contador / personas.size();
    }

    public static String nombreMayor(ArrayList<Persona> personas) {
        int posicionMayor = obtenerMayor(personas);
        return personas.get(posicionMayor).getNombre();
    }

    public static Persona personaMayor(ArrayList<Persona> personas) {
        int posicionMayor = obtenerMayor(personas);
        return personas.get(posicionMayor);
    }

    public static ArrayList<Persona> listaMayores(ArrayList<Persona> personas) {
        ArrayList<Persona> mayores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getEdad() >= 18) {
                mayores.add(persona);
            }
        }
        return mayores;
    }

    public static ArrayList<Persona> listaMedia(ArrayList<Persona> personas) {
        double edadMedia = edadMedia(personas);
        ArrayList<Persona> media = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getEdad() >= edadMedia) {
                media.add(persona);
            }
        }
        return media;
    }

    public static void imprimirListaPersonas(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            System.out.println("No hay personas en esta lista.");
        } else {
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }
}
