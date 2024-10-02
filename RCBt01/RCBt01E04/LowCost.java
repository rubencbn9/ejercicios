import java.time.LocalDate;

public class LowCost extends Habitacion {

       private static final double PrecioDia = 50.0;

       public LowCost(int numero){
              super(numero);
       }

       @Override
       public double calcularTarifa(int diasEstancia, LocalDate fechaCheckOut) {
            return PrecioDia * diasEstancia;
       }

       @Override
       public String toString() {
           // TODO Auto-generated method stub
           return "LowCost" + super.toString();
       }
    
}
