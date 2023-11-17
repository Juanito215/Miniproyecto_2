import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;

public class VentanaEliminarCandidato extends JFrame {

    Container contenedor;
    FlowLayout layout;
    JLabel eliminarJLabel;
    JTextField eliminarText;
    JButton guardar, eliminar;

    ArrayList<Candidato> listaCandidato;

    public VentanaEliminarCandidato(ArrayList<Candidato> listaCandidato){
        this.listaCandidato = listaCandidato;

        setTitle("Eliminar Candidato");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contenedor = getContentPane();
        layout = new FlowLayout();
        contenedor.setLayout(layout);

        eliminarJLabel = new JLabel("Ingrese la cedula del candidato que desea eliminar: ");
        eliminarText = new JTextField(10);
        contenedor.add(eliminarJLabel);
        contenedor.add(eliminarText);

        eliminar = new JButton("Eliminar");
        contenedor.add(eliminar);

        eliminar.addActionListener(e -> {
            String cedulaAEliminar = eliminarText.getText();
            boolean candidatoEliminado = false;
            //Si no hay nada introducido sale el error
            if (cedulaAEliminar.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "¿Como vas a eliminar nada?\n Introduce algo por favor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Valida que la cédula solo contenga números pues es imposible que tenga letras
            if (!cedulaAEliminar.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(this, "Que cedula mas rara que contiene letras \n ¿si será colombiana?", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            for (Candidato candidato : listaCandidato) {
                if (candidato.getCedula().equals(cedulaAEliminar)) {
                    listaCandidato.remove(candidato);
                    candidatoEliminado = true;
                    break;
                }
            }


            if (candidatoEliminado) {
                JOptionPane.showMessageDialog(this, "Se eliminó al candidato correctamente", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "¿Estas seguro que existe esa cedula del candidato? \n Cuidado con un numero de mas o de menos", "Error al eliminar", JOptionPane.WARNING_MESSAGE);
            }

        });


    }
}

