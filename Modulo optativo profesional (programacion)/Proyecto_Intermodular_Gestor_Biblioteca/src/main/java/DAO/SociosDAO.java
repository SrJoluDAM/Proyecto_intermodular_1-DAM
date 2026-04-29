package DAO;

import Conexion.ConexionDB;
import model.Socios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SociosDAO {


    public List<Socios> listar() {

        List<Socios> lista = new ArrayList<>();

        String sql = "SELECT id_socios, nombre, apellido, email FROM socios";

        try (Statement st = ConexionDB.getConexion().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Socios(
                        rs.getInt("id_socios"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error listar socios: " + e.getMessage());
        }

        return lista;
    }


    public boolean existeSocio(int idSocio) {

        String sql = "SELECT id_socios FROM socios WHERE id_socios = ?";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error comprobar socio: " + e.getMessage());
        }

        return false;
    }

    public void insertar(Socios socio) {

        String sql = "INSERT INTO socios (nombre, apellido, email) VALUES (?, ?, ?)";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setString(1, socio.getNombre());
            ps.setString(2, socio.getApellido());
            ps.setString(3, socio.getEmail());

            ps.executeUpdate();

            System.out.println("Socio añadido correctamente");

        } catch (SQLException e) {
            System.out.println("Error insertar socio: " + e.getMessage());
        }
    }


    public void eliminar(int idSocio) {

        String sql = "DELETE FROM socios WHERE id_socios = ?";

        try (PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql)) {

            ps.setInt(1, idSocio);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println(" Socio eliminado correctamente");
            } else {
                System.out.println(" Socio no encontrado");
            }

        } catch (SQLException e) {
            System.out.println("Error eliminar socio: " + e.getMessage());
        }
    }
}