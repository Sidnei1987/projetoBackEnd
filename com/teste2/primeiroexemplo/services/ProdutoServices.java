package com.teste2.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste2.primeiroexemplo.model.ProdutoModel;
import com.teste2.primeiroexemplo.repository.ProdutoRepository_list;



@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository_list produtoRepository;

	public List<ProdutoModel> obterTodos() {
		return produtoRepository.obterTodos();
	}

	public Optional<ProdutoModel> obterPorId(Long id) {
		return produtoRepository.obterPorId(id);
	}

	public ProdutoModel adicionar(ProdutoModel produto) {

		return  produtoRepository.adicionar(produto);
	}
	
	public void deletar(Long id) {
		
		produtoRepository.deletar(id);
		
	}
	
	public ProdutoModel atualizar (Long id, ProdutoModel produto) {
		
		produto.setId(id);
		
		return produtoRepository.atualizar(produto);
	}

}
