package com.app.controller;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.controller.persistence.entity.Registre;
import com.app.controller.persistence.entity.registreFilter;
import com.app.service.RegistreServiceImpl;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping({"/api/v1/registres"})
public class RegistreController extends BaseControllerImpl<Registre, RegistreServiceImpl> {
	
	@GetMapping("/getBySubcat")	
	public ResponseEntity<?> getRegistreBySubcategoriaId(@RequestParam Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getRegistreBySubcategoriaId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}	
	
	@GetMapping("/getByCat")
	public ResponseEntity<?> getRegistreByCategoria(@RequestParam Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getRegistreByCategoria(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/ckDeleteSubcat")
	public ResponseEntity<?> checkDeleteSubcategoria(@RequestParam Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.checkDeleteSubcategoria(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/findAllWithSort")
	public ResponseEntity<?> findAllOrderByDataDesc(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAllWithSort());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/getRegistreRepeate")
	public ResponseEntity<?> getRegistreRepeate(@RequestParam Double importReg, @RequestParam String data, @RequestParam Long subcatId){
		try {
			Date dataFinal= Date.valueOf(data);
			return ResponseEntity.status(HttpStatus.OK).body(service.getRegistreRepeate(importReg, dataFinal, subcatId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@PostMapping("/getRegistreFilter")
	public ResponseEntity<?> getRegistreFilter(@RequestBody registreFilter filter){
		try {		
			return ResponseEntity.status(HttpStatus.OK).body(service.filtred(filter.getDInici(), filter.getDFi(), filter.getSubcatId(), filter.getPageable()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
		
}
