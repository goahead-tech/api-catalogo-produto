package br.com.catalogo.dto.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.catalogo.enums.ProductCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
@ApiModel
public class ProdutoInputDto {

	@ApiModelProperty(name = "name", value = "Nome do Produto", required = true, dataType = "String", example = "")
	@NotNull(message = "O valor do campo não pode ser nulo")
	@NotBlank(message = "O valor do campo não pode ser branco")
	private String name;

	@ApiModelProperty(name = "description", value = "Descrição do Produto", required = true, dataType = "String", example = "")
	@NotNull(message = "O valor campo não pode ser nulo")
	@NotBlank(message = "O valor do campo não pode ser branco")
	private String description;

	@ApiModelProperty(name = "price", value = "Preço do Produto", required = true, dataType = "BigDecimal", example = "")
	@Positive(message = "O valor do campo deve ser um número positivo")
	@NotNull(message = "O valor do campo não pode ser nulo")
	private BigDecimal price;
	
	@ApiModelProperty(name = "creation_date", value = "Data criação do Produto", required = true, dataType = "LocalDateTime", example = "")
	@DateTimeFormat(pattern="yyyyMMdd")
	private LocalDateTime creationDate;
	
	@ApiModelProperty(name = "product_category", value = "Categoria do Produto", required = true, dataType = "String", example = "")
	private ProductCategory productCategory;
	
	
	
	
}

