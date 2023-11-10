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
import java.util.Iterator;


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

        //listaCandidatosTextArea = new JTextArea(10, 40);
        //contenedor.add(listaCandidatosTextArea);
        
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

    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listarCandidatos) {
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
                VentanaRegistrarCandidatos ventanaSecundaria = new VentanaRegistrarCandidatos(listaCandidato);
                ventanaSecundaria.setVisible(true);
            }
        });
            
    /*    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(listaCandidatos)){
                    listaCandidatosTextArea.setText("");
                    StringBuilder listaCandidatosTexto = new StringBuilder();
                    for (Candidato candidato : listaCandidatosTexto){
                        listaCandidatosTexto.append("Nombre: ").append(candidato.getNombre()).append("\n");
                        listaCandidatosTexto.append("Cedula: ").append(candidato.getCedula()).append("\n");
                        listaCandidatosTexto.append("Promesas: ").append(candidato.getPromesas()).append("\n");
                        listaCandidatosTexto.append("Votos: ").append(candidato.getVotos()).append("\n");
                        listaCandidatosTexto.append("Ciudad").append(candidato.getCiudad()).append("\n");
                        listaCandidatosTexto.append("Partido").append(candidato.getPartido()).append("\n");
                            
                }
                listaCandidatosTextArea.setText(listaCandidatosTexto.toString());
            }
        }
*/ 
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
                
        /*guardar.addActionListener(new ActionListener(){
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
        });*/

        /*ideologia.addActionListener(new ActionListener(){
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
                partidoSeleccionado = (Partidos) partidos.getSelectedItem();      
            }
        });
        eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {    
                Iterator<Candidato> iterator = listaCandidato.iterator();
                while (iterator.hasNext()) {
                    Candidato candidato = iterator.next();
                    if (candidato.getCedula().equals(eliminarText)) {
                        iterator.remove();
                    }
                }
            }
        });
        //Candidato candidato = new Candidato(ideologiaSeleccionada, partidoSeleccionado, votos, promesas, nombre, cedula, ciudadSeleccionada );
        //listaCandidato.add(candidato);*/
        }
}
