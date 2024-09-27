import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel{

  private ArrayList<Habitacion> habitaciones;

  public Hotel(){
    habitaciones = new ArrayList<>();

    for(int i=0;i<=3;i++){
        habitaciones.add(new LowCost(i));
    }

    for(int i=4; i <= 13; i++){
        habitaciones.add(new Doble(i));
    }

    for(int i=14;i<=18; i++){
        habitaciones.add(new Suite(i));
    }
  }

  public void checkIn() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Habitaciones dsponibles: ");
    listarHabitacionesLibres();

    System.out.println("introduce el numero de la habitacion que quieres ocupar: ");
    int numero = sc.nextInt();

    for(Habitacion habitacion: habitaciones){
        if(habitacion.getNumero() == numero && !habitacion.isOcupada()){
            habitacion.checkIn();
            System.out.println("Habitacion: "+numero+" ocupada con exito.");
            return;
        }
    }
    System.out.println("Número de habitación invalido o la habitación ya está ocupada");

  }

  public void checkOut(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Habitaciones ocupadas: ");
    listarHabitacionesOcupadas();

    System.out.println("Introduce el numero de habitacion que quieres ocupar: ");
    int numero = sc.nextInt();

    for(Habitacion habitacion: habitaciones){
        if(habitacion.getNumero() == numero && habitacion.isOcupada()){
            LocalDate fechaCheckOut = LocalDate.now();
            int diasEstancia = (int) java.time.temporal.ChronoUnit.DAYS.between(habitacion.getFechaCheckin(), fechaCheckOut);
            double importe = habitacion.calcularTarifa(diasEstancia, fechaCheckOut);
            habitacion.CheckOut();
            System.err.println("Habitacion "+ numero+ " liberada. Importe a pagar: "+ importe+ "€");
            return;
        }
    }
    System.out.println("Número de habitación inválido o la habitación ya está libre.");
    }
  



  public void listarHabitacionesLibres(){
    for(Habitacion habitacion: habitaciones){
        if(!habitacion.isOcupada()){
            System.out.println(habitacion);
        }
    }
  }

  public void listarHabitacionesOcupadas(){
    for(Habitacion habitacion: habitaciones){
        if(habitacion.isOcupada()){
            System.out.println(habitacion);
        }
    }
  }

  public static void main(String[] args) {
    Hotel hotel = new Hotel();
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("Menú:");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Listar habitaciones libres");
            System.out.println("4. Listar habitaciones ocupadas");
            System.out.println("5. Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    hotel.checkIn();
                    break;
                case 2:
                    hotel.checkOut();
                    break;
                case 3:
                    hotel.listarHabitacionesLibres();
                    break;
                case 4:
                    hotel.listarHabitacionesOcupadas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
    }
  }
}
}