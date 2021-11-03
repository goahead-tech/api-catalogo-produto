package br.com.catalogo.dto.input;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
}

