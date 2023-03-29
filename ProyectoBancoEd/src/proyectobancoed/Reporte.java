package proyectobancoed;

public class Reporte {

    private NodoFila inicioR;
    private NodoFila finR;

    public Reporte() {
        this.inicioR = null;
        this.finR = null;
    }

    public boolean vacia() {
        if (inicioR == null) {
            return true;
        } else {
            return false;
        }
    }
}
