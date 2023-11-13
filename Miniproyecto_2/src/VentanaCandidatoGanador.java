import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaCandidatoGanador extends JFrame {

    public VentanaCandidatoGanador(){
        Candidato candidatoConMasVotos = VentanaRegistrarCandidatos.listaCandidato.get(0);

        JLabel etiqueta = new JLabel();
        StringBuilder candidatoGanadorTexto = new StringBuilder();

        for (Candidato candidato: VentanaRegistrarCandidatos.listaCandidato){
            if (candidato.getVotos() > candidatoConMasVotos.getVotos()) {
                candidatoConMasVotos = candidato;
            }    
        }
        candidatoGanadorTexto.append("El candidator ganador es ").append(candidatoConMasVotos.getNombre()).append(" con ").append(candidatoConMasVotos.getVotos()).append(" votos \n");
        candidatoGanadorTexto.append("Promesas del candidato ganador: ").append(candidatoConMasVotos.getPromesas());

        setTitle("Candidato Ganador");
        etiqueta.setText(candidatoGanadorTexto.toString());
        add(etiqueta);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
