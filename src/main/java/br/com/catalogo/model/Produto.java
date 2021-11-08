package br.com.catalogo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.*;

import br.com.catalogo.enums.ProductCategory;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    
    @Column(name="product_category")
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    
    
    
}

