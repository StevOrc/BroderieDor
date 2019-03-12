package com.broderieDor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.theme.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long>{
	
	public Theme findByName(String name);
}
