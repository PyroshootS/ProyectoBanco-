package proyectobancoed;

public class NodoFila {

    private Dato datoF;
    private NodoFila SiguienteF;

    public NodoFila() {
        this.SiguienteF = null;
    }

    public Dato getDato() {
        return datoF;
    }

    public void setDato(Dato dato) {
        this.datoF = dato;
    }

    public NodoFila getSiguienteF() {
        return SiguienteF;
    }

    public void setSiguienteF(NodoFila Siguiente) {
        this.SiguienteF = Siguiente;
    }

}
