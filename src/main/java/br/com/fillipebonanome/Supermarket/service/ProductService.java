package br.com.fillipebonanome.Supermarket.service;

import br.com.fillipebonanome.Supermarket.dto.product.CreateProductDTO;
import br.com.fillipebonanome.Supermarket.dto.product.ReadProductDTO;
import br.com.fillipebonanome.Supermarket.dto.product.UpdateProductDTO;
import br.com.fillipebonanome.Supermarket.entity.Product;
import br.com.fillipebonanome.Supermarket.infra.exception.ProductException;
import br.com.fillipebonanome.Supermarket.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ReadProductDTO getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product with id " + id + " was not found"));
        return new ReadProductDTO(product);
    }

    public Page<ReadProductDTO> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ReadProductDTO::new);
    }

    public ReadProductDTO register(@Valid CreateProductDTO productDTO) {
        Product product = new Product(productDTO);
        Product savedProduct = productRepository.save(product);
        return new ReadProductDTO(savedProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public ReadProductDTO update(Long id, UpdateProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product with id " + id + " was not found"));
        product.update(productDTO);
        Product savedProduct = productRepository.save(product);
        return new ReadProductDTO(savedProduct);
    }
}
