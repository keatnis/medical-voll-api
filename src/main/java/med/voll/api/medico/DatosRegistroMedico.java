package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(
        // no acepta valores vacios
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{10}")
        String telefono,
        @NotBlank
        //para agregar expresiones regulares usamos @Pattern
        @Pattern(regexp = "\\d{4,6}")
        String documento,
        @NotNull
        Especialidad especialidad,
        // not null porque DatosDireccion es un objeto
        @NotNull
        DatosDireccion direccion

) {
}
