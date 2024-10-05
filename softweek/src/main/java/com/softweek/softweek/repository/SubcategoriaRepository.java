package com.softweek.softweek.repository;

import com.softweek.softweek.model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {

    Optional<Subcategoria> findById(Long idSubcategoria);

}
