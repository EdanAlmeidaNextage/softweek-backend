package com.softweek.softweek.repository;

import com.softweek.softweek.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Categoriarepository extends JpaRepository<Categoria, Long> {
}
