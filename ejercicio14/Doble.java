import java.time.LocalDate;
import java.time.Month;

public class Doble extends Habitacion {
    
     public Doble(int numero){
      super(numero);
     }

     private static final double precioDia=100.0;

     @Override
     public double calcularTarifa(int diasEstancia, LocalDate fechaCheckOut) {
         // TODO Auto-generated method stub
         double precio =precioDia * diasEstancia;
         Month mes = fechaCheckOut.getMonth();
         if (mes == Month.APRIL || mes == Month.JULY || mes == Month.AUGUST){
            precio *= 1.2;
         }
         return precio;
     }

     @Override
     public String toString() {
         // TODO Auto-generated method stub
         return "Doble "+ super.toString();
     }

     



}
