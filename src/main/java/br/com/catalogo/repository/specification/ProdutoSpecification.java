package br.com.catalogo.repository.specification;

import br.com.catalogo.model.Produto;
import org.springframework.data.jpa.domain.Specification;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
        @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class),
        @Spec(path = "price", params = "price", spec = Like.class),
})
public interface ProdutoSpecification extends Specification<Produto>{}
