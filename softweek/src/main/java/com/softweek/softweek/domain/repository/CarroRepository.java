package com.softweek.softweek.domain.repository;

import com.softweek.softweek.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
