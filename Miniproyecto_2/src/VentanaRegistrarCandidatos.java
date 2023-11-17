import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;


public class VentanaRegistrarCandidatos extends JFrame implements ActionListener {
    
    Container contenedor;
    FlowLayout layout;
    JLabel etiqueta1, infoCandidato, etiquetaNombre, etiquetaCedula, etiquetaPromesas, etiquetaVotos, eliminarJLabel;
    JTextField nombreText, cedulaText, promesasText, votosText, eliminarText;
    JButton guardar, eliminar;
    JComboBox ideologia, ciudad, partidos;
    
    String nombre;
    String cedula;
    String promesas;
    int votos;
    Ideologia ideologiaSeleccionada;
    Ciudades ciudadSeleccionada;
    Partidos partidoSeleccionado;
    static ArrayList<Candidato> listaCandidato;
    

    public VentanaRegistrarCandidatos(ArrayList<Candidato> listaCandidato) {
        VentanaRegistrarCandidatos.listaCandidato = listaCandidato; //Inicializo la lista

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
                    nombre = nombreText.getText();
                    if (nombreText.getText().isEmpty()){ //Si no hay nada sale la excepcion, así con todos
                        JOptionPane.showMessageDialog(this, "¿No le vas a poner nombre? :(", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    //Valida que el nombre solo tenga letras pues es raro que contenga numeros, ¿No?
                    if (!nombre.matches("^[a-zA-Z]+$")) {
                        JOptionPane.showMessageDialog(this, "Dale mi rey los nombres no contienen numeros\n tal vez en otra realidad pero en esta no", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // No permite continuar con la operación
                    }
     
                    cedula = cedulaText.getText();
                    if (cedulaText.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this, "¿Como no va a tener cedula el candidato? Si es lo mas importante", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if (!cedula.matches("^[0-9]+$")) { //Valida que la cédula solo contenga números pues es imposible que tenga letras
                        JOptionPane.showMessageDialog(this, "Que cedula mas rara que contiene letras \n ¿si será colombiana?", "Error", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    promesas = promesasText.getText();
                    if (promesasText.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this, "¿Y que promesas va a hacer?\n Al poder no se llega sin nada, los ciudadanos no te van a elegir si no les das nada\n Dale que antes te estoy haciendo un favor al no dejarte ir mas allá", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    votos = Integer.parseInt(votosText.getText());
                    if (votosText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "¿Como que no hay votos? Alguno te habrás llevado, ¿No?", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if (votos > 52000000){ //Validamos que los votos no superen a la poblacion de colombia
                        JOptionPane.showMessageDialog(this, "Se sabe que colombia es corruputa, pero no tanto\n como para que los fantasmas voten.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (votos < 30){
                        JOptionPane.showMessageDialog(this, "¿Para que te lanzaste a hacer campaña?","Error", JOptionPane.ERROR_MESSAGE);

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
                
                nombreText.setText("");
                cedulaText.setText("");
                promesasText.setText("");
                votosText.setText("");
                ideologia.setSelectedIndex(0);
                partidos.setSelectedIndex(0);
                ciudad.setSelectedIndex(0);

            } catch (RuntimeException ex) {
                // Mostrar un mensaje indicando que se ha producido una excepción
                JOptionPane.showMessageDialog(this, "No se desde cuando los votos pueden llevar letras", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
