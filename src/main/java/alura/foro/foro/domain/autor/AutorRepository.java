package alura.foro.foro.domain.autor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Page<Autor> findAllByActivoTrue(Pageable paginacion);
}
