package br.com.fillipebonanome.Supermarket.dto.product;

import br.com.fillipebonanome.Supermarket.entity.Product;

public record ReadProductDTO(
    Long id,
    String name,
    String shortName,
    String description,
    Float netWeight,
    String unitOfMeasure,
    String GTIN,
    Boolean isPerishable
) {
    public ReadProductDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getShortName(),
                product.getDescription(),
                product.getNetWeight(),
                product.getUnitOfMeasure(),
                product.getGTIN(),
                product.getIsPerishable()
        );
    }
}
