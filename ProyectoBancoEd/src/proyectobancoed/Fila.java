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
                s +="Nombre: "+ aux.getDatoF().getNombre() + " \n "
                        + "ID: "+aux.getDatoF().getId() + " \n "
                        + "Cédula: "+aux.getDatoF().getCedula() + " \n "
                        + "Edad: "+aux.getDatoF().getEdad() + " \n "
                        + "Dirección: "+aux.getDatoF().getDireccion() + " \n "
                        + "Teléfono: "+aux.getDatoF().getNumTelefono()+ " \n ";
                aux = aux.getSiguienteF();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s, "Contenido de Usuarios",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

//        public void editarFila() {
//        try {
//            int idRegistro = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un ID ya registrado que desea editar:"));
//            NodoFila aux = inicioF;
//            boolean encontrado = false;
//            do {
//                if (aux.getDatoF().getId() == idRegistro) {
//                    encontrado = true;
//                    break;
//                }
//                aux = aux.getSiguienteF();
//            } while (aux != inicioF);
//
//            if (encontrado) {
//                String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:");
//                int nuevaCedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva cédula:"));
//                String nuevoNumTel = JOptionPane.showInputDialog(null, "Ingrese el nuevo número de teléfono:");
//                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva edad:"));
//                String nuevaDireccion = JOptionPane.showInputDialog(null, "Ingrese la nueva dirección:");
//
//                aux.getDatoF().setNombre(nuevoNombre);
//                aux.getDatoF().setCedula(nuevaCedula);
//                aux.getDatoF().setNumTelefono(nuevoNumTel);
//                aux.getDatoF().setEdad(nuevaEdad);
//                aux.getDatoF().setDireccion(nuevaDireccion);
//
//                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente.");
//            } else {
//                throw new Exception("El registro con ID " + idRegistro + " no existe.");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al editar el registro:\n" + e.getMessage());
//        }
//    }
}
