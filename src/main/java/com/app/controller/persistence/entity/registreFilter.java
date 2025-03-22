package com.app.controller.persistence.entity;

import java.sql.Date;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper=false)
public class registreFilter {
	
	private String dInici;
	private String dFi;
	private int subcatId;
	private int page; 
	private int size;
	
	public int getSubcatId() {
		return subcatId;
	}
	public void setSubcatId(int subcatId) {
		this.subcatId = subcatId;
	}
	public Pageable getPageable() {
		Pageable pageable = PageRequest.of(page, size);
		return pageable;
	}
	
	public Date getDInici() {
		Date inici;
		if (dInici != "") {
			inici= Date.valueOf(dInici);
		}else {
			inici= null;				
		}
		return inici;
	}
	
	public Date getDFi() {
		Date fi;
		if (dFi != "") {
			fi= Date.valueOf(dFi);
		}else {
			fi= null;				
		}
		return fi;
	}
	
	public String getdInici() {
		return dInici;
	}
	public void setdInici(String dInici) {
		this.dInici = dInici;
	}
	public String getdFi() {
		return dFi;
	}
	public void setdFi(String dFi) {
		this.dFi = dFi;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
