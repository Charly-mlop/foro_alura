package alura.foro.foro.domain.autor.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarAutor(
        Long id,
        @NotNull
        String nombre
) {
}
