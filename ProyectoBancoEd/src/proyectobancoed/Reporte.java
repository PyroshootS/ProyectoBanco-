package proyectobancoed;

import javax.swing.JOptionPane;

public class Reporte {

    private NodoReporte inicioR;
    private NodoReporte finR;

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
    
    
    
/////////////////////////////////////////////Falta  de Probar en nuestra lista (ya probado en una lista aparte)////////////////////////////////////////////////////////////////////////////////
    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoReporte aux = inicioR;
            while (aux != null) {
                s += aux.getDatoR().getNombre() + " // "
                        + aux.getDatoR().getId() + " // "
                        + aux.getDatoR().getCedula() + " // "
                        + aux.getDatoR().getEdad() + " // "
                        + aux.getDatoR().getDireccion() + " // "
                        + aux.getDatoR().getNumTelefono()+ " -> ";
                aux = aux.getSiguienteR();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: " + s, "Contenido",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
