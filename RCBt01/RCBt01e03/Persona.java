import java.util.Objects;

public class Persona{
    private String DNI;
    private String nombre;
    private double edad;

public Persona (String DNI,String nombre, double edad){
    this.DNI=DNI;
    this.nombre=nombre;
    this.edad=edad;

    
}

@Override
public int hashCode() {
   return Objects.hash(DNI);
}

@Override
public boolean equals(Object obj) {
    if(this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Persona persona = (Persona) obj;
    return Objects.equals(DNI,persona.DNI);
}

@Override
public String toString() {
    return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", edad=" + edad + "]";
}

public String getDNI() {
    return DNI;
}

public void setDNI(String DNI) {
    this.DNI = DNI;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public double getEdad() {
    return edad;
}

public void setEdad(double edad) {
    this.edad = edad;
}

}

