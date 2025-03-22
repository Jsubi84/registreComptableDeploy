package com.app.controller.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper=false)
@Entity @Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria extends Base{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "tipus")
	private Boolean tipus;
	
	@Column(name = "descripcio")
	private String descripcio;
	
	@JsonBackReference
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REFRESH, orphanRemoval = true)
	private List<Subcategoria> subcategories = new ArrayList<Subcategoria>();
}
