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
