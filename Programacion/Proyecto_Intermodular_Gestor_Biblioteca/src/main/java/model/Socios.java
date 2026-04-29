package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socios {

    private int id;
    private String nombre;
    private String apellido;
    private String email;

    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " " + apellido +
                " | " + email;
    }
}