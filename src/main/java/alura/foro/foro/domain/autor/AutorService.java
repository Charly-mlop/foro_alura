package alura.foro.foro.domain.autor;

import alura.foro.foro.domain.autor.dto.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public DatosAutor crear(DatosCrearAutor crearAutor){
        var autor = new Autor(crearAutor);
        autorRepository.save(autor);
        return new DatosAutor(autor.getId(), autor.getNombre());
    }

    public Page<DatosAutor> listar(Pageable paginacion){
        var page = autorRepository.findAllByActivoTrue(paginacion).map(DatosAutor::new);
        return page;
    }

    @Transactional
    public DatosDetallesAutor actualizar(DatosActualizarAutor datos) {
       var autor = autorRepository.getReferenceById(datos.id());
       autor.actualizarDatos(datos);
       return new DatosDetallesAutor(autor.getNombre());
    }

    @Transactional
    public void eliminar(Long id) {
        var autor = autorRepository.getReferenceById(id);
        autor.eliminar();
    }

    @Transactional
    public DatosActivacionAutor activar(Long id) {
        var autor = autorRepository.getReferenceById(id);
        autor.activar();
        return new DatosActivacionAutor(autor);
    }
}
