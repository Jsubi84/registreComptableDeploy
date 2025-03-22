package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.controller.persistence.entity.Registre;
import com.app.service.RegistreServiceImpl;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping({"/api/v1/dashboard"})
public class DashboardController extends BaseControllerImpl<Registre, RegistreServiceImpl> {
	
	@GetMapping("/getResumAny")
	public ResponseEntity<?> getResumAny(@RequestParam int year){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getResumAny( year));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/getTotalSubcatByYear")
	public ResponseEntity<?> getTotalSubcatByYear(@RequestParam Long idSubcat, @RequestParam int year){
		try {		
			return ResponseEntity.status(HttpStatus.OK).body(service.getTotalSubcatByYear(idSubcat, year));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/getTotalCatByYear")
	public ResponseEntity<?> getTotalCatByYear(@RequestParam Long idCat, @RequestParam int year){
		try {		
			return ResponseEntity.status(HttpStatus.OK).body(service.getTotalCatByYear(idCat, year));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/getCatByYearMonth")
	public ResponseEntity<?> getCatByYearMonth( @RequestParam Long idCat, @RequestParam int year, @RequestParam int month){
		try {		
			return ResponseEntity.status(HttpStatus.OK).body(service.getCatByYearMonth(idCat, year, month));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
	
	@GetMapping("/getSubcatByYearMonth")
	public ResponseEntity<?> getSubcatByYearMonth( @RequestParam Long idSubcat, @RequestParam int year, @RequestParam int month){
		try {		
			return ResponseEntity.status(HttpStatus.OK).body(service.getSubcatByYearMonth(idSubcat, year, month));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage()+"\"}");
		}
	}
		
}
