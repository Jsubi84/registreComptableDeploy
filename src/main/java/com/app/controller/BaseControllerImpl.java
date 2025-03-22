package com.app.controller;

import com.app.controller.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.controller.persistence.entity.Base;
import com.app.service.BaseServiceImpl;

//@PreAuthorize("denyAll()")
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

	@Autowired
	protected S service;
	
	//@PreAuthorize("hasAuthority('READ')")
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Al listar.\"}");
		}
	}
	
	@GetMapping("/paged")
	public ResponseEntity<?> getAll(Pageable pageable){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Al listar.\"}");
		}
	}
	
	@GetMapping("/pagedFiltered")
	public ResponseEntity<?> getAll(Specification<E> spec, Pageable pageable){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Al listar.\"}");
		}
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> getOne(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Al buscar.\"}");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody E entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido guardar.\"}");
		}
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido actualizar.\"}");
		}
	}
	
	@DeleteMapping(path = {"/{id}"})	
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido borrar.\"}");
		}
	}
}
