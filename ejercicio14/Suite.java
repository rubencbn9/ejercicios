import java.time.LocalDate;

public class Suite extends Habitacion{
    private static final double precioDia = 200.0;

    public Suite(int numero){
        super(numero);
    }

    @Override
    public double calcularTarifa(int diasEstancia, LocalDate fechaCheckOut) {
       double precio = precioDia *diasEstancia;
       if(diasEstancia>=10){
        precio = precio-((precio*20)/100);
       }
       return precio;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "Suite "+super.toString();
    }

}
