package grandslam;

public class GrandSlam {


    public static void main(String[] args) {
        Torneo nuevoTorneo = new Torneo(8);
        Participante p1 = new Participante("Gabriel Jara", "Argentina", 3);
        Participante p2 = new Participante("Danilo Garay", "Argentina", 1);
        Participante p3 = new Participante("Maira Lorenzoni", "Argentina", 2);
        Participante p4 = new Participante("Juan Pérez", "Argentina", 6);
        Participante p5 = new Participante("Miguel Díaz", "Argentina", 7);
        Participante p6 = new Participante("Luciana López", "Argentina", 5);
        Participante p7 = new Participante("Laura Gómez", "Argentina", 8);
        Participante p8 = new Participante("Pablo Morales", "Argentina", 4);
        
        nuevoTorneo.inscribirJugador(p1);
        nuevoTorneo.inscribirJugador(p2);
        nuevoTorneo.inscribirJugador(p3);
        nuevoTorneo.inscribirJugador(p4);
        nuevoTorneo.inscribirJugador(p5);
        nuevoTorneo.inscribirJugador(p6);
        nuevoTorneo.inscribirJugador(p7);
        nuevoTorneo.inscribirJugador(p8);
        System.out.println(nuevoTorneo.getParticipantes());
        System.out.println("");
        System.out.println("");
        nuevoTorneo.ordenarParticipantes();
        System.out.println(nuevoTorneo.getParticipantes());
    }

}
