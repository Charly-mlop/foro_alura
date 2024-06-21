package alura.foro.foro.domain.topico.dto;

import alura.foro.foro.domain.autor.dto.DatosAutor;
import alura.foro.foro.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosTopicoActualizado(
        Long id,
        String titulo,
        DatosAutor autor,
        String mensaje,
        String estatus,
        String cursos,
        LocalDateTime fechaDeCreacion,
        LocalDateTime fechaActualizacion
) {
public DatosTopicoActualizado(Topico topico) {
        this(
        topico.getId(),
        topico.getTitulo(),
        new DatosAutor(topico.getAutor()),
        topico.getMensaje(),
        topico.getEstatus() ? "Resuelto" : "Sin resolver",
        topico.getCurso().toString(),
        topico.getFechaCreacion(),
        topico.getFechaActualizacion());
        }
}
