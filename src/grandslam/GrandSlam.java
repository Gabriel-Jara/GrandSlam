package grandslam;

public class GrandSlam {

    public static void main(String[] args) {
        Torneo nuevoTorneo = new Torneo(32);

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
        System.out.println("Los cuartos son los partidos número " + cuartos1.getNumPartido() + ", " + cuartos2.getNumPartido() + ", " + cuartos3.getNumPartido() + " y " + cuartos4.getNumPartido());

        nuevoTorneo.armarPrimeraRonda();

        Participante p1 = new Participante("Carlos Gómez", "Argentina", 1);
        Participante p2 = new Participante("Lucía Fernández", "España", 2);
        Participante p3 = new Participante("Tomás Silva", "Uruguay", 3);
        Participante p4 = new Participante("Ana Torres", "México", 4);
        Participante p5 = new Participante("Pedro Rojas", "Chile", 5);
        Participante p6 = new Participante("Elena Díaz", "Colombia", 6);
        Participante p7 = new Participante("Mateo López", "Perú", 7);
        Participante p8 = new Participante("Sofía Vargas", "Paraguay", 8);
        Participante p9 = new Participante("Andrés Pérez", "Argentina", 9);
        Participante p10 = new Participante("Claudia Romero", "México", 10);
        Participante p11 = new Participante("Julián Ortega", "Colombia", 11);
        Participante p12 = new Participante("Marina López", "Chile", 12);
        Participante p13 = new Participante("Federico Torres", "Uruguay", 13);
        Participante p14 = new Participante("Valentina Ruiz", "Perú", 14);
        Participante p15 = new Participante("Diego Ríos", "Venezuela", 15);
        Participante p16 = new Participante("Isabela Martínez", "Bolivia", 16);
        Participante p17 = new Participante("Sebastián Núñez", "Ecuador", 17);
        Participante p18 = new Participante("Camila Herrera", "Guatemala", 18);
        Participante p19 = new Participante("Martín Castro", "Honduras", 19);
        Participante p20 = new Participante("Paula Suárez", "Costa Rica", 20);
        Participante p21 = new Participante("Lucas Reyes", "Panamá", 21);
        Participante p22 = new Participante("Natalia Molina", "Nicaragua", 22);
        Participante p23 = new Participante("Alejandro Paredes", "El Salvador", 23);
        Participante p24 = new Participante("Renata Salas", "Cuba", 24);
        Participante p25 = new Participante("Gonzalo Méndez", "Puerto Rico", 25);
        Participante p26 = new Participante("Daniela Cabrera", "República Dominicana", 26);
        Participante p27 = new Participante("Iván Delgado", "España", 27);
        Participante p28 = new Participante("Florencia Ibáñez", "Argentina", 28);
        Participante p29 = new Participante("Enzo Aguirre", "México", 29);
        Participante p30 = new Participante("Luciana Soto", "Chile", 30);
        Participante p31 = new Participante("Rodrigo Varela", "Colombia", 31);
        Participante p32 = new Participante("Julieta Ramírez", "Uruguay", 32);

        nuevoTorneo.inscribirJugador(p1);
        nuevoTorneo.inscribirJugador(p2);
        nuevoTorneo.inscribirJugador(p3);
        nuevoTorneo.inscribirJugador(p4);
        nuevoTorneo.inscribirJugador(p5);
        nuevoTorneo.inscribirJugador(p6);
        nuevoTorneo.inscribirJugador(p7);

        nuevoTorneo.armarPrimeraRonda();

        nuevoTorneo.inscribirJugador(p8);
        nuevoTorneo.inscribirJugador(p9);
        nuevoTorneo.inscribirJugador(p10);
        nuevoTorneo.inscribirJugador(p11);
        nuevoTorneo.inscribirJugador(p12);
        nuevoTorneo.inscribirJugador(p13);
        nuevoTorneo.inscribirJugador(p14);
        nuevoTorneo.inscribirJugador(p15);
        nuevoTorneo.inscribirJugador(p16);
        nuevoTorneo.inscribirJugador(p17);
        nuevoTorneo.inscribirJugador(p18);
        nuevoTorneo.inscribirJugador(p19);
        nuevoTorneo.inscribirJugador(p20);
        nuevoTorneo.inscribirJugador(p21);
        nuevoTorneo.inscribirJugador(p22);
        nuevoTorneo.inscribirJugador(p23);
        nuevoTorneo.inscribirJugador(p24);
        nuevoTorneo.inscribirJugador(p25);
        nuevoTorneo.inscribirJugador(p26);
        nuevoTorneo.inscribirJugador(p27);
        nuevoTorneo.inscribirJugador(p28);
        nuevoTorneo.inscribirJugador(p29);
        nuevoTorneo.inscribirJugador(p30);
        nuevoTorneo.inscribirJugador(p31);
        nuevoTorneo.inscribirJugador(p32);

        nuevoTorneo.armarPrimeraRonda();

    }
}
