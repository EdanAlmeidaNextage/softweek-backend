package com.softweek.softweek.repository;

import com.softweek.softweek.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllBySubcategoriaIdSubcategoriaAndAtivoTrue(Long idSubcategoria);

}
