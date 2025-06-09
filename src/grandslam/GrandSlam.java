package grandslam;

public class GrandSlam {

    public static void main(String[] args) {
        Torneo nuevoTorneo = new Torneo(16);
//        Participante p1 = new Participante("Gabriel Jara", "Argentina", 3);
//        Participante p2 = new Participante("Danilo Garay", "Argentina", 1);
//        Participante p3 = new Participante("Maira Lorenzoni", "Argentina", 2);
//        Participante p4 = new Participante("Juan Pérez", "Argentina", 6);
//        
//        nuevoTorneo.inscribirJugador(p1);
//        nuevoTorneo.inscribirJugador(p2);
//        nuevoTorneo.inscribirJugador(p3);
//        nuevoTorneo.inscribirJugador(p4);
//        System.out.println(nuevoTorneo.getParticipantes());
//        System.out.println("");
//        System.out.println("");
//        nuevoTorneo.ordenarParticipantes();
//        System.out.println(nuevoTorneo.getParticipantes());

        nuevoTorneo.armarArbolTorneo();

        Partido partFinal = nuevoTorneo.verFinal();

        Partido semi1 = partFinal.getPartido1();
        Partido semi2 = partFinal.getPartido2();

        Partido cuartos1 = semi1.getPartido1();
        Partido cuartos2 = semi1.getPartido2();
        Partido cuartos3 = semi2.getPartido1();
        Partido cuartos4 = semi2.getPartido2();

        System.out.println("La final es el partido número " + partFinal.getNumPartido());
        System.out.println("Las semis son los partidos número " + semi1.getNumPartido() + " y " + semi2.getNumPartido());
        System.out.println("Los cuartos son los partidos número " + cuartos1.getNumPartido() +", "+ cuartos2.getNumPartido() +", "+ cuartos3.getNumPartido() +" y "+ cuartos4.getNumPartido());
        
        nuevoTorneo.mostrarTorneo();
    }
    
    

}
