package br.com.fillipebonanome.Supermarket.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductDTO(
        @NotBlank
        String name,
        @NotBlank
        String shortName,
        @NotBlank
        String description,
        @NotNull
        Float netWeight,
        @NotBlank
        String unitOfMeasure,
        @NotBlank
        String GTIN,
        Boolean isPerishable
) {
}
