package proyectobancoed;

public class NodoBD {

    private Dato datoBd;
    private NodoBD siguienteBd;
    private NodoBD anteriorBd;

    public NodoBD() {
        this.siguienteBd = null;
        this.anteriorBd = null;
    }

    public Dato getDatoBd() {
        return datoBd;
    }

    public void setDatoBd(Dato datoBd) {
        this.datoBd = datoBd;
    }

    public NodoBD getSiguienteBd() {
        return siguienteBd;
    }

    public void setSiguienteBd(NodoBD siguienteBd) {
        this.siguienteBd = siguienteBd;
    }

    public NodoBD getAnteriorBd() {
        return anteriorBd;
    }

    public void setAnteriorBd(NodoBD anteriorBd) {
        this.anteriorBd = anteriorBd;
    }

}
