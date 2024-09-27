import java.time.LocalDate;

public abstract class Habitacion {
    protected int numero;
    protected boolean ocupada;
    protected LocalDate fechaCheckIn;

    public Habitacion(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public abstract double calcularTarifa(int diasEstancia, LocalDate fechaCheckOut);

    public void checkIn() {
        this.ocupada = true;
        this.fechaCheckIn = LocalDate.now();
    }

    public void CheckOut(){
      this.ocupada= false;
    }

    public boolean isOcupada(){
      return ocupada;
    }

    @Override
    public String toString() {
        return "Habitación "+ numero + "(ocupada: " + ocupada +")" ;
      }

    public int getNumero(){
      return numero;
    }


    public LocalDate getFechaCheckin(){
      return fechaCheckIn;
    }
  }