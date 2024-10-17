package com.softweek.softweek.domain.repository;

import com.softweek.softweek.domain.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
