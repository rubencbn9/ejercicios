import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        ArrayList<Persona> personas = new ArrayList<>();
        

        while (personas.size()<6) {
            Persona nuevaPersona = teclado();
            personas.add(nuevaPersona);
            
        }

        
        System.out.println("Escoge la opcion");
        System.out.println("------------------");
        System.out.println("1-Edad del mayor");
        System.out.println("2-edad media");
        System.out.println("3-Nombre del mayor");
        System.out.println("4-Datos del mayor");
        System.out.println("5-datos de mayores de edad");
        System.out.println("6-edad mayor o igual a la media");
        System.out.println("0-acabar programa");
        Scanner teclado = new Scanner(System.in);
        int seleccion = teclado.nextInt();

        switch (seleccion) {
            case 1:
                System.out.println(obtenerMayor(personas));
            case 2: 
            System.out.println(edadMedia(personas));   
            
            case 3: 
            System.out.println(nombreMayor(personas));
                
            case 4:
            System.out.println(personaMayor(personas));
                
            case 5:
            System.out.println(listaMayores(personas));
               
            case 6:
            System.out.println(listaMedia(personas));
            
            case 0:
                break;
        
            default:
                System.out.println("Numero no encontrado ");
                break;
        }


       
            

    } 

    public static Persona teclado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un dni para la persona: ");
        String dni= sc.nextLine();
        System.out.println("Escribe un nombre para la persona: ");
        String nombre= sc.nextLine();
        System.out.println("Escribe una edad para la persona: ");
        double edad=sc.nextDouble();

        return new Persona(dni, nombre, edad);

    }

    public static int obtenerMayor(ArrayList<Persona> personas){
        double edadMaxima = personas.get(0).getEdad();
        int guardarPosicion=0;
        double posicionActual= 0;
        for(Persona p: personas){
            if(p.getEdad()>edadMaxima){
                edadMaxima = p.getEdad();
                guardarPosicion = (int)posicionActual;
            }
            posicionActual++;
        }
        return (int) personas.get(guardarPosicion).getEdad();
    }

    public static double edadMedia(ArrayList<Persona> personas){
        int contador= 0;
        int numeroPersonas=0;
        for (Persona p : personas){
            contador+= p.getEdad();
            numeroPersonas++;
        }
        if (numeroPersonas == 0){
            return 0;
        }
        double resultado = (double) contador /numeroPersonas;
        return resultado;
    }

     public static String nombreMayor(ArrayList<Persona> personas){
        int posicionMayor= obtenerMayor(personas);
        return  personas.get(posicionMayor).getNombre();
       
    }

    public static Persona personaMayor(ArrayList<Persona> personas){
        int posicionMayor = obtenerMayor(personas);
        return personas.get(posicionMayor);
    }

    public static ArrayList<Persona> listaMayores(ArrayList<Persona> personas){
       ArrayList<Persona> mayores = new ArrayList<>();

       for(Persona persona : personas){
        if(persona.getEdad() > 18){
            mayores.add(persona);
        }
       }
       return mayores;
    }
    

    public static ArrayList<Persona> listaMedia(ArrayList<Persona> personas){
        double edadMedia= edadMedia(personas);

        ArrayList<Persona> media = new ArrayList<>();
        for(Persona persona: personas){
            if(persona.getEdad()>= edadMedia){
                media.add(persona);
            }
        }
        return media;

    }


}