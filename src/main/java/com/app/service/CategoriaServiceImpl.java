package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.persistence.entity.Categoria;
import com.app.controller.persistence.repository.BaseRepository;
import com.app.controller.persistence.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl(BaseRepository<Categoria, Long> baseRepository) {
		super(baseRepository);
	}

}
