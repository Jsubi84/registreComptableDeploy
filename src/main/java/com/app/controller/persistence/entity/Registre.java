package com.app.controller.persistence.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper=false)
@Entity @Table(name = "Registre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registre extends Base{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "importreg")
	private Double importreg;	
	
	@Column(name = "descripcio")
	private String descripcio;	
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "subcategoria_id")
	private Subcategoria subcategoria;
}
