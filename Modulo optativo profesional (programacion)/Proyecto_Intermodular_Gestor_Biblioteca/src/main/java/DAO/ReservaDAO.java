package DAO;

import Conexion.ConexionDB;
import model.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public List<Reserva> listar() {

        List<Reserva> lista = new ArrayList<>();

        String sql = """
            SELECT 
                l.titulo AS libro,
                CONCAT(s.nombre,' ',s.apellido) AS socio,
                CASE 
                    WHEN r.estado = 1 THEN 'RESERVADO'
                    ELSE 'LIBRE'
                END AS estado
            FROM reserva r
            JOIN libros l ON r.id_libros = l.id_libros
            JOIN socios s ON r.id_socios = s.id_socios
        """;

        try (Statement st = ConexionDB.getConexion().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Reserva(
                        rs.getString("libro"),
                        rs.getString("socio"),
                        rs.getString("estado")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error listar reservas: " + e.getMessage());
        }

        return lista;
    }


    public void eliminarReserva(int idLibro, int idSocio) {

        String sql = "DELETE FROM reserva WHERE id_libros = ? AND id_socios = ?";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ps.setInt(2, idSocio);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error eliminar reserva: " + e.getMessage());
        }
    }


    public void reservar(int idLibro, int idSocio) {

        String sql = "INSERT INTO reserva (id_libros, id_socios, estado) VALUES (?, ?, 1)";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ps.setInt(2, idSocio);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error reserva: " + e.getMessage());
        }
    }
}