import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaActualizarCandidato extends JFrame {
    Container contenedor;
    FlowLayout layout;
    JLabel etiquetaActualizar;
    JTextField candidatoActualizar, nombreActualizar, promesasActualizar, votosActualizar;
    JButton buscar, actualizar;
    JComboBox<String> opcionesActualizar, ideologiaActualizar, partidoActualizar, ciudadActualizar;

    String nombre;
    String cedula;
    String promesas;
    int votos;
    Ideologia ideologiaSeleccionada;
    Ciudades ciudadSeleccionada;
    Partidos partidoSeleccionado;

    ArrayList<Candidato> listaCandidato;
    public VentanaActualizarCandidato(ArrayList<Candidato> listaCandidato){
        this.listaCandidato = listaCandidato;
        setTitle("Actualizar Candidato");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contenedor = getContentPane();
        layout = new FlowLayout();
        contenedor.setLayout(layout);

        etiquetaActualizar = new JLabel("Introduce la cedula del candidato a actualizar");
        candidatoActualizar = new JTextField(15);
        contenedor.add(etiquetaActualizar);
        contenedor.add(candidatoActualizar);

        buscar = new JButton("Buscar");
        contenedor.add(buscar);  
        actualizar = new JButton("Actualizar");      
    
    buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaBuscar = candidatoActualizar.getText();
                Candidato candidatoEncontrado = buscarCandidatoPorCedula(cedulaBuscar);

                if (candidatoEncontrado != null) {
                    // Cédula encontrada
                    mostrarOpciones();
                } else {
                    JOptionPane.showMessageDialog(VentanaActualizarCandidato.this,
                        "Ese candidato no existe!\n Revisa bien si pusiste un numero de mas o te comiste algun numero", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public Candidato buscarCandidatoPorCedula(String cedula) {
        for (Candidato candidato : listaCandidato){
            if (candidato.getCedula().equals(cedula)){
                return candidato;
            }
        }
        return null;
    }
        public void mostrarOpciones() {
            String[] opciones = {"Seleccionar","Actualizar Nombre", "Actualizar Promesas", "Actualizar votos", "Actualizar ciudad", "Actualizar Ideologia", "Actualizar Partido"};

            opcionesActualizar = new JComboBox<>(opciones);
            contenedor.add(opcionesActualizar);

            actualizar = new JButton("Actualizar");
            actualizar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String opcionSeleccionada = (String) opcionesActualizar.getSelectedItem();

                    if (opcionSeleccionada.equals("Actualizar Nombre")){
                        nombreActualizar = new JTextField(15);
                        contenedor.add(new JLabel("Nuevo Nombre"));
                        contenedor.add(new JTextField());
                    }else if (opcionSeleccionada.equals("Actualizar Promesas")){
                        promesasActualizar = new JTextField(15);
                        contenedor.add(new JLabel("Nuevas promesas"));
                        contenedor.add(new JTextField());
                    }else if (opcionSeleccionada.equals("Actualizar Votos")){
                        votosActualizar = new JTextField(15);
                        contenedor.add(new JLabel("Votos Actualizados"));
                        contenedor.add(new JTextField());
                    }
                }
        });
        contenedor.add(actualizar);
        revalidate();
        repaint();
    }
}
