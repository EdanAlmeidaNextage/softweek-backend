package com.softweek.softweek.domain.repository;

import com.softweek.softweek.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
