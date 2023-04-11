package proyectobancoed;

public class NodoReporte {

    private Dato datoR;
    private NodoReporte SiguienteR;

    public NodoReporte() {
        this.SiguienteR = null;
    }

    public Dato getDatoR() {
        return datoR;
    }

    public void setDatoR(Dato datoR) {
        this.datoR = datoR;
    }

    public NodoReporte getSiguienteR() {
        return SiguienteR;
    }

    public void setSiguienteR(NodoReporte SiguienteR) {
        this.SiguienteR = SiguienteR;
    }

}
