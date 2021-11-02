package br.com.catalogo.mapper;

import br.com.catalogo.dto.input.ProdutoInputDto;
import br.com.catalogo.dto.output.ProdutoOutputDto;
import br.com.catalogo.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProdutoMapper {

    @Autowired
    private ModelMapper mapper;

    public ProdutoOutputDto modelToOutputDto(Produto model) {
        return mapper.map(model, ProdutoOutputDto.class);
    }

    public Produto inputDtoToModel(ProdutoInputDto request) {
        return mapper.map(request, Produto.class);
    }
}
