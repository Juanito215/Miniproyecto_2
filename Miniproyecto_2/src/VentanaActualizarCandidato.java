import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    JComboBox  ideologiaActualizar, partidoActualizar, ciudadActualizar;
    JMenuBar opcionBar;
    JMenu opcionesActualizar;
    JMenuItem actualizarNombre, actualizarPromesas, actualizarVotos, actualizarCiudad, actualizarIdeologia, actualizarPartido;


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
                    opcionBar = new JMenuBar();
                    opcionesActualizar = new JMenu("Opciones Actualizar");
                    opcionBar.add(opcionesActualizar);

                    actualizarNombre = new JMenuItem("Actualizar Nombre");
                    actualizarPromesas = new JMenuItem("Actualizar Promesas");
                    actualizarVotos = new JMenuItem("Actualizar Votos");
                    actualizarCiudad = new JMenuItem("Actualizar Ciudades");
                    actualizarIdeologia = new JMenuItem("Actualizar Ideologia");
                    actualizarPartido = new JMenuItem("Actualizar Partido");

                    actualizarNombre.addActionListener(this);
                    actualizarPromesas.addActionListener(this);
                    actualizarVotos.addActionListener(this);
                    actualizarCiudad.addActionListener(this);
                    actualizarIdeologia.addActionListener(this);
                    actualizarPartido.addActionListener(this);

                    opcionesActualizar.add(actualizarNombre);
                    opcionesActualizar.add(actualizarPromesas);
                    opcionesActualizar.add(actualizarVotos);
                    opcionesActualizar.add(actualizarCiudad);
                    opcionesActualizar.add(actualizarIdeologia);
                    opcionesActualizar.add(actualizarPartido);

                    contenedor.add(opcionBar);
                    contenedor.revalidate();
                    contenedor.repaint();
                    setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(VentanaActualizarCandidato.this,
                        "Ese candidato no existe!\n Revisa bien si pusiste un numero de mas o te comiste algun numero",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }   
        }
        if(e.getSource() == actualizarNombre){
            nombreActualizar = new JTextField(15);   
            contenedor.add(new JLabel("Nuevo Nombre"));
            contenedor.add(nombreActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if(e.getSource() == actualizarPromesas){
            promesasActualizar = new JTextField(15);
            contenedor.add(new JLabel("Nuevas promesas"));
            contenedor.add(promesasActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if(e.getSource() == actualizarVotos){
            votosActualizar = new JTextField(15);
            contenedor.add(new JLabel("Votos Actualizados"));
            contenedor.add(votosActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if(e.getSource() == actualizarCiudad){
            ciudadActualizar = new JComboBox<>(Ciudades.values());
            contenedor.add(ciudadActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if(e.getSource() == actualizarIdeologia){
            ideologiaActualizar = new JComboBox<>(Ideologia.values());
            contenedor.add(ideologiaActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }else if(e.getSource() == actualizarPartido){
            partidoActualizar = new JComboBox<>(Partidos.values());
            contenedor.add(partidoActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            setVisible(true);
        }
    }
}