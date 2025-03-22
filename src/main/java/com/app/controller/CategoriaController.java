package com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.controller.persistence.entity.Categoria;
import com.app.service.CategoriaServiceImpl;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/categories")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl> {
	
}