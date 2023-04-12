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

    public void insertarReporte(String Nombre, int Cedula, String NumTel, int Edad, String Direccion, int id, String Estado) {
        Dato d = new Dato();

        d.setNombre(Nombre);
        d.setCedula(Cedula);
        d.setNumTelefono(NumTel);
        d.setEdad(Edad);
        d.setDireccion(Direccion);
        d.setId(id);
        d.setEstado(Estado);

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
                s += "Nombre: " + aux.getDatoR().getNombre() + " \n "
                        + "ID: " + aux.getDatoR().getId() + " \n "
                        + "Cédula: " + aux.getDatoR().getCedula() + " \n "
                        + "Edad: " + aux.getDatoR().getEdad() + " \n "
                        + "Dirección: " + aux.getDatoR().getDireccion() + " \n"
                        + "Teléfono: " + aux.getDatoR().getNumTelefono() + " \n "
                        + "Estado: " + aux.getDatoR().getEstado() + " \n ";
                aux = aux.getSiguienteR();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s, "Contenido de Reporte",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminadoEstado(int Cedula) {
        if (!vacia()) {
            NodoReporte aux = inicioR;
            while (aux != null) {
                if (aux.getDatoR().getCedula()== Cedula) {
                    aux.getDatoR().setEstado("Eliminado");
                    JOptionPane.showMessageDialog(null, "Por aqui pase");   //prueba
                    aux = aux.getSiguienteR();
                } else {
                    aux = aux.getSiguienteR();
                }
            }
        }
    }
    
     public void EditadoEstado(int Id) {
        if (!vacia()) {
            NodoReporte aux = inicioR;
            while (aux != null) {
                if (aux.getDatoR().getId()== Id) {
                    aux.getDatoR().setEstado("Editado");
                    JOptionPane.showMessageDialog(null, "Por aqui pase");     //prueba
                    aux = aux.getSiguienteR();
                } else {
                    aux = aux.getSiguienteR();
                }
            }
        }
    }

}
