package grandslam;

import java.util.ArrayList;
import java.util.Scanner;

public class Torneo {

    private ArrayList<Participante> participantes = new ArrayList<>();
    private int cantidadParticipantes;
    private Partido partFinal;
    private Scanner entrada = new Scanner(System.in);

    public Torneo(int cantidadParticipantes) {// se debe agregar para que la cantidad sea siempre un valor de 2^n (o controlar en el main)
        this.cantidadParticipantes = cantidadParticipantes;
        this.partFinal = new Partido();
        partFinal.setNumPartido(cantidadParticipantes / 2);
        partFinal.setNivel(cantidadParticipantes / cantidadParticipantes);
    }

    public void inscribirJugador(Participante jugador) {
        if (participantes.size() < cantidadParticipantes) {
            participantes.add(jugador);
            System.out.println("Se inscribió al jugador: " + jugador);
        } else {
            System.out.println("Ya se llenó el cupo de jugadores");
        }
    }

    public void armarArbolTorneo() {
        agregarInstancia(partFinal);
    }

    public void agregarInstancia(Partido index) {
        int numFinal = partFinal.getNumPartido(); //2
        int nivelActual = index.getNivel();
        int nivelSiguiente = nivelActual * 2;
        int diferencia = numFinal / nivelSiguiente;
        int numIndex = index.getNumPartido(); //obtiene el nivel del nodo actual para definir el nivel de los nodos siguientes
        int numPart1 = numIndex - diferencia;
        int numPart2 = numIndex + diferencia;
        if (cantidadParticipantes == 2) {
            System.out.println("No se crean más instancias que la final");
        } else if (nivelActual == cantidadParticipantes / 4) {
            index.setPartido1(new Partido(numPart1));
            index.getPartido1().setNivel(cantidadParticipantes / 2);
//            System.out.println("Se agregó el partido " + numPart1 + " de nivel " + cantidadParticipantes / 2);
            index.setPartido2(new Partido(numPart2));
            index.getPartido2().setNivel(cantidadParticipantes / 2);
//            System.out.println("Se agregó el partido " + numPart2 + " de nivel " + cantidadParticipantes / 2);
        } else {
            index.setPartido1(new Partido(numPart1, nivelSiguiente));
//            System.out.println("Se agregó el partido " + numPart1 + " de nivel " + nivelSiguiente);
            agregarInstancia(index.getPartido1());
            index.setPartido2(new Partido(numPart2, nivelSiguiente));
            agregarInstancia(index.getPartido2());
//            System.out.println("Se agregó el partido " + numPart2 + " de nivel " + nivelSiguiente);
        }
    }

