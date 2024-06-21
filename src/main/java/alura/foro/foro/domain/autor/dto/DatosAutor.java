package alura.foro.foro.domain.autor.dto;

import alura.foro.foro.domain.autor.Autor;

public record DatosAutor(
        Long id,
        String nombre
) {
    public DatosAutor(Autor autor){
        this(autor.getId(), autor.getNombre());
    }
}
