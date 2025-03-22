package com.app.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.app.controller.persistence.entity.Registre;
import com.app.controller.persistence.repository.BaseRepository;
import com.app.controller.persistence.repository.RegistreRepository;


@Service
public class RegistreServiceImpl extends BaseServiceImpl<Registre, Long> implements RegistreService {
	
	@Autowired
	private RegistreRepository registreRepository;
	
	public RegistreServiceImpl(BaseRepository<Registre, Long> baseRepository) {
		super(baseRepository);
	}
	
	@Override
	public List<Registre> findAllWithSort() throws Exception {
		try {
			List<Registre> registres = registreRepository.findAll(Sort.by("data").descending());
			return registres;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<Registre> getRegistreBySubcategoriaId(Long id) throws Exception {
		try {
			List<Registre> registres = registreRepository.getRegistreBySubcategoriaId(id);
			return registres;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Registre> getRegistreByCategoria(Long categoria_id) throws Exception {
		try {
			List<Registre> registres = registreRepository.getRegistreByCategoria(categoria_id);
			return registres;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
		@Override
	public List<Object[]> getResumAny(int year) throws Exception {
		try {
			return registreRepository.getResumAny(year);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int checkDeleteSubcategoria(Long id) throws Exception {
		try {
			return registreRepository.checkDeleteSubcategoria(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<Long> getRegistreRepeate(Double importReg, Date data, Long subcatId)throws Exception {
		try {
			return registreRepository.getRegistreRepeate(importReg, data, subcatId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Page<Registre> filtred(Date fi, Date inici, int subcat, Pageable pageable) throws Exception {
		try {
			return registreRepository.findByDataAndSubcategoria(fi, inici, subcat, pageable);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public double getTotalSubcatByYear(Long id, int year) throws Exception {
		try {
			if (registreRepository.getTotalSubcatByYear(id, year) == null){
				return 0.0;
			}else {
				return registreRepository.getTotalSubcatByYear(id, year).doubleValue();				
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public double getTotalCatByYear(Long id, int year) throws Exception {
		try {
			if (registreRepository.getTotalCatByYear(id, year) == null){
				return 0.0;
			}else {
				return registreRepository.getTotalCatByYear(id, year).doubleValue();				
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Registre> getSubcatByYearMonth(Long id, int year, int month) throws Exception {
		try {
			List<Registre> registres = registreRepository.getSubcatByYearMonth(id, year, month);
			return registres;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Registre> getCatByYearMonth(Long id, int year, int month) throws Exception {
		try {
			List<Registre> registres = registreRepository.getCatByYearMonth(id, year, month);
			return registres;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
