package com.broderieDor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.broderieDor.repository.RoleRepository;
import com.broderieDor.repository.UserRepository;

@SpringBootApplication
public class BroderieDorApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BroderieDorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
	
	public void createAdmin() {
		
	}
	
	public void createRole() {
		
	}
}

