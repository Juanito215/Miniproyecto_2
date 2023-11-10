import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prueba extends JFrame {
    private JTextField nombre, cedula, promesas, votos;

    public Prueba() {
        setTitle("Registrar Candidato");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al hacer clic en el botón de cerrar

        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        nombre = new JTextField(15);
        cedula = new JTextField(10);
        promesas = new JTextField(20);
        votos = new JTextField(5);

        JButton registrarButton = new JButton("Registrar");

        contenedor.add(new JLabel("Nombre: "));
        contenedor.add(nombre);
        contenedor.add(new JLabel("Cédula: "));
        contenedor.add(cedula);
        contenedor.add(new JLabel("Promesas: "));
        contenedor.add(promesas);
        contenedor.add(new JLabel("Votos: "));
        contenedor.add(votos);
        contenedor.add(registrarButton);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes realizar el registro del candidato
                String nombreCandidato = nombre.getText();
                String cedulaCandidato = cedula.getText();
                String promesasCandidato = promesas.getText();
                int votosCandidato = Integer.parseInt(votos.getText());

                // Realiza la operación de registro del candidato aquí

                // Limpia los campos después del registro
                nombre.setText("");
                cedula.setText("");
                promesas.setText("");
                votos.setText("");

                JOptionPane.showMessageDialog(null, "Candidato registrado con éxito.");
            }
        });

        setVisible(true);
    }
}
