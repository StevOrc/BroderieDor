package com.broderieDor.model.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.broderieDor.model.commande.Commande;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long idUser;
	
	@NotBlank
	@Size(min = 3, max = 60)
	private String lastName;

	@NotBlank
	@Size(min = 3, max = 60)
	private String firstName;
	
	@NotBlank
	@Size(max = 60)
	@Column(unique=true)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 12)
	@Column(unique=true)
	private String phone;
	
	@NotBlank
	@Length(min=5,max=30)
	@Column(unique=true)
	private String username;
	
    @NotBlank
    @Size(min=5, max=150)
    private String password;
    
	
	@OneToMany(mappedBy="client")
	@JsonIgnore
	private List<Commande> commandes;
	
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_roles", 
	  	joinColumns = @JoinColumn(name = "user_id"), 
	  	inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();
	
	
	//CONSTRUCTOR
	  public User() {
		  
	  }
	  
	public User(@NotBlank @Length(max = 255) String lastName, @NotBlank @Length(max = 255) String firstName,
			@NotBlank @Length(max = 100) @Email String email, @NotBlank @Length(max = 12) String phone,
			@NotBlank @Length(max = 20) String username, @NotBlank @Size(min = 6, max = 100) String password){
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	//GETTERS - SETTERS
	
	public long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	 
	
}
