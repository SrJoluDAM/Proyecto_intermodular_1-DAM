package service;

import DAO.LibrosDAO;
import DAO.ReservaDAO;
import DAO.SociosDAO;

import java.util.List;

public class ReservaService {

    private final ReservaDAO reservaDAO = new ReservaDAO();
    private final LibrosDAO librosDAO = new LibrosDAO();
    private final SociosDAO sociosDAO = new SociosDAO();


    public void verReservas() {

        List<?> reservas = reservaDAO.listar();

        if (reservas.isEmpty()) {
            System.out.println(" No hay reservas actualmente");
            return;
        }

        reservas.forEach(System.out::println);
    }


    public void reservarLibro(int idLibro, int idSocio) {


        if (!sociosDAO.existeSocio(idSocio)) {
            System.out.println(" Socio no encontrado");
            return;
        }


        if (librosDAO.estaReservado(idLibro)) {
            System.out.println(" Este libro ya está reservado");
            return;
        }

        reservaDAO.reservar(idLibro, idSocio);
        librosDAO.marcarReservado(idLibro);

        System.out.println("Reserva realizada correctamente");
    }


    public void devolverLibro(int idLibro, int idSocio) {


        if (!sociosDAO.existeSocio(idSocio)) {
            System.out.println(" Socio no encontrado");
            return;
        }


        if (!librosDAO.estaReservado(idLibro)) {
            System.out.println(" ERROR: Libro no reservado");
            return;
        }

        reservaDAO.eliminarReserva(idLibro, idSocio);
        librosDAO.marcarDisponible(idLibro);

        System.out.println(" Libro devuelto correctamente");
    }
}