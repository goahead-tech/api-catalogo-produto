package br.com.catalogo.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ProdutoFilter")
public class ProdutoFilter {

    @ApiModelProperty(value = "ID do produto", dataType = "Long", example = "")
    private Long id;

    @ApiModelProperty(value = "Name do produto", dataType = "String", example = "")
    private String name;

    @ApiModelProperty(value = "Descrição do produto", dataType = "String", example = "")
    private String description;

    @ApiModelProperty(value = "Preço do produto", dataType = "BigDecimal", example = "")
    private BigDecimal price;

    @ApiModelProperty(value = "Preço Mínimo", dataType = "BigDecimal", example = "")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal min_price;

    @ApiModelProperty(value = "Preço Mínimo", dataType = "BigDecimal", example = "")
    @DecimalMin(value = "10000000", inclusive = false)
    private BigDecimal max_price;
    
    @ApiModelProperty(value = "Categoria do Produto", dataType = "Enum", example = "")
    private String productCategory;

    @ApiModelProperty(value = "Data criação do Produto", dataType = "LocalDateTime", example = "")
    private BigDecimal creationDate;

}
