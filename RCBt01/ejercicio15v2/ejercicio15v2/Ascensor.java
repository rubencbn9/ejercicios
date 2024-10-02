package ejercicio15v2;

public class Ascensor implements Domotica {
    private int planta;
    private final static int MIN = 0;
    private final static int MAX = 8;
    private final static int INIT=0;

    public Ascensor(){
        this.planta=INIT;
    }


    @Override
    public Boolean Subir() {
        if((planta+1) >MAX){
            return false;
        } planta++;
        return true;
    }
    @Override
    public Boolean Bajar() {
        if((planta-1)<MIN){
            return false;
        } planta--;
        return true;
    }
    @Override
    public void reset() {
        
        
    }
    @Override
    public String verEstado() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
