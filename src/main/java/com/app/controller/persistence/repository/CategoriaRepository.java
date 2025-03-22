package com.app.controller.persistence.repository;

import org.springframework.stereotype.Repository;

import com.app.controller.persistence.entity.Categoria;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{
    
}
