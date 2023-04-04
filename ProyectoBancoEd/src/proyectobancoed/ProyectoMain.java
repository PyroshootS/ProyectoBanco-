package proyectobancoed;

import javax.swing.JOptionPane;

public class ProyectoMain {

    public static void main(String[] args) {
        Fila f = new Fila();
        BD b = new BD();
        Reporte r = new Reporte();
        
        
        int op = 0;
        while (op != 5) {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Principal\n"
                    + "1. Insertar\n"
                    + "2. Desencolar elemento\n"
                    + "3. Mostrar elementos\n"
                    + "4. Salir\n" + "Digite la opción deseada: "));
            switch (op) {
                case 1:
                    
                    String NombreN = JOptionPane.showInputDialog(null, "Digite el nombre:");
                    int CedulaN = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cédula: "));
                    String NumTelN = JOptionPane.showInputDialog(null, "Digite el número de teléfono: ");
                    int EdadN = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la edad: "));
                    String DireccionN = JOptionPane.showInputDialog(null, "Digite la dirrección: ");
                    int idN = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id: "));
                    
                    
                    f.insertarFila(NombreN, CedulaN, NumTelN, EdadN, DireccionN, idN);
                    b.insertarBD(NombreN, CedulaN, NumTelN, EdadN, DireccionN, idN);
                    r.insertarReporte(NombreN, CedulaN, NumTelN, EdadN, DireccionN, idN);
                    
                    break;
                case 2:
                    
                    f.mostrarFila();
                    b.mostrarBD();
                    r.mostrarReporte();
                    
                    break;
                case 3:
                    b.Buscar();
                    //b.Eliminar();
                    break;
                    
                case 4:
                    
                    System.exit(0);
                    
                default:
                    JOptionPane.showMessageDialog(null, "Error opción inválida",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
