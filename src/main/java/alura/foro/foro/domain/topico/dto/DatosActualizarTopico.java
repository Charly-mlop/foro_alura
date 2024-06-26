package alura.foro.foro.domain.topico.dto;

import alura.foro.foro.domain.topico.Curso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Curso curso
) {
}
