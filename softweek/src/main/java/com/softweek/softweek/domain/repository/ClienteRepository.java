package com.softweek.softweek.domain.repository;

import com.softweek.softweek.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
