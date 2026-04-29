package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libros {

    private int id;
    private String titulo;
    private String anio_publicacion;
    private String editorial;
    private String autor;
    private String estado;

    @Override
    public String toString() {

        String est = (estado == null || estado.isBlank())
                ? "DISPONIBLE"
                : estado;

        return "\nID: " + id +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor +
                "\nAño: " + anio_publicacion +
                "\nEditorial: " + editorial +
                "\nEstado: " + est + "\n";
    }
}