package proyectobancoed;

import javax.swing.JOptionPane;

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

    public void insertarBD(String Nombre, int Cedula, String NumTel, int Edad, String Direccion, int id) {
        Dato d = new Dato();

        d.setNombre(Nombre);
        d.setCedula(Cedula);
        d.setNumTelefono(NumTel);
        d.setEdad(Edad);
        d.setDireccion(Direccion);
        d.setId(id);

        NodoBD nuevo = new NodoBD();
        nuevo.setDatoBd(d);

        if (vacia()) {
            inicioBD = nuevo;
            finBD = nuevo;
            finBD.setSiguienteBd(inicioBD);
            inicioBD.setAnteriorBd(finBD);

        } else if (d.getId() < inicioBD.getDatoBd().getId()) {
            nuevo.setSiguienteBd(inicioBD);
            inicioBD = nuevo;
            finBD.setSiguienteBd(inicioBD);
            inicioBD.setAnteriorBd(finBD);

        } else if (d.getId() > finBD.getDatoBd().getId()) {
            finBD.setSiguienteBd(nuevo);
            finBD = finBD.getSiguienteBd();//fin = nuevo
            finBD.setSiguienteBd(inicioBD);
            inicioBD.setAnteriorBd(finBD);

        } else {
            NodoBD aux = inicioBD;
            while (aux.getSiguienteBd().getDatoBd().getId() < d.getId()) {
                aux = aux.getSiguienteBd();
            }
            nuevo.setSiguienteBd(aux.getSiguienteBd());
            nuevo.setAnteriorBd(aux);
            aux.setSiguienteBd(nuevo);
            nuevo.getSiguienteBd().setAnteriorBd(nuevo);
        }
    }

    public void Eliminar() {
        try {
            int NumCedulaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cedula de la persona que desea eliminar:"));
            if (inicioBD.getDatoBd().getCedula() == NumCedulaEliminar) {
                inicioBD = inicioBD.getSiguienteBd();
                finBD.setSiguienteBd(inicioBD);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                NodoBD anterior;
                NodoBD aux;
                anterior = inicioBD;
                aux = inicioBD.getSiguienteBd();
                while ((aux != inicioBD) && (!aux.getDatoBd().getNombre().equals(NumCedulaEliminar))) {
                    anterior = anterior.getSiguienteBd();
                    aux = aux.getSiguienteBd();
                }
                if (aux != inicioBD) {
                    anterior.setSiguienteBd(aux.getSiguienteBd());
                    finBD.setSiguienteBd(inicioBD);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Probablemente el Numero de Cedula ingresado no existe");
        }
    }

    public void Buscar() {
        NodoBD aux = inicioBD;
        if (!vacia()) {
            int CedulaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cedula que desea buscar:"));

            if (inicioBD.getDatoBd().getCedula() == CedulaBuscar) {
                JOptionPane.showMessageDialog(null, "Nombre " + aux.getDatoBd().getNombre()
                        + " Id " + aux.getDatoBd().getId()
                        + " Cedula " + aux.getDatoBd().getCedula()
                        + " Edad " + aux.getDatoBd().getEdad()
                        + " Direccion " + aux.getDatoBd().getDireccion()
                        + "Numero Telefono" + aux.getDatoBd().getNumTelefono());
            } else {
                aux = aux.getSiguienteBd();
                while (aux != inicioBD) {
                    if (aux.getDatoBd().getCedula() == CedulaBuscar) {
                        JOptionPane.showMessageDialog(null, "Nombre " + aux.getDatoBd().getNombre()
                                + " Id " + aux.getDatoBd().getId()
                                + " Cedula " + aux.getDatoBd().getCedula()
                                + " Edad " + aux.getDatoBd().getEdad()
                                + " Direccion " + aux.getDatoBd().getDireccion()
                                + "Numero Telefono" + aux.getDatoBd().getNumTelefono());
                    } else {
                        aux = aux.getSiguienteBd();
                    }
                }
            }

        }
    }

    public void mostrarBD() {
        if (!vacia()) {
            String s = "";
            NodoBD aux = inicioBD;
            s += aux.getDatoBd().getNombre() + " // "
                    + aux.getDatoBd().getId() + " // "
                    + aux.getDatoBd().getCedula() + " // "
                    + aux.getDatoBd().getEdad() + " // "
                    + aux.getDatoBd().getDireccion() + " // "
                    + aux.getDatoBd().getNumTelefono() + " -> ";
            aux = aux.getSiguienteBd();
            while (aux != inicioBD) {
                s += aux.getDatoBd().getNombre() + " // "
                        + aux.getDatoBd().getId() + " // "
                        + aux.getDatoBd().getCedula() + " // "
                        + aux.getDatoBd().getEdad() + " // "
                        + aux.getDatoBd().getDireccion() + " // "
                        + aux.getDatoBd().getNumTelefono() + " -> ";
                aux = aux.getSiguienteBd();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: " + s, "Contenido",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
