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
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class App extends JFrame implements ActionListener {
    static ArrayList <Candidato> listaCandidato = new ArrayList<>();
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
    JLabel etiqueta1, infoCandidato, etiquetaNombre, etiquetaCedula, etiquetaPromesas, etiquetaVotos;
    JMenuBar barraMenuBar;
    JMenu crud, datosCandidato;
    JTextField nombreText, cedulaText, promesasText, votosText;
    JMenuItem crearCandidato, actualizarCandidato, eliminarCandidato, listaCandidatos, votosCandidatos, candidatoGanador, ciudadCandidato, partidosCandidato;
    JButton guardar;
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

        listaCandidatos = new JMenuItem("Lista de candidatos");
        votosCandidatos = new JMenuItem("Votos de los candidatos");
        candidatoGanador = new JMenuItem("Candidato ganador");
        ciudadCandidato = new JMenuItem("Ciudades con menos candidatos");
        partidosCandidato = new JMenuItem("Partidos con mas candidatos");

        datosCandidato.add(listaCandidatos);
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

        listaCandidatos.addActionListener(this);
        votosCandidatos.addActionListener(this);
        candidatoGanador.addActionListener(this);
        ciudadCandidato.addActionListener(this);
        partidosCandidato.addActionListener(this);

        etiquetaNombre = new JLabel("Ingrese el nombre: ");
        nombreText = new JTextField(15);
        contenedor.add(etiquetaNombre);
        contenedor.add(nombreText);
        

        etiquetaCedula = new JLabel("Ingrese la cédula: ");
        cedulaText = new JTextField(10);
        contenedor.add(etiquetaCedula);
        contenedor.add(cedulaText);

        etiquetaPromesas = new JLabel("Ingrese las promesas del candidadto: ");
        promesasText = new JTextField(20);
        contenedor.add(etiquetaPromesas);
        contenedor.add(promesasText);

        etiquetaVotos = new JLabel("Ingrese los votos del candidato: ");
        votosText = new JTextField(5);
        contenedor.add(etiquetaVotos);
        contenedor.add(votosText);

        guardar = new JButton("Guardar");
        contenedor.add(guardar);

        ideologia = new JComboBox<>(Ideologia.values());
        contenedor.add(ideologia);

        ciudad = new JComboBox<>(Ciudades.values());
        contenedor.add(ciudad);

        partidos = new JComboBox<>(Partidos.values());
        contenedor.add(partidos);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);

    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaCandidatos) {
            infoCandidato.setText("Mostrar lista de candidatos aquí");
        } else if (e.getSource() == votosCandidatos) {
            infoCandidato.setText("Mostrar votos de los candidatos aquí");
        } else if (e.getSource() == candidatoGanador) {
            infoCandidato.setText("Mostrar candidato ganador aquí");
        } else if (e.getSource() == ciudadCandidato) {
            infoCandidato.setText("Mostrar ciudades con menos candidatos aquí");
        } else if (e.getSource() == partidosCandidato) {
            infoCandidato.setText("Mostrar partidos con más candidatos aquí");
        }

        crearCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el elemento de menú, crea una nueva ventana
                VentanaRegistrarCandidatos ventanaSecundaria = new VentanaRegistrarCandidatos();
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
            VentanaEliminarCandidato ventanaEliminar = new VentanaEliminarCandidato();
            ventanaEliminar.setVisible(true);
                
            }
        });
            
     guardar.addActionListener(new ActionListener(){
         @Override
        public void actionPerformed(ActionEvent e) {
                nombre = nombreText.getText();
                cedula = cedulaText.getText();
                promesas = promesasText.getText();
                votos = Integer.parseInt(votosText.getText());
                ideologiaSeleccionada = (Ideologia) ideologia.getSelectedItem();
                ciudadSeleccionada = (Ciudades) ciudad.getSelectedItem();
                partidoSeleccionado = (Partidos) partidos.getSelectedItem();
            }
        });

        ideologia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ideologiaSeleccionada = (Ideologia) ideologia.getSelectedItem();
            }
        });
        ciudad.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ciudadSeleccionada = (Ciudades) ciudad.getSelectedItem();
            }
        });
        partidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Partidos partidoSeleccionado = (Partidos) partidos.getSelectedItem();      
            }
        });
        Candidato candidato = new Candidato(ideologiaSeleccionada, partidoSeleccionado, );
    }
}