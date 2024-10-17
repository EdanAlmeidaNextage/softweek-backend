package com.softweek.softweek.domain.repository;

import com.softweek.softweek.domain.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
