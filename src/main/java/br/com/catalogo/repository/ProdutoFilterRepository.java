package br.com.catalogo.repository;

import br.com.catalogo.filter.ProdutoFilter;
import br.com.catalogo.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoFilterRepository {
    Page<Produto> find(Pageable pageable, ProdutoFilter filter);
}