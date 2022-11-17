package com.teste2.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste2.primeiroexemplo.model.ProdutoModel;







@Repository
public class ProdutoRepository_list {
	
	 private ArrayList<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
	 private int ultimoId = 0;
	 
	 public List<ProdutoModel> obterTodos(){
		 return produtos;
	 }
	 
	 public Optional< ProdutoModel> obterPorId(Long id) {
		 return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
		 
	 }
	  
	 //metodo para adiciona produto na lista 
	 public ProdutoModel adicionar (ProdutoModel produto) {
		 
		 ultimoId++;
		 
		 produto.setId(ultimoId);
		 produtos.add(produto);
		 
		 return produto;
	 }
	 
	 //apaga o produto 
	 public void deletar (Long id) {
		 produtos.removeIf(produto -> produto.getId() == id );
	 }
	 
	 //metodo para ataualizar o produto na lista 
	 public ProdutoModel atualizar(ProdutoModel produto) {
		 
		 //encontra o produto 
		 Optional<ProdutoModel> produtoEncontrado = obterPorId(produto.getId());
		 
		 if(produtoEncontrado.isEmpty()){
			 throw new InputMismatchException("Produto não encontrado");			 
		 }
		 // remover o produto antigo na lista 
		 deletar(produto.getId());
		 
		 //atualiza o novo produto 
		 produtos.add(produto);
		 
		 return produto;
	 }

}
