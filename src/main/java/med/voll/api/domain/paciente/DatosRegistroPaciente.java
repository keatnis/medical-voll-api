package med.voll.api.domain.paciente;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String telefono,
        @JsonAlias("documento_identidad")
        @NotBlank @Pattern(regexp = "\\d{3,6}")
        String documentoIdentidad,
        @NotNull @Valid DatosDireccion direccion
) {

}


