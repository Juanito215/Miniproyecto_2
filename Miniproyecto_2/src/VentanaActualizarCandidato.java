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
    JButton buscar, botonActualizarNombre, botonActualizarPromesas, botonActualizarVotos, botonActualizarCiudades, botonActualizarIdeologia, botonActualizarPartido ;
    JComboBox  ideologiaActualizar, partidoActualizar, ciudadActualizar;
    JMenuBar opcionBar;
    JMenu opcionesActualizar;
    JMenuItem actualizarNombre, actualizarPromesas, actualizarVotos, actualizarCiudad, actualizarIdeologia, actualizarPartido;
    Candidato candidatoNew;
    Ciudades ciudadActualizada;
    Partidos partidoActualizado;
    Ideologia ideologiaActualizada;
    boolean candidatoEncontrado = false;

    String nombre, cedulaBuscar, opcionSeleccionada, nombreActualizado, promesasActualizadas, votoString;
    String cedula;
    String promesas;
    int votos, votosActualizados;
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
        
        botonActualizarNombre = new JButton("Actualizar Nombre");
        botonActualizarNombre.addActionListener(this);
        contenedor.add(botonActualizarNombre);
        botonActualizarNombre.setVisible(false);

        botonActualizarPromesas = new JButton("Actualizar Promesas");
        botonActualizarPromesas.addActionListener(this);
        contenedor.add(botonActualizarPromesas);
        botonActualizarPromesas.setVisible(false);

        botonActualizarVotos = new JButton("Actualizar Votos");
        botonActualizarVotos.addActionListener(this);
        contenedor.add(botonActualizarVotos);
        botonActualizarVotos.setVisible(false);

        botonActualizarCiudades = new JButton("Actualizar Ciudad");
        botonActualizarCiudades.addActionListener(this);
        contenedor.add(botonActualizarCiudades);
        botonActualizarCiudades.setVisible(false);

        botonActualizarIdeologia = new JButton("Actualizar Ideologia");
        botonActualizarIdeologia.addActionListener(this);
        contenedor.add(botonActualizarIdeologia);
        botonActualizarIdeologia.setVisible(false);
        
        botonActualizarPartido = new JButton("Actualizar Partido");
        botonActualizarPartido.addActionListener(this);
        contenedor.add(botonActualizarPartido);
        botonActualizarPartido.setVisible(false);
        
        
    }

    public Candidato buscarCandidatoPorCedula(){
        cedulaBuscar = candidatoActualizar.getText();
        for (Candidato candidato :VentanaRegistrarCandidatos.listaCandidato) {
                if(candidato.getCedula().equals(cedulaBuscar)){
                    candidatoNew = candidato;
                    break;
                }
            }
        return candidatoNew;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource() == buscar){

            buscarCandidatoPorCedula();
            
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
            botonActualizarNombre.setVisible(true);
            setVisible(true);
        }else if(e.getSource() == actualizarPromesas){
            promesasActualizar = new JTextField(15);
            contenedor.add(new JLabel("Nuevas promesas"));
            contenedor.add(promesasActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            botonActualizarPromesas.setVisible(true);
            setVisible(true);
        }else if(e.getSource() == actualizarVotos){
            votosActualizar = new JTextField(15);
            contenedor.add(new JLabel("Votos Actualizados"));
            contenedor.add(votosActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            botonActualizarVotos.setVisible(true);
            setVisible(true);
        }else if(e.getSource() == actualizarCiudad){
            ciudadActualizar = new JComboBox<>(Ciudades.values());
            contenedor.add(ciudadActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            botonActualizarCiudades.setVisible(true);
            setVisible(true);
        }else if(e.getSource() == actualizarIdeologia){
            ideologiaActualizar = new JComboBox<>(Ideologia.values());
            contenedor.add(ideologiaActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            botonActualizarIdeologia.setVisible(true);
            setVisible(true);
        }else if(e.getSource() == actualizarPartido){
            partidoActualizar = new JComboBox<>(Partidos.values());
            contenedor.add(partidoActualizar);
            contenedor.revalidate();
            contenedor.repaint();
            botonActualizarPartido.setVisible(true);
            setVisible(true);
        }
        
        if(e.getSource() == botonActualizarNombre){
            nombreActualizado = nombreActualizar.getText();
            if (contieneNumeros(nombreActualizado)){
                JOptionPane.showMessageDialog(VentanaActualizarCandidato.this, "Porfa no introduzcas numeros en el nombre que si no se cae el programa \n hagame ese gran favor no solo a mi sino tambien al programa", "Error", JOptionPane.ERROR_MESSAGE);;
                return;
            }
        }else{
            nombreActualizado = buscarCandidatoPorCedula().getNombre();
        }

        if(e.getSource() == botonActualizarPromesas){
            promesasActualizadas = promesasActualizar.getText();
        }else{
            promesasActualizadas = buscarCandidatoPorCedula().getPromesas();
        }
        if(e.getSource() == botonActualizarVotos){
            votoString = votosActualizar.getText();
            if (!contieneLetras(votoString)){
                JOptionPane.showMessageDialog(VentanaActualizarCandidato.this, "No se desde cuando los votos llevan letras fiera \n Pon los votos solo con numeros pues como vas a contar letras como votos (El algebra no cuenta en este caso)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } votosActualizados = Integer.parseInt(votoString);
        }else{
            votosActualizados = buscarCandidatoPorCedula().getVotos();
        }
        if(e.getSource() == botonActualizarCiudades){
            if (ciudadActualizar.getSelectedIndex() == 0){
                mostrarExcepcionSeleccionarCiudad("Dale selecciona una opcion diferente.");
                return;
            } 
            ciudadActualizada = (Ciudades) ciudadActualizar.getSelectedItem();
        }else{
            ciudadActualizada = buscarCandidatoPorCedula().getCiudad();
        }
        if(e.getSource() == botonActualizarIdeologia){
            if(ideologiaActualizar.getSelectedIndex() == 0){
                mostrarExcepcionSeleccionarIdeologia("Selecciona una opcion diferente.");
                return;
            }
            ideologiaActualizada = (Ideologia) ideologiaActualizar.getSelectedItem();
        }else{
            ideologiaActualizada = buscarCandidatoPorCedula().getIdeologia();
        }
        if(e.getSource() == botonActualizarPartido ){
            if(partidoActualizar.getSelectedIndex() == 0){
                mostrarExcepcionSeleccionarPartido("Selecciona otra opcion diferente a esa.");
            }
            partidoActualizado = (Partidos) partidoActualizar.getSelectedItem();
        }else{
            partidoActualizado = buscarCandidatoPorCedula().getPartido();
        }

        cedula = cedulaBuscar;
        candidatoNew = new Candidato(ideologiaActualizada, partidoActualizado, votosActualizados, promesasActualizadas, nombreActualizado, cedula, ciudadActualizada);
        for (int i = 0; i < VentanaRegistrarCandidatos.listaCandidato.size(); i++) {
            if (VentanaRegistrarCandidatos.listaCandidato.get(i).getCedula().equals(cedulaBuscar)) {
                VentanaRegistrarCandidatos.listaCandidato.set(i, candidatoNew);
                break;
            }
        }    
    }private boolean contieneNumeros(String nombre){
        return nombre.matches(".*\\d+.*");
    }
    private boolean contieneLetras(String cadena){
        return cadena.matches("\\d+");
    }
    private void mostrarExcepcionSeleccionarPartido(String mensaje){
        JOptionPane.showMessageDialog(VentanaActualizarCandidato.this, "Que curiosa eleccion del partido politico \n No creo que exista así que selecciona otro. ", "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void mostrarExcepcionSeleccionarIdeologia(String mensaje){
        JOptionPane.showMessageDialog(VentanaActualizarCandidato.this, "Curiosa eleccion de ideologia. \n En colombia no existe esa ideologia pero tranqui, cuando exista lo actualizaremos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void mostrarExcepcionSeleccionarCiudad(String mensaje){
        JOptionPane.showMessageDialog(VentanaActualizarCandidato.this, "Ineresante eleccion de ciudad. \n No creo que exista :)", "Error", JOptionPane.ERROR_MESSAGE);
    }
}       