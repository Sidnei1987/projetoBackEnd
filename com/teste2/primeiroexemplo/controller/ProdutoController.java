package com.teste2.primeiroexemplo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste2.primeiroexemplo.model.ProdutoModel;
import com.teste2.primeiroexemplo.repository.ProdutoRepository;



@RestController()
@RequestMapping("api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<ProdutoModel> Post(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoModel> Put(@RequestBody ProdutoModel produto) {
		return ResponseEntity.ok().body(repository.save(produto));
	}
	
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id) {
		repository.deleteById(id);
	}	


}
