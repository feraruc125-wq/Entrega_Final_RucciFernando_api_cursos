package com.educacion.api_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data // Genera getters, setters, toString, etc.
public class CursoDTO {

  // No ponemos ID aquí porque al crear un curso no enviamos ID
  private Long id;

  @NotBlank(message = "El título no puede estar vacío")
  private String titulo;

  @NotNull(message = "El precio es obligatorio")
  @Min(value = 0, message = "El precio no puede ser negativo")
  private Double precio;

  @NotBlank(message = "La descripción es obligatoria")
  private String descripcion;

  @NotBlank(message = "El nivel es obligatorio")
  private String nivel;
}