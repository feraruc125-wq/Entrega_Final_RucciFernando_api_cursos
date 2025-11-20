package com.educacion.api_cursos.Service;

import com.educacion.api_cursos.Model.Curso;
import com.educacion.api_cursos.Repository.CursoRepository;
import com.educacion.api_cursos.dto.CursoDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

  private final CursoRepository repository;

  public CursoService(CursoRepository repository) {
    this.repository = repository;
  }

  // AHORA RECIBE UN DTO
  public Curso crearCurso(CursoDTO cursoDTO) {
    // 1. Convertir DTO a Entidad
    Curso curso = new Curso();
    curso.setTitulo(cursoDTO.getTitulo());
    curso.setPrecio(cursoDTO.getPrecio());
    curso.setDescripcion(cursoDTO.getDescripcion());
    curso.setNivel(cursoDTO.getNivel());

    // 2. Guardar en BD
    return repository.save(curso);
  }

  public List<Curso> listarCursos(String titulo, Double precio) {
    // Lógica de filtros (igual que antes)
    if (titulo != null && !titulo.isEmpty() && precio != null) {
      return repository.findByTituloContainingIgnoreCaseAndPrecioLessThanEqual(titulo, precio);
    }
    if (titulo != null && !titulo.isEmpty()) {
      return repository.findByTituloContainingIgnoreCase(titulo);
    }
    if (precio != null) {
      return repository.findByPrecioLessThanEqual(precio);
    }
    return repository.findAll();
  }

  // AHORA RECIBE UN DTO PARA EDITAR
  public Curso editarCurso(Long id, CursoDTO cursoDTO) {
    Curso cursoExistente = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

    // Actualizamos con los datos del DTO
    cursoExistente.setTitulo(cursoDTO.getTitulo());
    cursoExistente.setPrecio(cursoDTO.getPrecio());
    cursoExistente.setDescripcion(cursoDTO.getDescripcion());
    cursoExistente.setNivel(cursoDTO.getNivel());

    return repository.save(cursoExistente);
  }

  public void borrarCurso(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("El curso no existe");
    }
    repository.deleteById(id);
  }
}