package DAO;

import Conexion.ConexionDB;
import model.Libros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAO {


    public List<Libros> listar() {

        List<Libros> lista = new ArrayList<>();

        String sql = """
            SELECT 
                l.id_libros,
                l.titulo,
                l.anio_publicacion,
                l.editorial,
                a.nombre AS autor,
                COALESCE(l.estado,'DISPONIBLE') AS estado
            FROM libros l
            JOIN autores a ON l.id_autores = a.id_autores
        """;

        try (Statement st = ConexionDB.getConexion().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Libros(
                        rs.getInt("id_libros"),
                        rs.getString("titulo"),
                        rs.getString("anio_publicacion"),
                        rs.getString("editorial"),
                        rs.getString("autor"),
                        rs.getString("estado")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error libros: " + e.getMessage());
        }

        return lista;
    }


    public boolean estaReservado(int idLibro) {

        String sql = "SELECT estado FROM libros WHERE id_libros=?";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "RESERVADO".equalsIgnoreCase(rs.getString("estado"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }


    public void marcarReservado(int idLibro) {

        String sql = "UPDATE libros SET estado='RESERVADO' WHERE id_libros=?";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void marcarDisponible(int idLibro) {

        String sql = "UPDATE libros SET estado='DISPONIBLE' WHERE id_libros=?";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}