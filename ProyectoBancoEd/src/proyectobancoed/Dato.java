package proyectobancoed;

public class Dato {

    private String Nombre;
    private int Cedula;
    private String NumTelefono;
    private int Edad;
    private int id;

    public Dato() {
        this.Nombre = "";
        this.Cedula = 0;
        this.NumTelefono = "";
        this.Edad = 0;
        this.id = 0;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNumTelefono() {
        return NumTelefono;
    }

    public void setNumTelefono(String NumTelefono) {
        this.NumTelefono = NumTelefono;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
