package br.com.catalogo.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.catalogo.enums.ProductCategory;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoOutputDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime creationDate;
    private ProductCategory productCategory;
}

