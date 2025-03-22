package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.controller.persistence.entity.Subcategoria;
import com.app.service.SubcategoriaServiceImpl;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping({"/api/v1/subcategories"})
public class SubcategoriaController extends BaseControllerImpl<Subcategoria, SubcategoriaServiceImpl> {
	
	@GetMapping("/ckDeleteCat")
	public ResponseEntity<?> checkDeleteCategoria(@RequestParam Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.checkDeleteCategoria(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
}
