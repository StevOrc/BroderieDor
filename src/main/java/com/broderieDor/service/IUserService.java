package com.broderieDor.service;

import java.util.Optional;

import com.broderieDor.model.user.User;

public interface IUserService {
	
	public Optional<User> getUserByUsername(String username);
	public User updateUser(User user);
	public void deleteAccount(long id);
}
