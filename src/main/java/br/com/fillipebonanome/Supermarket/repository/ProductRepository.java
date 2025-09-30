package br.com.fillipebonanome.Supermarket.repository;

import br.com.fillipebonanome.Supermarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
