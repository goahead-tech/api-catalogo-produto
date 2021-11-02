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

    @ApiModelProperty(value = "ID do produto", dataType = "Long", example = "1")
    private Long id;

    @ApiModelProperty(value = "Name do produto", dataType = "String", example = "Notebook Dell")
    private String name;

    @ApiModelProperty(value = "Descrição do produto", dataType = "String", example = "Notebook Dell ultra fino")
    private String description;

    @ApiModelProperty(value = "Preço do produto", dataType = "BigDecimal", example = "6999.00")
    private BigDecimal price;

    @ApiModelProperty(value = "Preço Mínimo", dataType = "BigDecimal", example = "")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal min_price;

    @ApiModelProperty(value = "Preço Mínimo", dataType = "BigDecimal", example = "")
    @DecimalMin(value = "10000000", inclusive = false)
    private BigDecimal max_price;

}
