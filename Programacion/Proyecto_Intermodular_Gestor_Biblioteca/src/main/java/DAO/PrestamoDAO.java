package DAO;

import Conexion.ConexionDB;
import model.Prestamo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public List<Prestamo> listar() {

        List<Prestamo> lista = new ArrayList<>();


  String sql = """
        SELECT
        l.titulo AS libro,
                CONCAT(s.nombre,' ',s.apellido) AS socio,
        p.fecha_incio
        FROM prestamo p
        JOIN libros l ON p.id_libro = l.id_libros
        JOIN socios s ON p.id_socio = s.id_socios
        """;
                try (Statement st = ConexionDB.getConexion().createStatement();
                     ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        lista.add(new Prestamo(
                                rs.getString("libro"),
                                rs.getString("socio"),
                                rs.getString("fecha_incio")
                        ));
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                return lista;
            }
        }
