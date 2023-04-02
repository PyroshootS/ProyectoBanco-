package proyectobancoed;

public class NodoFila {

    private Dato datoF;
    private NodoFila SiguienteF;
    
    

    public NodoFila() {
        this.SiguienteF = null;
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





}
