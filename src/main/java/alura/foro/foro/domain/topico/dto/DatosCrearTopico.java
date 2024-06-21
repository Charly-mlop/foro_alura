package alura.foro.foro.domain.topico.dto;

import alura.foro.foro.domain.autor.dto.DatosCrearAutor;
import alura.foro.foro.domain.topico.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DatosCrearTopico(
        @NotNull
        @Valid
        Long idAutor,
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Curso curso
) {
}
