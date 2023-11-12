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
import javax.swing.JOptionPane;
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
    }
   
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == guardar){
                
                try{
                //Si no se ingresa nada saldra el error
                    if (nombreText.getText().isEmpty() || cedulaText.getText().isEmpty() || promesasText.getText().isEmpty() || votosText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "¿Como quieres guardar nada?\n no tiene sentido o tal vez para ti si pero no para el 99% de la gente y la fisica\n literalmente estas yendo en contra de las fisicas. Mi idolo", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                        
                    nombre = nombreText.getText();
                    //Valida que el nombre solo tenga letras pues es raro que contenga numeros, ¿No?
                    if (!nombre.matches("^[a-zA-Z]+$")) {
                        JOptionPane.showMessageDialog(this, "Dale mi rey los nombres no contienen numeros\n tal vez en otra realidad pero en esta no", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // No permite continuar con la operación
                    }
                    cedula = cedulaText.getText();
                    //Valida que la cédula solo contenga números pues es imposible que tenga letras
                    if (!cedula.matches("^[0-9]+$")) {
                        JOptionPane.showMessageDialog(this, "Que cedula mas rara que contiene letras \n ¿si será colombiana?", "Error", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    promesas = promesasText.getText();
                    
                    votos = Integer.parseInt(votosText.getText());
                    //Validamos que los votos no superen a la poblacion de colombia
                    if (votos > 52000000){
                        JOptionPane.showMessageDialog(this, "Se sabe que colombia es corruputa, pero no tanto\n como para que los fantasmas voten.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    ideologiaSeleccionada = (Ideologia) ideologia.getSelectedItem();
                    //Valida si se selecciono algunas de las opciones (Obviamente SELECCIONAR no es una ciudad ni ideologia ni un partido)
                    if (ideologiaSeleccionada == Ideologia.Seleccionar){
                        JOptionPane.showMessageDialog(this, "Me pregunto que tal la ideologia SELECCIONAR, de seguro sera dudosa\n *Tambores*", "Error", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    ciudadSeleccionada = (Ciudades) ciudad.getSelectedItem();
                    if (ciudadSeleccionada == Ciudades.Seleccionar){
                        JOptionPane.showMessageDialog(this, "Seleccionar no es una ciudad de (al menos) colombia\n o tal vez si, solo que no la conozco ni creo que el 100% de los colombianos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    partidoSeleccionado = (Partidos) partidos.getSelectedItem();
                    if (partidoSeleccionado == Partidos.Seleccionar){
                        JOptionPane.showMessageDialog(this, "Que increible el partido SELECCIONAR", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                
                ideologiaSeleccionada = (Ideologia) ideologia.getSelectedItem();
                ciudadSeleccionada = (Ciudades) ciudad.getSelectedItem();
                partidoSeleccionado = (Partidos) partidos.getSelectedItem();

                Candidato candidato = new Candidato(ideologiaSeleccionada, partidoSeleccionado, votos, promesas, nombre, cedula, ciudadSeleccionada );
                listaCandidato.add(candidato);
                System.out.println(listaCandidato);

            
            } catch (RuntimeException ex) {
                // Mostrar un mensaje indicando que se ha producido una excepción
                JOptionPane.showMessageDialog(this, "No se desde cuando los votos pueden llevar letras", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