    public void mostrarTorneo() {
        System.out.println("--------------------------------------------------------");
        System.out.println("TORNEO");
        System.out.println("--------------------------------------------------------");
//        mostrarPartidos(partFinal);
        int cantInstancias = (int) (Math.log10(cantidadParticipantes) / Math.log10(2));
        for (int i = 0; i < cantInstancias; i++) {
            verInstancia((int) Math.pow(2, i));
        }
    }

//    private void mostrarPartidos(Partido partido) {
//
//        if (partido.getPartido1() != null && partido.getPartido2() != null) {
//            mostrarPartidos(partido.getPartido1());
//            System.out.println("Partido N°" + partido.getPartido1().getNumPartido() + " ");
//            verResultado(partido.getPartido1());
//            if (partido.getNivel() == 1) {
//                System.out.println("Partido N°" + partido.getNumPartido() + " ");
//                verResultado(partido);
//            }
//            mostrarPartidos(partido.getPartido2());
//            System.out.println("Partido N°" + partido.getPartido2().getNumPartido() + " ");
//            verResultado(partido.getPartido2());
//        }
//    }
    private void ordenarParticipantes() {
        //insertionSort
        int cantidad = participantes.size();
        for (int i = 0; i < cantidad; i++) {
            Participante aux = participantes.remove(i);
            int j = i;
            while (j > 0 && participantes.get(j - 1).getRanking() > aux.getRanking()) {
                participantes.add(j, participantes.get(j - 1));
                participantes.remove(j - 1);
                j = j - 1;
            }
            participantes.add(j, aux);
        }
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public Partido busquedaPartido(int numPartido) {
        return buscarPartido(partFinal, numPartido);
    }

    private Partido buscarPartido(Partido index, int numero) {
        if (numero < cantidadParticipantes && numero > 0) {
            if (numero == index.getNumPartido()) {
                return index;
            } else if (numero < index.getNumPartido()) {
                return buscarPartido(index.getPartido1(), numero);
            } else {
                return buscarPartido(index.getPartido2(), numero);
            }
        } else {
            System.out.println("No existe el partido con el número indicado");
            return null;
        }
    }

    public void armarPrimeraRonda() {

        System.out.println("--------------------------------------------------------");
        System.out.println("Primera Ronda");
        System.out.println("--------------------------------------------------------");

        if (cantidadParticipantes == participantes.size()) {// Se ejecuta solo si la lista de participantes está llena
            ordenarParticipantes();
            for (int i = 0; i < cantidadParticipantes / 2; i++) {
                int numPartido = 2 * i + 1;
                Participante p1 = participantes.get(i);
                Participante p2 = participantes.get(i + cantidadParticipantes / 2);
                Partido partido = busquedaPartido(numPartido);
                partido.setPart1(p1);
                partido.setPart2(p2);
                System.out.printf("%-11s %-30s", "Partido " + numPartido + ":", partido.getPart1() + " VS. " + partido.getPart2());
                System.out.println("");
            }
            System.out.println("Se han armado los partidos");
        } else {
            System.out.println("Aún hay " + (cantidadParticipantes - participantes.size()) + " cupos vacíos para el torneo. Se deben inscribir más participantes.");
        }
    }

    public void verResultado(Partido partido) {
        String resultado;
        String jugador1;
        String jugador2;

        if (partido.getPart1() == null) {
            jugador1 = "Ganador Part." + partido.getPartido1().getNumPartido();
        } else {
            jugador1 = partido.getPart1().toString();
        }

        if (partido.getPart2() == null) {
            jugador2 = "Ganador Part." + partido.getPartido2().getNumPartido();
        } else {
            jugador2 = partido.getPart2().toString();
        }

        if (partido.getPunt1() == -1 || partido.getPunt2() == -1) {
            resultado = " (A jugar) ";
        } else {
            resultado = "    " + partido.getPunt1() + "-" + partido.getPunt2() + "    ";
        }
        System.out.println(jugador1 + resultado + jugador2);
    }

    public void cargarResultado(Partido partido, int punt1, int punt2) {
        if(partido.getPart1()!= null && partido.getPart2()!=null){
        partido.setPunt1(punt1);
        partido.setPunt2(punt2);

        avanzarGanadores();
            
        } else {
            System.out.println("No se puede cargar el resultado porque falta alguno de los participantes");
        }
    }

    public void cargarResultadosFase(int nivel) {
        ArrayList<Partido> partidosFase = verInstancia(nivel);
        int punt1;
        int punt2;
        for (Partido partido : partidosFase) {
            System.out.println("Partido N° " + partido.getNumPartido() + ":");
            verResultado(partido);

            do {
                System.out.println("Ingrese el puntaje de " + partido.getPart1());
                punt1 = entrada.nextInt();
                System.out.println("Ingrese el puntaje de " + partido.getPart2());
                punt2 = entrada.nextInt();
                if (punt1 == punt2) {
                    System.out.println("Los puntos no pueden ser iguales. Ingrese nuevamente la puntuación");
                }
            } while (punt1 == punt2);

            cargarResultado(partido, punt1, punt2);
        }
    }

    public void avanzarGanadores() {
        avanzarInstancia(partFinal);
    }

    private void avanzarInstancia(Partido partido) {
        if (partido.getPartido1() != null && partido.getPartido2() != null) {
            avanzarInstancia(partido.getPartido1());
            int punt1 = partido.getPartido1().getPunt1();
            int punt2 = partido.getPartido1().getPunt2();
            if (punt1 != -1 && punt2 != -1) {
                if (punt1 > punt2) {
                    partido.setPart1(partido.getPartido1().getPart1());
                } else {
                    partido.setPart1(partido.getPartido1().getPart2());
                }
            }
            avanzarInstancia(partido.getPartido2());
            punt1 = partido.getPartido2().getPunt1();
            punt2 = partido.getPartido2().getPunt2();
            if (punt1 != -1 && punt2 != -1) {
                if (punt1 > punt2) {
                    partido.setPart2(partido.getPartido2().getPart1());
                } else {
                    partido.setPart2(partido.getPartido2().getPart2());
                }
            }

        }
    }

    private String nombrarInstancia(int nivel) {
        String instancia;
        switch (nivel) {
            case 1:
                instancia = "Final";
                break;
            case 2:
                instancia = "Semifinal";
                break;
            case 4:
                instancia = "4tos de final";
                break;
            default:
                instancia = nivel + "vos de final";
        }
        return instancia;
    }

    public ArrayList<Partido> verInstancia(int nivel) {
        System.out.println("-----------------------------");
        System.out.println(nombrarInstancia(nivel));
        System.out.println("-----------------------------");
        ArrayList<Partido> partidos = new ArrayList();
        verInstanciaPartido(partFinal, nivel, partidos);

        return partidos;
    }

    private void verInstanciaPartido(Partido partido, int nivel, ArrayList<Partido> partidos) {

        if (partido.getNivel() == nivel) {
            System.out.println("Partido N°" + partido.getNumPartido() + ": ");
            partidos.add(partido);
            verResultado(partido);
            System.out.println("");
        } else if (partido.getPartido1() != null && partido.getPartido2() != null) {
            verInstanciaPartido(partido.getPartido1(), nivel, partidos);
            verInstanciaPartido(partido.getPartido2(), nivel, partidos);
        }
    }

    public static boolean validarCantParticipantes(int cantidad) {
        double resultado = cantidad;
        boolean esValido = false;
        do {
            resultado = resultado / 2;
        } while (resultado > 1);
        if (resultado == 1) {
            esValido = true;
        }

        return esValido;
    }
    public void crearParticipantes(String letra) {
        String opc = "";

        if (letra.equalsIgnoreCase("s")) {
            do {
                System.out.println("Ingrese nombre completo del Participante");
                String nombre = entrada.nextLine();
                System.out.println("Ingrese Nacionalidad del Participante");
                String nacionalidad = entrada.nextLine();
                entrada.nextLine();
                System.out.println("Ingrese Ranking del Participante");
                int rank = entrada.nextInt();
                Participante p = new Participante(nombre, nacionalidad, rank);
                inscribirJugador(p);
                entrada.nextLine();
                System.out.println("Desea agregar otro Participante? s/n");
                opc = entrada.nextLine();

            } while (opc.equalsIgnoreCase("s"));
        } else {
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
            Participante p23 = new Participante("Alejandro Paredes", "Salvador", 23);
            Participante p24 = new Participante("Renata Salas", "Cuba", 24);
            Participante p25 = new Participante("Gonzalo Méndez", "Puerto Rico", 25);
            Participante p26 = new Participante("Daniela Cabrera", "República Dominicana", 26);
            Participante p27 = new Participante("Iván Delgado", "España", 27);
            Participante p28 = new Participante("Florencia Ibáñez", "Argentina", 28);
            Participante p29 = new Participante("Enzo Aguirre", "México", 29);
            Participante p30 = new Participante("Luciana Soto", "Chile", 30);
            Participante p31 = new Participante("Rodrigo Varela", "Colombia", 31);
            Participante p32 = new Participante("Julieta Ramírez", "Uruguay", 32);

           inscribirJugador(p1);
           inscribirJugador(p2);
           inscribirJugador(p3);
           inscribirJugador(p4);
           inscribirJugador(p5);
           inscribirJugador(p6);
           inscribirJugador(p7);
           inscribirJugador(p8);
           inscribirJugador(p9);
           inscribirJugador(p10);
           inscribirJugador(p11);
           inscribirJugador(p12);
           inscribirJugador(p13);
           inscribirJugador(p14);
           inscribirJugador(p15);
           inscribirJugador(p16);
           inscribirJugador(p16);
           inscribirJugador(p16);
           inscribirJugador(p17);
           inscribirJugador(p18);
           inscribirJugador(p19);
           inscribirJugador(p20);
           inscribirJugador(p21);
           inscribirJugador(p22);
           inscribirJugador(p23);
           inscribirJugador(p24);
           inscribirJugador(p25);
           inscribirJugador(p26);
           inscribirJugador(p27);
           inscribirJugador(p28);
           inscribirJugador(p29);
           inscribirJugador(p30);
           inscribirJugador(p31);
            inscribirJugador(p32);

        }
    }
}
