package DigitalHouse.ProyectoIntegrador.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AutenticacionPeticion {
    String username;
    String password;
}
