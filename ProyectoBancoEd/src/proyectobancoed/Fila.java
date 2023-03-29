package proyectobancoed;

public class Fila {

    private NodoFila inicioF;
    private NodoFila finF;

    public Fila() {
        this.inicioF = null;
        this.finF = null;
    }

    public boolean vacia() {
        if (inicioF == null) {
            return true;
        } else {
            return false;
        }
    }
}
