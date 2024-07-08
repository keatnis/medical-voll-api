package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;

public record DatosActualizarMedico(Long id, String nombre , String documento, DatosDireccion direccion) {
}
