package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    private String libro;
    private String socio;
    private String estado;

    @Override
    public String toString() {

        return "\nLibro: " + libro +
                "\nSocio: " + socio +
                "\nEstado: " + estado + "\n";
    }
}