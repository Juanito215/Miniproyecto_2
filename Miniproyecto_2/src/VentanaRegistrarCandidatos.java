import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.util.ArrayList;


public class VentanaRegistrarCandidatos extends JFrame implements ActionListener {
    
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
    

    public VentanaRegistrarCandidatos(ArrayList<Candidato> listaCandidato) {
        this.listaCandidato = listaCandidato; //Inicializo la lista

        setTitle("Registrar Candidato");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contenedor = getContentPane();
        layout = new FlowLayout();
        contenedor.setLayout(layout);

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

        ideologia = new JComboBox<>(Ideologia.values());
        contenedor.add(ideologia);

        ciudad = new JComboBox<>(Ciudades.values());
        contenedor.add(ciudad);

        partidos = new JComboBox<>(Partidos.values());
        contenedor.add(partidos);

        guardar = new JButton("Guardar");
        guardar.addActionListener(this);
        contenedor.add(guardar);

       /* eliminarJLabel = new JLabel("Ingrese la cedula del candidato que desea eliminar: ");
        eliminarText = new JTextField(10);
        contenedor.add(eliminarJLabel);
        contenedor.add(eliminarText);

        eliminar = new JButton("Eliminar");
        contenedor.add(eliminar);
        */
    
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

            System.out.println(listaCandidatos);
            Candidato candidato = new Candidato(ideologiaSeleccionada, partidoSeleccionado, votos, promesas, nombre, cedula, ciudadSeleccionada );
            listaCandidato.add(candidato);
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
            partidoSeleccionado = (Partidos) partidos.getSelectedItem();      
        }
    });
}


    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
