package com.app.controller.persistence.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.app.controller.persistence.entity.Registre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;

public class RegistreCostumRepositoryImpl implements RegistreCostumRepository {
		
	@Autowired
	EntityManager em;

	@Override
	public Page<Registre> findByDataAndSubcategoria(Date inici, Date fi, int subcat, Pageable page) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Registre> cq = cb.createQuery(Registre.class);

	    Root<Registre> registre = cq.from(Registre.class);

	    List<Predicate> predicates = new ArrayList<>();
	    
	    if (inici != null && fi != null) {
	        predicates.add(cb.between(registre.get("data"), inici, fi));
	    }

	    if (subcat != 0) {
	        predicates.add(cb.equal(registre.get("subcategoria").get("id"), subcat));
	    }
	    
	    cq.where(predicates.toArray(new Predicate[0]));
	    
	    cq.orderBy(cb.desc(registre.get("data")));
	
	    TypedQuery<Registre> query = em.createQuery(cq);
	    
	    int totalRows = query.getResultList().size();
	    
	    query.setFirstResult(page.getPageNumber() * page.getPageSize());
	    query.setMaxResults(page.getPageSize());

        return new PageImpl<Registre>(query.getResultList(), page, totalRows);
	}

}
