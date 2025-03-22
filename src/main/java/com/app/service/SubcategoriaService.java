package com.app.service;

import com.app.controller.persistence.entity.Subcategoria;

public interface SubcategoriaService extends BaseService<Subcategoria, Long> {
	int checkDeleteCategoria(Long id) throws Exception;
}
