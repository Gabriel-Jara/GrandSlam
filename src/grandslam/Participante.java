package grandslam;

public class Participante {

    private String nombreCompleto;
    private String nacionalidad;
    private int ranking;

    public Participante(String nombreCompleto, String nacionalidad, int ranking) {
        this.nombreCompleto = nombreCompleto;
        this.nacionalidad = nacionalidad;
        this.ranking = ranking;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-25s", "(#" + ranking + ")",nombreCompleto + " ["+ nacionalidad.substring(0, 3).toUpperCase()+"]");
    }

}
