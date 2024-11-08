package RCBt01E05;

public abstract class Elementos {
    protected int valorInicial;
    protected int valorMinimo;
    protected int valorMaximo;
    protected int valorActual;
    protected String tipo;

    public Elementos(int valorInicial, int valorMaximo, int valorMinimo, int valorActual, String tipo) {
        this.valorInicial = valorInicial;
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.valorActual = valorActual;
        this.tipo = tipo;
    }

    public boolean Subir(int numeroSubida) {
        boolean respuesta;
        if (valorActual + numeroSubida > valorMaximo) {
            respuesta = false;
        } else {
            valorActual += numeroSubida;
            respuesta = true;
        }
        return respuesta;
    }

    public boolean Bajar(int numeroBajada) {
        boolean respuesta;
        if (valorActual - numeroBajada < valorMinimo) {
            respuesta = false;
        } else {
            valorActual -= numeroBajada;
            respuesta = true;
        }
        return respuesta;
    }

    public void reset() {
        valorActual = valorInicial;
    }

    public String verEstado() {
        return "tipo de dispositivo: " + tipo + " valor actual: " + valorActual;
    }

    @Override
    public String toString() {
        return "Elementos [valorInicial=" + valorInicial + ", valorMinimo=" + valorMinimo + ", valorMaximo="
                + valorMaximo + ", valorActual=" + valorActual + ", tipo=" + tipo + "]";
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}