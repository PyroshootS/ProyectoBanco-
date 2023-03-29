package proyectobancoed;


public class BD {
   private NodoBD inicioBD;
    private NodoBD finBD;

    public BD() {
        this.inicioBD = null;
        this.finBD = null;
    }

    public boolean vacia() {
        if (inicioBD == null) {
            return true;
        } else {
            return false;
        }
    }
}
