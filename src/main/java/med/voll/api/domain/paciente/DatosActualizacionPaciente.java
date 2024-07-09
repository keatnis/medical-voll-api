package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosActualizacionDireccion;

public record DatosActualizacionPaciente(
        Long id,
        String nombre,
        String telefono,
        @Valid DatosActualizacionDireccion direccion
) {
}