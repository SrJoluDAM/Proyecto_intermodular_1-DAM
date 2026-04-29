package service;

import DAO.SociosDAO;

public class SociosService {

    private final SociosDAO sociosDAO = new SociosDAO();

    public void verSocios() {
        sociosDAO.listar().forEach(System.out::println);
    }
}