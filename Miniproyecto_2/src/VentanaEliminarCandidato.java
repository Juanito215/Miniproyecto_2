import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;

public class VentanaEliminarCandidato extends JFrame {

    Container contenedor;
    FlowLayout layout;
    JLabel etiqueta1, infoCandidato, etiquetaNombre, etiquetaCedula, etiquetaPromesas, etiquetaVotos, eliminarJLabel;
    JMenuBar barraMenuBar;
    JMenu crud, datosCandidato;
    JTextField nombreText, cedulaText, promesasText, votosText, eliminarText;
    JMenuItem crearCandidato, actualizarCandidato, eliminarCandidato, listaCandidatos, votosCandidatos, candidatoGanador, ciudadCandidato, partidosCandidato;
    JButton guardar, eliminar;
    JComboBox ideologia, ciudad, partidos;
    JFrame frame;
    
    String nombre;
    String cedula;
    String promesas;
    int votos;
    Ideologia ideologiaSeleccionada;
    Ciudades ciudadSeleccionada;
    Partidos partidoSeleccionado;
    ArrayList<Candidato> listaCandidato;

    public VentanaEliminarCandidato(ArrayList<Candidato> listaCandidato){
        this.listaCandidato = listaCandidato;

        setTitle("Eliminar Candidato");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

            for (Candidato candidato : listaCandidato) {
                if (candidato.getCedula().equals(cedulaAEliminar)) {
                    listaCandidato.remove(candidato);
                    candidatoEliminado = true;
                    break;
                }
            }
            
            if (candidatoEliminado) {
                JOptionPane.showMessageDialog(this, "Candidato eliminado correctamente", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Candidato no encontrado", "Error al eliminar", JOptionPane.WARNING_MESSAGE);
            }
        });


    }
}

