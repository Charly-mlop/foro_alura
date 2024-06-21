package alura.foro.foro.domain.topico;

import alura.foro.foro.domain.autor.Autor;
import alura.foro.foro.domain.topico.dto.DatosActualizarTopico;
import alura.foro.foro.domain.topico.dto.DatosCrearTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private Boolean estatus;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private Boolean activo;
    private LocalDateTime fechaActualizacion;



    public Topico(DatosCrearTopico crearTopico, Autor autor) {
        this.titulo = crearTopico.titulo();
        this.mensaje = crearTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estatus = false;
        this.autor = autor;
        this.curso = crearTopico.curso();
        this.activo = true;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null){
            this.curso = datos.curso();
        }
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void eliminar(Topico topico) {
        this.activo = false;
    }
}
