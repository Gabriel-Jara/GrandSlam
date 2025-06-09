package grandslam;

public class Partido {
    private int nivel; //Define la instancia... si son 16 equipos, el nivel de la final es nivel 8. Las semis serán nivel 4, cuartos serán nivel 2 y octavos nivel 1.
    private int numPartido;
    private Participante part1;
    private Participante part2;
    private Partido partido1;
    private Partido partido2;
    private Participante ganador;
    private int punt1;
    private int punt2;

    public Partido() {
    }

    public Partido(int numPartido) {
        this.numPartido = numPartido;
    }
    public Partido(int numPartido, int nivel) {
        this.numPartido = numPartido;
        this.nivel = nivel;
    }
    
    public Partido (Participante part1, Participante part2){
        this.part1=part1;
        this.part2=part2;
    }

    public void setNumPartido(int numPartido) {
        this.numPartido = numPartido;
    }
    
    public void setPartido1(Partido partido){
        this.partido1 = partido;
    }

    public int getNumPartido() {
        return numPartido;
    }
    public void setPartido2(Partido partido){
        this.partido2 = partido;
    }

    public Participante getPart1() {
        return part1;
    }

    public void setPart1(Participante part1) {
        this.part1 = part1;
    }

    public Participante getPart2() {
        return part2;
    }

    public void setPart2(Participante part2) {
        this.part2 = part2;
    }

    public int getPunt1() {
        return punt1;
    }

    public void setPunt1(int punt1) {
        this.punt1 = punt1;
    }

    public int getPunt2() {
        return punt2;
    }

    public void setPunt2(int punt2) {
        this.punt2 = punt2;
    }

    public Partido getPartido1() {
        return partido1;
    }

    public Partido getPartido2() {
        return partido2;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
