package DigitalHouse.ProyectoIntegrador.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AutenticacionRespuesta {
    String jwt;
    Long id;
}
