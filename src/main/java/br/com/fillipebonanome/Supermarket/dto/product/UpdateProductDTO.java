package br.com.fillipebonanome.Supermarket.dto.product;

public record UpdateProductDTO(
        String name,
        String shortName,
        String description,
        Float netWeight,
        String unitOfMeasure,
        String GTIN,
        Boolean isPerishable
) {
}
