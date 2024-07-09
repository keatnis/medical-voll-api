package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizacionDireccion(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento) {
}
