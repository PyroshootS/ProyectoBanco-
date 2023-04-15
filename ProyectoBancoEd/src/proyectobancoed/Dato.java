package proyectobancoed;

public class Dato {

    private String Nombre;
    private int Cedula;
    private String NumTelefono;
    private int Edad;
    private int id;
    private String Direccion;
    private String Estado;

    public Dato() {
        this.Nombre = "";
        this.Cedula = 0;
        this.NumTelefono = "";
        this.Edad = 0;
        this.id = 0;
        this.Direccion = "";
        this.Estado = "";
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
