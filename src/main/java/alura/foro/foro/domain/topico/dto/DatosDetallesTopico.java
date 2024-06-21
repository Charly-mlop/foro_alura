package alura.foro.foro.domain.topico.dto;

import alura.foro.foro.domain.autor.Autor;
import alura.foro.foro.domain.autor.dto.DatosAutor;
import alura.foro.foro.domain.topico.Curso;
import alura.foro.foro.domain.topico.Topico;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        DatosAutor autor,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        String estatus,
        String curso,
        Boolean activo
) {
    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                new DatosAutor(topico.getAutor()),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getFechaActualizacion(),
                topico.getEstatus() ? "Resuelto" : "Sin resolver",
                topico.getCurso().toString(),
                topico.getActivo()
        );
    }
}
