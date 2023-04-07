package proyectobancoed;

import javax.swing.JOptionPane;

public class ProyectoMain {

    public static void main(String[] args) {
        Menu m = new Menu();
        Fila f = new Fila();
        BD b = new BD();
        Reporte r = new Reporte();
        
        
//        int op = 0;
//        while (op != 5) {
//            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Principal\n"
//                    + "1. Insertar todos\n"
//                    + "2. Mostrar todos\n"
//                    + "3. Buscar\n"
//                    + "4. Editar\n"
//                    + "5. Eliminar\n"
//                    + "6. Salir\n" + "Digite la opción deseada: "));
//            switch (op) {
//                case 1:
//                    
//                    String NombreN = JOptionPane.showInputDialog(null, "Digite el nombre:");
//                    int CedulaN = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cédula: "));
//                    String NumTelN = JOptionPane.showInputDialog(null, "Digite el número de teléfono: ");
//                    int EdadN = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la edad: "));
//                    String DireccionN = JOptionPane.showInputDialog(null, "Digite la dirección: ");
//                    int idN = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id: "));
//                    
//                    
//                    f.insertarFila(NombreN, CedulaN, NumTelN, EdadN, DireccionN, idN);
//                    b.insertarBD(NombreN, CedulaN, NumTelN, EdadN, DireccionN, idN);
//                    r.insertarReporte(NombreN, CedulaN, NumTelN, EdadN, DireccionN, idN);
//                    break;
//                    
//                case 2:
//                    
//                    f.mostrarFila();
//                    b.mostrarBD();
//                    r.mostrarReporte();
//                    break;
//                    
//                case 3:
//                    b.Buscar();
//                    break;
//                    
//                case 4:
//                    f.editarFila();
//                    b.editarBD();
//                    r.editarReporte();
//                    break;
//                    
//                case 5:
//                    b.Eliminar();
//                    break;
//                    
//                case 6:
//                    System.exit(0);
//                default:
//                    JOptionPane.showMessageDialog(null, "Error opción inválida",
//                            "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }

}
