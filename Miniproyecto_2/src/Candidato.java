public class Candidato extends Ciudadano {
    private Ideologia ideologia;
    private Partidos partido;
    private int votos;
    private String promesas;

    public Candidato(Ideologia ideologia, Partidos partido, int votos, String promesas, String nombre, String cedula, Ciudades ciudad){
        super(nombre, cedula, ciudad);
        this.ideologia = ideologia;
        this.partido = partido;
        this.promesas = promesas;
        this.votos = votos;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public Partidos getPartido() {
        return partido;
    }

    public void setPartido(Partidos partido) {
        this.partido = partido;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getPromesas() {
        return promesas;
    }

    public void setPromesas(String promesas) {
        this.promesas = promesas;
    }
    
}
