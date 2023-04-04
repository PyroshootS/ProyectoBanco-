package proyectobancoed;

import javax.swing.JOptionPane;

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

    public void insertarFila(String Nombre, int Cedula, String NumTel, int Edad, String Direccion, int id) {
        Dato d = new Dato();

        d.setNombre(Nombre);
        d.setCedula(Cedula);
        d.setNumTelefono(NumTel);
        d.setEdad(Edad);
        d.setDireccion(Direccion);
        d.setId(id);
        
        
        NodoFila nuevo = new NodoFila();
        nuevo.setDatoF(d);

        if (vacia()) {
            inicioF = nuevo;
            finF = nuevo;
        } else {
            finF.setSiguienteF(nuevo);
            finF = nuevo;
        }
    }
    
    public void mostrarFila() {
        if (!vacia()) {
            String s = "";
            NodoFila aux = inicioF;
            while (aux != null) {
                s += aux.getDatoF().getNombre() + " // "
                        + aux.getDatoF().getId() + " // "
                        + aux.getDatoF().getCedula() + " // "
                        + aux.getDatoF().getEdad() + " // "
                        + aux.getDatoF().getDireccion() + " // "
                        + aux.getDatoF().getNumTelefono()+ " -> ";
                aux = aux.getSiguienteF();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: " + s, "Contenido",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
