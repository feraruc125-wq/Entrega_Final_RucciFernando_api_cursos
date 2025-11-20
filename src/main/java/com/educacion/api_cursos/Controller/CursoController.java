package com.educacion.api_cursos.Controller;

import com.educacion.api_cursos.Model.Curso;
import com.educacion.api_cursos.Service.CursoService;
import com.educacion.api_cursos.dto.CursoDTO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

  private final CursoService service;

  public CursoController(CursoService service) {
    this.service = service;
  }

  @PostMapping
  // Recibe CursoDTO validado
  public Curso crear(@Valid @RequestBody CursoDTO cursoDTO) {
    return service.crearCurso(cursoDTO);
  }

  @GetMapping
  public List<Curso> listar(
      @RequestParam(required = false) String titulo,
      @RequestParam(required = false) Double precio) {
    return service.listarCursos(titulo, precio);
  }

  @PutMapping("/{id}")
  // Recibe CursoDTO validado
  public Curso editar(@PathVariable Long id, @Valid @RequestBody CursoDTO cursoDTO) {
    return service.editarCurso(id, cursoDTO);
  }

  @DeleteMapping("/{id}")
  public String borrar(@PathVariable Long id) {
    service.borrarCurso(id);
    return "Curso eliminado correctamente con ID: " + id;
  }
}