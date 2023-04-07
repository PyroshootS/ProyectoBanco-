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

    public void insertarReporte(String Nombre, int Cedula, String NumTel, int Edad, String Direccion, int id) {
        Dato d = new Dato();

        d.setNombre(Nombre);
        d.setCedula(Cedula);
        d.setNumTelefono(NumTel);
        d.setEdad(Edad);
        d.setDireccion(Direccion);
        d.setId(id);

        NodoReporte nuevo = new NodoReporte();
        nuevo.setDatoR(d);

        if (vacia()) {
            inicioR = nuevo;
        } else if (d.getId() < inicioR.getDatoR().getId()) {
            nuevo.setSiguienteR(inicioR);
            inicioR = nuevo;
        } else if (inicioR.getSiguienteR() == null) {
            inicioR.setSiguienteR(nuevo);
        } else {
            NodoReporte aux = inicioR;
            while (aux.getSiguienteR() != null
                    && aux.getSiguienteR().getDatoR().getId() < d.getId()) {
                aux = aux.getSiguienteR();
            }
            nuevo.setSiguienteR(aux.getSiguienteR());
            aux.setSiguienteR(nuevo);
        }
    }

    public void mostrarReporte() {
        if (!vacia()) {
            String s = "";
            NodoReporte aux = inicioR;
            while (aux != null) {
                s += "Nombre: "+aux.getDatoR().getNombre() + " \n "
                        + "ID: "+aux.getDatoR().getId() + " \n "
                        + "Cédula: "+aux.getDatoR().getCedula() + " \n "
                        + "Edad: "+ aux.getDatoR().getEdad() + " \n "
                        + "Dirección: "+aux.getDatoR().getDireccion() + " \n"
                        + "Teléfono: "+aux.getDatoR().getNumTelefono() + " \n ";
                aux = aux.getSiguienteR();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s, "Contenido de Reporte",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
