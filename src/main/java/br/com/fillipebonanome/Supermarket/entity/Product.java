package br.com.fillipebonanome.Supermarket.entity;

import br.com.fillipebonanome.Supermarket.dto.product.CreateProductDTO;
import br.com.fillipebonanome.Supermarket.dto.product.UpdateProductDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String shortName;

    @NotBlank
    private String description;

    @NotNull
    private Float netWeight;

    @NotBlank
    private String unitOfMeasure;

    @NotBlank @Column(name="gtin", unique = true)
    private String GTIN;

    private Boolean isPerishable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(@Valid CreateProductDTO productDTO) {
        this.name = productDTO.name();
        this.shortName = productDTO.shortName();
        this.description = productDTO.description();
        this.netWeight = productDTO.netWeight();
        this.unitOfMeasure = productDTO.unitOfMeasure();
        this.GTIN = productDTO.GTIN();
        this.isPerishable = productDTO.isPerishable();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(UpdateProductDTO productDTO) {
        if(productDTO.name() != null && !productDTO.name().isBlank()) {
            this.name = productDTO.name();
        }
        if(productDTO.shortName() != null && !productDTO.shortName().isBlank()) {
            this.shortName = productDTO.shortName();
        }
        if(productDTO.description() != null && !productDTO.description().isBlank()) {
            this.description = productDTO.description();
        }
        if(productDTO.netWeight() != null) {
            this.netWeight = productDTO.netWeight();
        }
        if(productDTO.unitOfMeasure() != null && !productDTO.unitOfMeasure().isBlank()) {
            this.unitOfMeasure = productDTO.unitOfMeasure();
        }
        if(productDTO.GTIN() != null && !productDTO.GTIN().isBlank()) {
            this.GTIN = productDTO.GTIN();
        }
        if(productDTO.isPerishable() != null) {
            this.isPerishable = productDTO.isPerishable();
        }
        this.updatedAt = LocalDateTime.now();
    }
}
