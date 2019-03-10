package com.broderieDor.model.theme;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.broderieDor.model.basket.Basket;

@Entity
public class Theme {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTheme;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@OneToMany(mappedBy="theme")
	private List<Basket> baskets;
	
	public Theme() {
		
	}
	
	public Theme(@NotNull long idTheme, String name, List<Basket> baskets) {
		this.idTheme = idTheme;
		this.name = name;
		this.baskets = baskets;
	}

	//GETTERS - SETTERS
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdTheme(long idTheme) {
		this.idTheme = idTheme;
	}

	public long getIdTheme() {
		return idTheme;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}

	
	

}
