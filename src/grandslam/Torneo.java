package grandslam;

import java.util.ArrayList;

public class Torneo {

    private ArrayList<Participante> participantes = new ArrayList<>();
    private int cantidadParticipantes;
    private Partido partFinal;

    public Torneo(int cantidadParticipantes) {// se debe agregar para que la cantidad sea siempre un valor de 2^n (o controlar en el main)
        this.cantidadParticipantes = cantidadParticipantes;
        this.partFinal = new Partido();
        partFinal.setNumPartido(cantidadParticipantes / 2);
        partFinal.setNivel(cantidadParticipantes / 2);
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
        int nivel = index.getNivel();
        int numIndex = index.getNumPartido(); //obtiene el nivel del nodo actual para definir el nivel de los nodos siguientes
        int numPart1 = numIndex - nivel / 2;
        int numPart2 = numIndex + nivel / 2;
        if (nivel < 2) {
            System.out.println("No se crean más instancias que la final");
        } else if (nivel == 2) {
            index.setPartido1(new Partido(numPart1));
            index.getPartido1().setNivel(1);
            System.out.println("Se agregó el partido " + numPart1 + " de nivel " + nivel / 2);
            index.setPartido2(new Partido(numPart2));
            index.getPartido2().setNivel(1);
            System.out.println("Se agregó el partido " + numPart2 + " de nivel " + nivel / 2);
        } else {
            index.setPartido1(new Partido(numPart1, nivel / 2));
            System.out.println("Se agregó el partido " + numPart1 + " de nivel " + nivel / 2);
            agregarInstancia(index.getPartido1());
            index.setPartido2(new Partido(numPart2, nivel / 2));
            agregarInstancia(index.getPartido2());
            System.out.println("Se agregó el partido " + numPart2 + " de nivel " + nivel / 2);
        }
    }

    public void mostrarTorneo() {
        mostrarPartidos(partFinal);
    }

    public void mostrarPartidos(Partido partido) {
        if (partido.getNivel() == cantidadParticipantes / 2) {
            System.out.println(partido.getNumPartido());
        }
        if (partido.getPartido1() != null && partido.getPartido2() != null) {
            mostrarPartidos(partido.getPartido1());
            System.out.println(partido.getPartido1().getNumPartido());
            mostrarPartidos(partido.getPartido2());
            System.out.println(partido.getPartido2().getNumPartido());
        }
    }

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

    public Partido verFinal() {
        return partFinal;
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
        if (cantidadParticipantes == participantes.size()) {// Se ejecuta solo si la lista de participantes está llena
            ordenarParticipantes();
            for (int i = 0; i < cantidadParticipantes / 2; i++) {
                int numPartido = 2 * i + 1;
                Participante p1 = participantes.get(i);
                Participante p2 = participantes.get(i + cantidadParticipantes / 2);
                Partido partido = busquedaPartido(numPartido);
                partido.setPart1(p1);
                partido.setPart2(p2);
                System.out.println("Partido " + numPartido + ": "+partido.getPart1().getNombreCompleto()+"(#"+partido.getPart1().getRanking()+") vs. "+partido.getPart2().getNombreCompleto()+"(#"+partido.getPart2().getRanking()+")");
            }
            System.out.println("Se han armado los partidos");
        } else {
            System.out.println("Aún hay " + (cantidadParticipantes - participantes.size()) + " cupos vacíos para el torneo. Se deben inscribir más participantes.");
        }

    }
}
