 InterfazCRUD
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class App extends JFrame implements ActionListener {
    public static ArrayList <Candidato> listaCandidato = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
        App app = new App();
    }
    
    
    Container contenedor;
    FlowLayout layout;
    JLabel etiqueta1, infoCandidato, etiquetaNombre, etiquetaCedula, etiquetaPromesas, etiquetaVotos, eliminarJLabel;
    JMenuBar barraMenuBar;
    JMenu crud, datosCandidato;
    JTextField nombreText, cedulaText, promesasText, votosText, eliminarText;
    JMenuItem crearCandidato, actualizarCandidato, eliminarCandidato, listarCandidatos, votosCandidatos, candidatoGanador, ciudadCandidato, partidosCandidato;
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
    
    public App(){
        
        setTitle("Pagina principal");
        contenedor = getContentPane();
        layout = new FlowLayout();
        contenedor.setLayout(layout);


        etiqueta1 = new JLabel("SISTEMA DE REGISTRO DE CANDIDATOS");
        contenedor.add(etiqueta1);

        barraMenuBar = new JMenuBar();
        crud = new JMenu("Datos del candidato");
        datosCandidato = new JMenu("Informacion del candidato");
        barraMenuBar.add(crud);
        barraMenuBar.add(datosCandidato);
        

        crearCandidato = new JMenuItem("Registrar Candidato");
        actualizarCandidato = new JMenuItem("Actualizar Candidato");
        eliminarCandidato = new JMenuItem("Eliminar Candidato");

        listarCandidatos = new JMenuItem("Lista de candidatos");
        votosCandidatos = new JMenuItem("Votos de los candidatos");
        candidatoGanador = new JMenuItem("Candidato ganador");
        ciudadCandidato = new JMenuItem("Ciudades con menos candidatos");
        partidosCandidato = new JMenuItem("Partidos con mas candidatos");
        
        datosCandidato.add(listarCandidatos);
        datosCandidato.add(votosCandidatos);
        datosCandidato.add(candidatoGanador);
        datosCandidato.add(ciudadCandidato);
        datosCandidato.add(partidosCandidato);

        crud.add(crearCandidato);
        crud.add(actualizarCandidato);
        crud.add(eliminarCandidato);
        contenedor.add(barraMenuBar);

        infoCandidato = new JLabel("Información del candidato:");
        contenedor.add(infoCandidato);

        listarCandidatos.addActionListener(this);
        votosCandidatos.addActionListener(this);
        candidatoGanador.addActionListener(this);
        ciudadCandidato.addActionListener(this);
        partidosCandidato.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);

    crearCandidato.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaRegistrarCandidatos ventanaSecundaria = new VentanaRegistrarCandidatos(listaCandidato);
            ventanaSecundaria.setVisible(true);
            }
        });
    actualizarCandidato.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaActualizarCandidato ventanaActualizar = new VentanaActualizarCandidato();
            ventanaActualizar.setVisible(true);
            }
        });
    eliminarCandidato.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            VentanaEliminarCandidato ventanaEliminar = new VentanaEliminarCandidato(listaCandidato);
            ventanaEliminar.setVisible(true);       
            }
        });
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listarCandidatos) {
            VentanaListaCandidato ventanaLista = new VentanaListaCandidato();
            ventanaLista.setVisible(true);
        } else if (e.getSource() == votosCandidatos) {
            VentanaVotosCandidatos ventanaVotos = new VentanaVotosCandidatos();
            ventanaVotos.setVisible(true);
        } else if (e.getSource() == candidatoGanador) {
            VentanaCandidatoGanador ventanaCandidatoGanador = new VentanaCandidatoGanador();
            ventanaCandidatoGanador.setVisible(true);
        } else if (e.getSource() == ciudadCandidato) {
            VentanaCiudadesCandidato ventanaCiudadesCandidato = new VentanaCiudadesCandidato();
            ventanaCiudadesCandidato.setVisible(true);
        } else if (e.getSource() == partidosCandidato) {
            VentanaPartidosCandidato ventanaPartidosCandidato = new VentanaPartidosCandidato();
            ventanaPartidosCandidato.setVisible(true);
        }
    }

}

=======
si
main
