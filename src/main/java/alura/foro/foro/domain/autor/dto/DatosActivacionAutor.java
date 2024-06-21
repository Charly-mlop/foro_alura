package alura.foro.foro.domain.autor.dto;

import alura.foro.foro.domain.autor.Autor;

public record DatosActivacionAutor(
        Long id,
        String nombre,
        String activo
) {
    public DatosActivacionAutor(Autor autor) {
        this(autor.getId(), autor.getNombre(), autor.getActivo() ? "Activo" : "Inactivo");
    }
}
