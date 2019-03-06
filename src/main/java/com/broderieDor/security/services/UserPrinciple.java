package com.broderieDor.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.broderieDor.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

//cette classe qui implémente UserDetails donne des informations sur l'utilisateur
//ces informations sont stockées pour ensuite être encapsulés dans des objets d'authentification	
public class UserPrinciple implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	 
	private Long idUser;
 
    private String lastName;
 
    private String firstName;
    
    private String username;
 
    private String email;
    
    private String phone;
 
    @JsonIgnore
    private String password;
 
    private Collection<? extends GrantedAuthority> authorities;
    
    

	public UserPrinciple(Long idUser, String lastName, String firstName, String username, String email, String phone,
			String password, Collection<? extends GrantedAuthority> authorities) {
		this.idUser = idUser;
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.authorities = authorities;
	}
	
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
 
        return new UserPrinciple(
                user.getIdUser(),
                user.getLastName(),
                user.getFirstName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                authorities
        );
    }

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
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

	public void setPrenom(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(idUser, user.idUser);
    }
    
}
