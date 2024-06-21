package alura.foro.foro.controller;

import alura.foro.foro.domain.topico.TopicoService;
import alura.foro.foro.domain.topico.dto.DatosActualizarTopico;
import alura.foro.foro.domain.topico.dto.DatosCrearTopico;
import alura.foro.foro.domain.topico.dto.DatosTopico;
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
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosCrearTopico datos, UriComponentsBuilder uriComponentsBuilder){
        DatosTopico topico = service.crearTopico(datos);
        var uri = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopico>> listar(@PageableDefault(size = 5, sort = {"id"}) Pageable paginacion) {
        var page = service.listar(paginacion);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallesTopico(@PathVariable Long id){
        var topico = service.getTopico(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datos) {
        var autor =  service.actualizar(datos);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
