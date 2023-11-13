import javax.swing.JFrame;
import javax.swing.JTextArea;

public class VentanaVotosCandidatos extends JFrame {
    
    public VentanaVotosCandidatos(){

        JTextArea textArea = new JTextArea();
        StringBuilder votosCandidatosTexto = new StringBuilder();
        StringBuilder texto = new StringBuilder();

        texto.append("Votos de todos los candidatos \n\n");

        for(Candidato candidato: VentanaRegistrarCandidatos.listaCandidato){
            votosCandidatosTexto.append("Nombre: ").append(candidato.getNombre()).append("\n");
            votosCandidatosTexto.append("Cedula: ").append(candidato.getCedula()).append("\n");
            votosCandidatosTexto.append("Votos: ").append(candidato.getVotos()).append("\n").append("\n");
            
        }

        setTitle("Votos Candidatos");
        textArea.setText(texto.toString() + votosCandidatosTexto.toString());
        add(textArea);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
