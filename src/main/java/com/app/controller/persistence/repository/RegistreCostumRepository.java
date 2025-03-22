package com.app.controller.persistence.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.app.controller.persistence.entity.Registre;


@Repository
public interface RegistreCostumRepository {
	
	Page<Registre> findByDataAndSubcategoria(Date inici, Date fi, int subcat, Pageable page);

}
