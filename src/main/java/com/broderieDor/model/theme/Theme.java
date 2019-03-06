package com.broderieDor.model.theme;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.broderieDor.model.basket.Basket;

@Entity
public class Theme {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTheme;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="theme")
	private List<Basket> baskets;
	
	public Theme() {
		
	}
	
	public Theme(@NotNull int idTheme, String name, List<Basket> baskets) {
		this.idTheme = idTheme;
		this.name = name;
		this.baskets = baskets;
	}

	//GETTERS - SETTERS
	public long getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setPaniers(List<Basket> baskets) {
		this.baskets = baskets;
	}

}
