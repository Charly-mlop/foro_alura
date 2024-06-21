package alura.foro.foro.domain.topico.dto;

import alura.foro.foro.domain.autor.dto.DatosAutor;
import alura.foro.foro.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosTopico(
        Long id,
        String titulo,
        DatosAutor autor,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String estatus,
        String cursos
) {
        public DatosTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                new DatosAutor(topico.getAutor()),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstatus() ? "Resuelto" : "Sin resolver",
                topico.getCurso().toString());
        }
}
