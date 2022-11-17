package com.teste2.primeiroexemplo.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste2.primeiroexemplo.model.ProdutoModel;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {



}
