package ejercicio15v2;

public class Radio implements Domotica {


    private double canal;
    private final static double INICIAL=88.0;
    private final static double MAXIMO=104.0;
    private final static double MINIMO = 88.0;

    public Radio(){
        this.canal=INICIAL;
    }

    @Override
    public Boolean Bajar() {
       if(canal>MINIMO){
        canal-=0.5 ;
        return true;
       }return false;
    }

    @Override
    public Boolean Subir() {
        if(canal<MAXIMO){
            canal+=0.5 ;
            return true;
           }return false;
        }
    

    @Override
    public void reset() {
        canal = INICIAL;
    }

    @Override
    public String verEstado() {
      return "El canal actual de la radio es "+ canal ;
    }
    

    
}
