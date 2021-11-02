package br.com.catalogo.repository;

import br.com.catalogo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoFilterRepository, JpaSpecificationExecutor<Produto> {

    Produto findByPrice(BigDecimal price);
    Optional<Produto> findById(Long id);
}

