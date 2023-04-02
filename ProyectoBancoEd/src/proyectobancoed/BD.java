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
    public  void insertarBD(){
        
////////////////////////////////////////////////////////cambiar esto , porque se deben agarrar los datos insertados en fila directamente, no volver a preguntar por los datos/////////////////////////////////////////////////////////////////////       
        Dato d = new Dato();
        
        d.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre:"));
        d.setCedula(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cédula: ")));
        d.setNumTelefono(JOptionPane.showInputDialog(null, "Digite el número de teléfono: "));
        d.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la edad: ")));
        d.setDireccion(JOptionPane.showInputDialog(null, "Digite la dirrección: "));

        d.setId(Integer.parseInt("Digite el id: "));

        NodoBD nuevo = new NodoBD();
        nuevo.setDatoBd(d);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (vacia()){
            inicioBD = nuevo;
            finBD = nuevo;
            finBD.setSiguienteBd(inicioBD);
            inicioBD.setAnteriorBd(finBD);

        }else if (d.getId() < inicioBD.getDatoBd().getId()){
            nuevo.setSiguienteBd(inicioBD);
            inicioBD = nuevo;
            finBD.setSiguienteBd(inicioBD);
            inicioBD.setAnteriorBd(finBD);

        }else if(d.getId() > finBD.getDatoBd().getId()){
            finBD.setSiguienteBd(nuevo);
            finBD = finBD.getSiguienteBd();
            finBD.setSiguienteBd(inicioBD);
            inicioBD.setAnteriorBd(finBD);

        }else{
            NodoBD aux = inicioBD;
            while(aux.getSiguienteBd().getDatoBd().getId() < d.getId()){
                aux = aux.getSiguienteBd();
            }
            nuevo.setSiguienteBd(aux.getSiguienteBd());
            nuevo.setAnteriorBd(aux);
            aux.setSiguienteBd(nuevo);
            nuevo.getSiguienteBd().setAnteriorBd(nuevo);
        }

         

    }
    
////////////////////////////FALTA PROBAR EN LISTA (Ya esta probado en un ejemplo de una lista circular faltaria en nuestro ejemplo)///////////////////////////////////////////////////////////////////////////////
    public void Eliminar(){
        try{
            int NumCedulaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cedula de la persona que desea eliminar:"));
            if(inicioBD.getDatoBd().getCedula()==NumCedulaEliminar){
                inicioBD = inicioBD.getSiguienteBd();
                finBD.setSiguienteBd(inicioBD);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else{
                NodoBD anterior;
                NodoBD aux;
                anterior = inicioBD;
                aux =  inicioBD.getSiguienteBd();
                while((aux != inicioBD) && (!aux.getDatoBd().getNombre().equals(NumCedulaEliminar))){
                    anterior = anterior.getSiguienteBd();
                    aux = aux.getSiguienteBd();
                }
                if(aux != inicioBD){
                    anterior.setSiguienteBd(aux.getSiguienteBd());
                    finBD.setSiguienteBd(inicioBD);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Probablemente el Numero de Cedula ingresado no existe");
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
