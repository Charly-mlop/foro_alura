package alura.foro.foro.controller;

import alura.foro.foro.domain.autor.AutorService;
import alura.foro.foro.domain.autor.dto.DatosActualizarAutor;
import alura.foro.foro.domain.autor.dto.DatosAutor;
import alura.foro.foro.domain.autor.dto.DatosCrearAutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping
    public ResponseEntity crear (@RequestBody @Valid DatosCrearAutor datos, UriComponentsBuilder uriComponentsBuilder){
        DatosAutor autor = service.crear(datos);
        var uri = uriComponentsBuilder.path("autores/{id}").buildAndExpand(autor.id()).toUri();
        return ResponseEntity.created(uri).body(autor);
    }

    @GetMapping
    public ResponseEntity<Page<DatosAutor>> listar(@PageableDefault(size = 5, sort = {"nombre"}) Pageable paginacion) {
        var page = service.listar(paginacion);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarAutor datos) {
        var autor =  service.actualizar(datos);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity activar(@PathVariable Long id) {
        var autor = service.activar(id);
        return ResponseEntity.ok(autor);
    }
}
