import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaActualizarCandidato extends JFrame {
    Container contenedor;
    FlowLayout layout;
    JLabel etiquetaActualizar;
    JTextField candidatoActualizar;
    JButton buscar, actualizar;

    ArrayList<Candidato> listaCandidato;
    public VentanaActualizarCandidato(ArrayList<Candidato> listaCandidato){
        this.listaCandidato = listaCandidato;
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
        contenedor.add(buscar);

        
    }    
}
