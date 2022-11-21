package services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import model.ProdutoModel;
import repository.ProdutoRepository;

import shared.ProdutoDTO;



@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> obterTodos() {
		
		//retorna uma lista de produtoModel
		List<ProdutoModel> produtos = produtoRepository.findAll(); 
		
		//faz o tratamento da lista de produtoModel para produtoDTO
		return produtos.stream()
				.map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
				.collect(Collectors.toList());
	}

	public Optional<ProdutoDTO> obterPorId(Long id) {
		
		//Obtendo optional de produto pelo id 
		Optional<ProdutoModel> produto = produtoRepository.findById(id); 
		
		if (produto.isEmpty()) {
			
		}
		
		//Converte o meu optional de produto em produtoDTO
		ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
		
		// Criando o meu optional de produto em um produtoDTO
		return Optional.of(dto);
	}

	@SuppressWarnings("null")
	public ProdutoDTO adicionar(ProdutoDTO produtoDto) {
		
		//removendo o id para conseguir fazer a cadastro 
		produtoDto.setId((Long) null);
		
		//criar um objeto de mapeamento 
       ModelMapper mapper = new ModelMapper();
       
       //Converter o nosso produtoDTO em produto
       ProdutoModel produto = mapper.map(produtoDto, ProdutoModel.class);
		
       //salvar o produto do banco
		produto = produtoRepository.save(produto);
		
		produtoDto.setId(produto.getId());
		
		//retornar o produto DTO atualizado 
		return produtoDto;
	}
	
	public void deletar(Long id) {
		
		Optional<ProdutoModel> produto = produtoRepository.findById(id);
		
		if(produto.isEmpty()) {
			
		}
		
		 produtoRepository.deleteById(id);
		
	}
	
	public ProdutoDTO atualizar (Long id, ProdutoDTO produtoDto) {
		
		produtoDto.setId(id);
		
		ModelMapper mapper = new ModelMapper();
		
		ProdutoModel produto = mapper.map(produtoDto, ProdutoModel.class);
		
		produtoRepository.save(produto);
		
		return produtoDto;
		
		
	}

}
