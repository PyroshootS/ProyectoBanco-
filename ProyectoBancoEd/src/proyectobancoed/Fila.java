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

    public  void insertarFila(){
        Dato d = new Dato();

        d.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre:"));
        d.setCedula(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cédula: ")));
        d.setNumTelefono(JOptionPane.showInputDialog(null, "Digite el número de teléfono: "));
        d.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la edad: ")));
        d.setDireccion(JOptionPane.showInputDialog(null, "Digite la dirrección: "));

        d.setId(Integer.parseInt("Digite el id: "));

        NodoFila nuevo = new NodoFila();
        nuevo.setDatoF(d);

        if (vacia()){
            inicioF = nuevo;
            finF = nuevo;
            finF.setSiguienteF(inicioF);
            inicioF.setAnteriorF(finF);

        }else if (d.getId() < inicioF.getDatoF().getId()){
            nuevo.setSiguienteF(inicioF);
            inicioF = nuevo;
            finF.setSiguienteF(inicioF);
            inicioF.setAnteriorF(finF);

        }else if(d.getId() > finF.getDatoF().getId()){
            finF.setSiguienteF(nuevo);
            finF = finF.getSiguienteF();
            finF.setSiguienteF(inicioF);
            inicioF.setAnteriorF(finF);

        }else{
            NodoFila aux = inicioF;
            while(aux.getSiguienteF().getDatoF().getId() < d.getId()){
                aux = aux.getSiguienteF();
            }
            nuevo.setSiguienteF(aux.getSiguienteF());
            nuevo.setAnteriorF(aux);
            aux.setSiguienteF(nuevo);
            nuevo.getSiguienteF().setAnteriorF(nuevo);
        }

         

    }


}
