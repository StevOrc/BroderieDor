package com.broderieDor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.model.user.User;
import com.broderieDor.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public Optional<User> getUserByUsername(String username) {
		
		return this.userRepo.findByUsername(username);
	}

	@Override
	public User updateUser(User user) {
		
		return this.userRepo.save(user);
	}

	@Override
	public void deleteAccount(long id) {
		this.userRepo.deleteById(id);
	}

}
