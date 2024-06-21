package alura.foro.foro.domain.autor;

import alura.foro.foro.domain.autor.dto.DatosActualizarAutor;
import alura.foro.foro.domain.autor.dto.DatosCrearAutor;
import alura.foro.foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Autor")
@Table(name = "autores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;
    private Boolean activo;

    public Autor(DatosCrearAutor autor) {
        this.nombre = autor.nombre();
        this.topicos =  new ArrayList<>();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarAutor datos){
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
    }

    public void eliminar() {
        this.activo = false;
    }

    public void activar(){
        this.activo = true;
    }
}
