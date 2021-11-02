package br.com.catalogo.model;

import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecifications {

    public static Specification<Produto> hasId(Long id) {
        if (id == null) {
            return (produto, cq, cb) -> cb.conjunction();
        }
        return (produto, cq, cb) -> cb.equal(produto.get("id"), id);
    }

    public static Specification<Produto> hasName(String name) {
        if (name == null) {
            return (produto, cq, cb) -> cb.conjunction();
        }
        return (produto, cq, cb) -> cb.equal(produto.get("name"), name);
    }

}
