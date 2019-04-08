package com.broderieDor.model.theme;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.broderieDor.model.basket.Basket;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idTheme")
public class Theme {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTheme;
	
	@NotEmpty
	@Length(max=15)
	@Column(unique=true)
	private String name;
	
	
	private String description;
	
	@OneToMany(mappedBy="theme")
	private List<Basket> baskets;
	
	public Theme() {
		
	}
	

	public Theme(@NotEmpty @Length(max = 15) String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baskets == null) ? 0 : baskets.hashCode());
		result = prime * result + (int) (idTheme ^ (idTheme >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		if (baskets == null) {
			if (other.baskets != null)
				return false;
		} else if (!baskets.equals(other.baskets))
			return false;
		if (idTheme != other.idTheme)
			return false;
		return true;
	}

	
}
