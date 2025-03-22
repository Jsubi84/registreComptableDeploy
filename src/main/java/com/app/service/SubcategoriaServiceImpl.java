package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.persistence.entity.Subcategoria;
import com.app.controller.persistence.repository.BaseRepository;
import com.app.controller.persistence.repository.SubcategoriaRepository;


@Service
public class SubcategoriaServiceImpl extends BaseServiceImpl<Subcategoria, Long> implements SubcategoriaService {
	
	@Autowired
	private SubcategoriaRepository subcategoriaRepository;
	
	public SubcategoriaServiceImpl(BaseRepository<Subcategoria, Long> baseRepository) {
		super(baseRepository);
	}

	@Override
	public int checkDeleteCategoria(Long id) throws Exception {
		try {
			int numSubcategories = subcategoriaRepository.checkDeleteCategoria(id);
			return numSubcategories;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
