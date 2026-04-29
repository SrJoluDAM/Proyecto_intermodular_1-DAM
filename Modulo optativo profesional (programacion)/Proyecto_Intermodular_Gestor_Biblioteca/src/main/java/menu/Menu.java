package menu;

import service.ReservaService;
import DAO.LibrosDAO;
import DAO.SociosDAO;

import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    private final ReservaService reservaService = new ReservaService();
    private final LibrosDAO librosDAO = new LibrosDAO();
    private final SociosDAO sociosDAO = new SociosDAO();

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== GESTOR BIBLIOTECA =====");
            System.out.println("1. Ver libros");
            System.out.println("2. Ver reservas");
            System.out.println("3. Reservar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Ver socios");
            System.out.println("6. Añadir socio");
            System.out.println("7. Eliminar socio");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {


                case 1 -> librosDAO.listar().forEach(System.out::println);

                case 2 -> reservaService.verReservas();

                case 3 -> {
                    System.out.print("ID libro: ");
                    int idLibro = sc.nextInt();

                    System.out.print("ID socio: ");
                    int idSocio = sc.nextInt();

                    reservaService.reservarLibro(idLibro, idSocio);
                }


                case 4 -> {
                    System.out.print("ID libro: ");
                    int idLibro = sc.nextInt();

                    System.out.print("ID socio: ");
                    int idSocio = sc.nextInt();

                    reservaService.devolverLibro(idLibro, idSocio);
                }


                case 5 -> sociosDAO.listar().forEach(System.out::println);


                case 6 -> {
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    sociosDAO.insertar(new model.Socios(0, nombre, apellido, email));
                }


                case 7 -> {
                    System.out.print("ID socio: ");
                    int id = sc.nextInt();

                    sociosDAO.eliminar(id);
                }

                case 0 -> System.out.println("Saliendo...");

                default -> System.out.println(" Opción no válida");
            }

        } while (opcion != 0);
    }
}