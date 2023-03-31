package edu.danton.carsapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarDTO(
  @NotBlank
  String modelo,
  
  @NotBlank
  String fabricante,

  @NotBlank
  String dataFabricacao,

  @NotNull
  double valor,

  @NotNull
  int anoModelo
){}
