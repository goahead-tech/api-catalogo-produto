package br.com.catalogo.service;


import br.com.catalogo.dto.input.ProdutoInputDto;
import br.com.catalogo.dto.output.ProdutoOutputDto;
import br.com.catalogo.exception.EntidadeNaoEncontradaException;
import br.com.catalogo.filter.ProdutoFilter;
import br.com.catalogo.mapper.ProdutoMapper;
import br.com.catalogo.model.Produto;
import br.com.catalogo.repository.ProdutoRepository;
import br.com.catalogo.repository.specification.ProdutoSpecification;
import br.com.catalogo.repository.specification.ProdutoSpecs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import static br.com.catalogo.model.ProdutoSpecifications.hasId;
import static br.com.catalogo.model.ProdutoSpecifications.hasName;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    @Transactional
    public ProdutoOutputDto save(ProdutoInputDto produto) {
        Produto savedModel = repository.save(mapper.inputDtoToModel(produto));
        return mapper.modelToOutputDto(savedModel);
    }

    public Page<ProdutoOutputDto> findAll(ProdutoFilter filter, Pageable pageable){
        Page<Produto> page =  repository.find(pageable, filter);
        return page.map(produto -> mapper.modelToOutputDto(produto));
    }

    public Page<ProdutoOutputDto> findAllSpec(ProdutoSpecification spec, Pageable pageable){
        Page<Produto> page =  repository.findAll(spec, pageable);
        return page.map(produto -> mapper.modelToOutputDto(produto));
    }


    public ProdutoOutputDto findById(Long id){
        Produto model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Produto de ID: "+id+" Não foi encontrado"){});
        return mapper.modelToOutputDto(model);
    }

    @Transactional
    public ProdutoOutputDto update(Long id, ProdutoInputDto request) {
        Produto model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Produto de ID: "+id+" Não foi encontrado"){});
        BeanUtils.copyProperties(request, model, "id");
        return mapper.modelToOutputDto(repository.save(model));
    }

    @Transactional
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Produto de ID: "+id+" Não foi encontrado"){});
        repository.deleteById(id);
    }

    public Page<ProdutoOutputDto> findAllV2(ProdutoFilter filter, Pageable pageable){
        Page<Produto> page = repository.findAll(hasId(filter.getId()).and(hasName(filter.getName())), pageable);
        return page.map(produto -> mapper.modelToOutputDto(produto));
    }

}
