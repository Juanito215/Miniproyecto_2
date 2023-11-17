/*import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaActualizarCandidato extends JFrame implements ActionListener{
    Container contenedor;
    FlowLayout layout;
    JLabel etiquetaActualizar;
    JTextField candidatoActualizar, nombreActualizar, promesasActualizar, votosActualizar;
    JButton buscar, actualizar;
    JComboBox opcionesActualizar, ideologiaActualizar, partidoActualizar, ciudadActualizar;

    String nombre, cedulaBuscar, opcionSeleccionada;
    String cedula;
    String promesas;
    int votos;
    Ideologia ideologiaSeleccionada;
    Ciudades ciudadSeleccionada;
    Partidos partidoSeleccionado;
    String[] opciones = { "Seleccionar", "Actualizar Nombre", "Actualizar Promesas", "Actualizar votos",
                "Actualizar ciudad", "Actualizar Ideologia", "Actualizar Partido" };
    

    public VentanaActualizarCandidato(){
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
        buscar.addActionListener(this);
        contenedor.add(buscar);
        actualizar = new JButton("Actualizar");
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cedulaBuscar = candidatoActualizar.getText();
        boolean candidatoEncontrado = false;
        
        
        if(e.getSource() == buscar){
            
            for (Candidato candidato :VentanaRegistrarCandidatos.listaCandidato) {
                if(candidato.getCedula().equals(cedulaBuscar)){
                    candidatoEncontrado = true;
                    break;
                }
            }
            if (candidatoEncontrado) {
                    opcionesActualizar = new JComboBox<>(opciones);
                    contenedor.add(opcionesActualizar);
                    opcionSeleccionada = (String) opcionesActualizar.getSelectedItem();
                    contenedor.revalidate();
                    contenedor.repaint();
                    setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(VentanaActualizarCandidato.this,
                        "Ese candidato no existe!\n Revisa bien si pusiste un numero de mas o te comiste algun numero",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            
        }if("Actulizar Nombre".equals(opcionSeleccionada)){
            nombreActualizar = new JTextField(15);
            
            contenedor.add(new JLabel("Nuevo Nombre"));
            contenedor.add(nombreActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if("Actualizar Promesas".equals(opcionSeleccionada)){
            promesasActualizar = new JTextField(15);
            contenedor.add(new JLabel("Nuevas promesas"));
            contenedor.add(promesasActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if("Actualizar votos".equals(opcionSeleccionada)){
            votosActualizar = new JTextField(15);
            contenedor.add(new JLabel("Votos Actualizados"));
            contenedor.add(votosActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if("Actualizar ciudad".equals(opcionSeleccionada)){
            ciudadActualizar = new JComboBox<>(Ciudades.values());
            contenedor.add(ciudadActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if("Actualizar Ideologia".equals(opcionSeleccionada)){
            ideologiaActualizar = new JComboBox<>(Ciudades.values());
            contenedor.add(ideologiaActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if("Actualizar Partido".equals(opcionSeleccionada)){
            partidoActualizar = new JComboBox<>(Ciudades.values());
            contenedor.add(partidoActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }
    }
}*/