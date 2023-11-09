import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRegistrarCandidatos extends JFrame {
        private JTextField nombreText;
        private JTextField cedulaText;
        private JButton guardarButton;

    public VentanaRegistrarCandidatos() {
        setTitle("Registrar Candidato");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        JLabel etiquetaNombre = new JLabel("Nombre: ");
        nombreText = new JTextField(20);

        JLabel etiquetaCedula = new JLabel("Cédula: ");
        cedulaText = new JTextField(10);

        guardarButton = new JButton("Guardar");

        contenedor.add(etiquetaNombre);
        contenedor.add(nombreText);
        contenedor.add(etiquetaCedula);
        contenedor.add(cedulaText);
        contenedor.add(guardarButton);

        setTitle("Registraduria");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
