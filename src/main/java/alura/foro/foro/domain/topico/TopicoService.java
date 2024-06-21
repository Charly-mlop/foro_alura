package alura.foro.foro.domain.topico;

import alura.foro.foro.domain.autor.Autor;
import alura.foro.foro.domain.autor.AutorRepository;
import alura.foro.foro.domain.topico.dto.*;
import alura.foro.foro.infra.error.AutorInactivoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public DatosTopico crearTopico(DatosCrearTopico datos){
        var autor = verificarAutor(autorRepository.getReferenceById(datos.idAutor()));
        var topico = new Topico(datos, autor);
        topicoRepository.save(topico);
        return new DatosTopico(topico);
    }

    public Page<DatosTopico> listar(Pageable paginacion) {
        var page = topicoRepository.findAllByActivoTrue(paginacion).map(DatosTopico::new);
        return page;
    }

    @Transactional
    public DatosTopicoActualizado actualizar(DatosActualizarTopico datos) {
        var topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizarDatos(datos);
        return new DatosTopicoActualizado(topico);
    }

    public void eliminar(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.eliminar(topico);
    }

    public DatosDetallesTopico getTopico(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return new DatosDetallesTopico(topico);
    }

    private Autor verificarAutor(Autor autor){
        if (!autor.getActivo()) {
            throw new AutorInactivoException("El autor no se encuentra");
        }
        return autor;
    }
}
