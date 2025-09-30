package br.com.fillipebonanome.Supermarket.controller;

import br.com.fillipebonanome.Supermarket.dto.product.CreateProductDTO;
import br.com.fillipebonanome.Supermarket.dto.product.ReadProductDTO;
import br.com.fillipebonanome.Supermarket.dto.product.UpdateProductDTO;
import br.com.fillipebonanome.Supermarket.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ReadProductDTO> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ReadProductDTO>> getAll(@PageableDefault(size = 10, sort = {"name"})Pageable pageable) {
        return ResponseEntity.ok(productService.getAll(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ReadProductDTO> register(@RequestBody @Valid CreateProductDTO productDTO, UriComponentsBuilder uriComponentsBuilder) {
        ReadProductDTO registeredProduct = productService.register(productDTO);
        return ResponseEntity.created(uriComponentsBuilder.path("/products/{id}").buildAndExpand(registeredProduct.id()).toUri()).body(registeredProduct);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReadProductDTO> update(@PathVariable(name = "id") Long id, @RequestBody UpdateProductDTO productDTO) {
        return ResponseEntity.ok(productService.update(id, productDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
