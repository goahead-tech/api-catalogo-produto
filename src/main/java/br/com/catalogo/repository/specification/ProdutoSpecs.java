package br.com.catalogo.repository.specification;

import br.com.catalogo.model.Produto;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

//@And({
//	@Spec(path = "productName", params = "productName", spec = LikeIgnoreCase.class),
//	@Spec(path = "productPrice", params = "productPrice", spec = LikeIgnoreCase.class),
//})
public class ProdutoSpecs{

    public static Specification<Produto> comNomeSemelhante(String name){
        return (root, query, builder) -> builder
                .like(root.get("name"), "%" + name +"%");
    }
    public static Specification<Produto> listaDePreco(BigDecimal price){
        return (root, query, builder) -> builder
                .like(root.get("price"), "%" + price +"%");
    }
}
