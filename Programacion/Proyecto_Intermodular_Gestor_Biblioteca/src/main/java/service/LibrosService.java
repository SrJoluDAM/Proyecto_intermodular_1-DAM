package service;

import DAO.LibrosDAO;

public class LibrosService {

    private final LibrosDAO librosDAO = new LibrosDAO();

    public void verLibros() {
        librosDAO.listar().forEach(System.out::println);
    }

    public void verLibrosDisponibles() {
        librosDAO.listar().forEach(System.out::println);
    }
}