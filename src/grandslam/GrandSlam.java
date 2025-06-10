package grandslam;

import java.util.Scanner;

public class GrandSlam {

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("TORNEO GRAND SLAM");
        System.out.println("------------------------------------");
        Scanner entrada = new Scanner(System.in);
        int participantes;
        do {
            System.out.println("Ingrese la cantidad de participantes:");
            participantes = entrada.nextInt();
            if (!Torneo.validarCantParticipantes(participantes)) {
                System.out.println("Debe ingresar un número igual a 2^n (2, 4, 8, etc...)");
                System.out.println("");
            }
        } while (!Torneo.validarCantParticipantes(participantes));

        Torneo nuevoTorneo = new Torneo(participantes);

        nuevoTorneo.armarArbolTorneo();
        int opcion = 0;
        do {
            System.out.println("");
            System.out.println("------------------MENU PRINCIPAL---------------");

            System.out.println("1: Cargar Participantes");
            System.out.println("2: Armar Primer Ronda");
            System.out.println("3: Cargar Resultados de una Fase");
            System.out.println("4: Ver Fase");
            System.out.println("5: Mostrar Torneo Completo");
            System.out.println("6: Mostrar Partido");
            System.out.println("7: Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Desea Crear Participantes Manualmente? s/n");
                    entrada.nextLine();
                    String letra = entrada.nextLine();
                    nuevoTorneo.crearParticipantes(letra);
                    break;
                case 2:
                    nuevoTorneo.armarPrimeraRonda();
                    break;
                case 3:
                    System.out.println("Ingrese el Nivel de la Fase");
                    System.out.println("1: Final");
                    System.out.println("2: Semi Final");
                    System.out.println("4: Cuartos de Final");
                    System.out.println("8: Octavos de Final");
                    System.out.println("16: Dieciseisavos de Final");
                    int opc = entrada.nextInt();
                    nuevoTorneo.cargarResultadosFase(opc);
                    break;
                case 4:
                    System.out.println("Ingrese el Nivel de la Fase");
                    System.out.println("1: Final");
                    System.out.println("2: Semi Final");
                    System.out.println("4: Cuartos de Final");
                    System.out.println("8: Octavos de Final");
                    System.out.println("16: Dieciseisavos de Final");
                    int opci = entrada.nextInt();
                    nuevoTorneo.verInstancia(opci);
                    break;
                case 5:
                    nuevoTorneo.mostrarTorneo();
                    break;
                case 6:
                    System.out.println("Elija el número del 1 al " + (participantes - 1));
                    int o = entrada.nextInt();
                    System.out.println(nuevoTorneo.busquedaPartido(o));
                    break;
                case 7:
                    System.out.println("Saliendo del Torneo");
                    break;
                default:
                    System.out.println("Opcion elegida invalida, ingrese una correcta");
                    break;
            }
        } while (opcion != 7);
        System.out.println("");
    }
}
