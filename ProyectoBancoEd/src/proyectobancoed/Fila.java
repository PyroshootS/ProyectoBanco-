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

    public void insertarFila(String Nombre, int Cedula, String NumTel, int Edad, String Direccion, int id, String Estado) {
        Dato d = new Dato();

        d.setNombre(Nombre);
        d.setCedula(Cedula);
        d.setNumTelefono(NumTel);
        d.setEdad(Edad);
        d.setDireccion(Direccion);
        d.setId(id);
        d.setEstado(Estado);
        
        
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
    
    public void desencolarFila()
    {
        try{
            if(!vacia())
            {
                System.out.println(inicioF.getDatoF().getNombre());
                inicioF=inicioF.getSiguienteF();
                JOptionPane.showMessageDialog(null,
                        "El siguiente cliente a atender es:\n"+inicioF.getDatoF().getNombre()+
                                "\nCon el número de cédula:\n"+inicioF.getDatoF().getCedula());
            }
            else
            {
                JOptionPane.showMessageDialog(null, 
                        "No hay clientes en fila","Fila Vacía",JOptionPane.ERROR_MESSAGE);
            }
        }catch(NullPointerException exc02)
        {
            JOptionPane.showMessageDialog(null, "Fila Vacía");
        }
    }
    
    public void calculadora()
    {
        double num =  Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese un monto para calcular el interés compuesto de 10% a un año: \n(Válido para montos iguales o mayores a 10$)"));
        JOptionPane.showMessageDialog(null,"El interés compuesto de 10% a un año de la suma:\n"+num+" \nes el siguiente: \n"+calculosCalcu(num));
    }
    
    private static double calculosCalcu(double num)
    {
        if (num<10)
        {
            return num;
        }
        else
        {
            return calculosCalcu(num*0.1) +num;
        }
    }
    
    
}
