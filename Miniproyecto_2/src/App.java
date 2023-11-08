import javax.swing.JButton;
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


public class App extends JFrame implements ActionListener {
    
    public static void main(String[] args) throws Exception {
        App app = new App();
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    
    Container contenedor;
    FlowLayout layout;
    JLabel etiqueta1, infoCandidato, etiquetaNombre, etiquetaCedula, etiquetaPromesas, etiquetaVotos;
    JMenuBar barraMenuBar;
    JMenu crud, datosCandidato;
    JTextField campo1, campo2, campo3, campo4;
    JMenuItem crearCandidato, actualizarCandidato, eliminarCandidato, listaCandidatos, votosCandidatos, candidatoGanador, ciudadCandidato, partidosCandidato;
    JButton salir;
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
        salir = new JButton("Salir de la app");
        barraMenuBar.add(crud);
        barraMenuBar.add(datosCandidato);
        barraMenuBar.add(salir);

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
        campo1 = new JTextField(20);
        contenedor.add(etiquetaNombre, campo1);

        etiquetaCedula = new JLabel("Ingrese la cédula: ");
        campo2 = new JTextField(10);
        contenedor.add(etiquetaCedula, campo2);

        etiquetaPromesas = new JLabel("Ingrese las promesas del candidadto: ");
        campo3 = new JTextField(10);
        contenedor.add(etiquetaPromesas, campo3);

        etiquetaVotos = new JLabel("Ingrese los votos del candidato: ");
        campo4 = new JTextField(5);
        contenedor.add(etiquetaVotos, campo4);

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
    }
}
