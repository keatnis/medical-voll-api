package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosActualizarMedico(Long id, String nombre , String documento, DatosDireccion direccion) {
}
