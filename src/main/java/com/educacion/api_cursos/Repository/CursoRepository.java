package com.educacion.api_cursos.Repository; // Fíjate en la 'R' mayúscula

import com.educacion.api_cursos.Model.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

  // Buscar por título ignorando mayúsculas/minúsculas
  List<Curso> findByTituloContainingIgnoreCase(String titulo);

  // Buscar cursos por precio tope
  List<Curso> findByPrecioLessThanEqual(Double precio);

  // Búsqueda combinada
  List<Curso> findByTituloContainingIgnoreCaseAndPrecioLessThanEqual(String titulo, Double precio);
}