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

    public void insertarBD(String Nombre, int Cedula, String NumTel, int Edad, String Direccion, int id, String Estado) {
        Dato d = new Dato();

        d.setNombre(Nombre);
        d.setCedula(Cedula);
        d.setNumTelefono(NumTel);
        d.setEdad(Edad);
        d.setDireccion(Direccion);
        d.setId(id);
        d.setEstado(Estado);

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

    public void Eliminar(Reporte R) {
        try {
            int NumCedulaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de cédula de la persona que desea eliminar:"));

            if (inicioBD.getDatoBd().getCedula() == NumCedulaEliminar) {
                inicioBD = inicioBD.getSiguienteBd();
                finBD.setSiguienteBd(inicioBD);
                R.EliminadoEstado(NumCedulaEliminar);
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
                    R.EliminadoEstado(NumCedulaEliminar);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Probablemente el número de Cédula ingresado no existe");
        }
    }

    public void Buscar() {
        NodoBD aux = inicioBD;
        if (!vacia()) {
            int CedulaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de cédula que desea buscar:"));

            if (inicioBD.getDatoBd().getCedula() == CedulaBuscar) {
                JOptionPane.showMessageDialog(null, " Nombre: " + aux.getDatoBd().getNombre()
                        + ", Id: " + aux.getDatoBd().getId()
                        + ", Cédula: " + aux.getDatoBd().getCedula()
                        + ", Edad: " + aux.getDatoBd().getEdad()
                        + ", Dirección: " + aux.getDatoBd().getDireccion()
                        + ", Número de Teléfono: " + aux.getDatoBd().getNumTelefono());
            } else {
                aux = aux.getSiguienteBd();
                while (aux != inicioBD) {
                    if (aux.getDatoBd().getCedula() == CedulaBuscar) {
                        JOptionPane.showMessageDialog(null, "Nombre: " + aux.getDatoBd().getNombre()
                                + ", Id: " + aux.getDatoBd().getId()
                                + ", Cédula: " + aux.getDatoBd().getCedula()
                                + ", Edad: " + aux.getDatoBd().getEdad()
                                + ", Dirección: " + aux.getDatoBd().getDireccion()
                                + ", Número de Teléfono: " + aux.getDatoBd().getNumTelefono());
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
            s += "Nombre: " + aux.getDatoBd().getNombre() + "\n"
                    + "ID: " + aux.getDatoBd().getId() + "\n"
                    + "Cédula: " + aux.getDatoBd().getCedula() + " \n"
                    + "Edad: " + aux.getDatoBd().getEdad() + " \n"
                    + "Dirección: " + aux.getDatoBd().getDireccion() + " \n"
                    + "Teléfono: " + aux.getDatoBd().getNumTelefono() + " \n"
                    + "\n";
            aux = aux.getSiguienteBd();
            while (aux != inicioBD) {
                s += "Nombre: " + aux.getDatoBd().getNombre() + " \n "
                        + "ID: " + aux.getDatoBd().getId() + " \n "
                        + "Cédula: " + aux.getDatoBd().getCedula() + " \n "
                        + "Edad: " + aux.getDatoBd().getEdad() + " \n "
                        + "Dirección: " + aux.getDatoBd().getDireccion() + " \n "
                        + "Teléfono: " + aux.getDatoBd().getNumTelefono() + " \n "
                        + "\n ";
                aux = aux.getSiguienteBd();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s, "Contenido de Base de Datos",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error, No se puede mostrar", "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarBD(Reporte R) {
        try {
            int idRegistro = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un ID ya registrado que desea editar:"));
            NodoBD aux = inicioBD;
            boolean encontrado = false;
            do {
                if (aux.getDatoBd().getId() == idRegistro) {
                    encontrado = true;
                    R.EditadoEstado(idRegistro);
                    break;
                }
                aux = aux.getSiguienteBd();
            } while (aux != inicioBD);

            if (encontrado) {
                String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre ingresado anteriormente:");
                int nuevaCedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva cédula ingresada anteriormente:"));
                String nuevoNumTel = JOptionPane.showInputDialog(null, "Ingrese el nuevo número de teléfono ingresado anteriormente:");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva edad ingresada anteriormente:"));
                String nuevaDireccion = JOptionPane.showInputDialog(null, "Ingrese la nueva dirección ingresada anteriormente:");

                aux.getDatoBd().setNombre(nuevoNombre);
                aux.getDatoBd().setCedula(nuevaCedula);
                aux.getDatoBd().setNumTelefono(nuevoNumTel);
                aux.getDatoBd().setEdad(nuevaEdad);
                aux.getDatoBd().setDireccion(nuevaDireccion);

                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente.");
            } else {
                throw new Exception("El registro con ID " + idRegistro + " no existe.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar el registro:\n" + e.getMessage());
        }

    }

}
