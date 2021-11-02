package br.com.catalogo.controller;

import br.com.catalogo.controller.swagger.ProdutoControllerSwagger;
import br.com.catalogo.dto.input.ProdutoInputDto;
import br.com.catalogo.dto.output.ProdutoOutputDto;
import br.com.catalogo.filter.ProdutoFilter;
import br.com.catalogo.model.Produto;
import br.com.catalogo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/v1/products")
public class ProdutoController implements ProdutoControllerSwagger{

	@Autowired
	private ProdutoService service;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Page<ProdutoOutputDto>> findAll(Pageable pageable, ProdutoFilter filter){
		return ResponseEntity.ok(service.findAllV2(filter, pageable));
	}

	@Override
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<ProdutoOutputDto> save (UriComponentsBuilder uri, @RequestBody ProdutoInputDto produto) {
		ProdutoOutputDto dto = service.save(produto);
		return ResponseEntity.created(uri.path("/v1/products{id}").buildAndExpand(dto.getName()).toUri()).body(dto);
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<ProdutoOutputDto> findById(@PathVariable Long id) {
		ProdutoOutputDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}


	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody ProdutoInputDto produto, @PathVariable Long id) {
		return ResponseEntity.ok(service.update(id, produto));
	}
}