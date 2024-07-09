package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.Direccion;

public record DatosRespuestaMedico(String nombre, String email, String telefono, String documentoIdentidad, Direccion direccion) {
    public DatosRespuestaMedico(Medico medico) {
        this(medico.getNombre(), medico.getEmail(), medico.getTelefono(), medico.getDocumento(), medico.getDireccion());
    }
}