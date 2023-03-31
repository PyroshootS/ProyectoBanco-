package proyectobancoed;

public class NodoFila {

    private Dato datoF;
    private NodoFila SiguienteF;
    private NodoFila anteriorF;

    public NodoFila() {
        this.SiguienteF = null;
        this.anteriorF = null;
    }

    public Dato getDatoF() {
        return datoF;
    }

    public void setDatoF(Dato datoF) {
        this.datoF = datoF;
    }

    public NodoFila getSiguienteF() {
        return SiguienteF;
    }

    public void setSiguienteF(NodoFila Siguiente) {
        this.SiguienteF = Siguiente;
    }

    public NodoFila getAnteriorF() {
        return anteriorF;
    }

    public void setAnteriorF(NodoFila anteriorF) {
        this.anteriorF = anteriorF;
    }





}
