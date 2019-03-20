package com.broderieDor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.converter.UserConverter;
import com.broderieDor.dto.UserDto;
import com.broderieDor.model.user.User;
import com.broderieDor.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserConverter userConverter;
	
	@Override
	public User getUserByUsername(String username) {
		
		return this.userRepo.findByUsername(username).get();
	}

	@Override
	public User updateUser(User user) {
		
		return this.userRepo.save(user);
	}

	@Override
	public void deleteAccount(long id) {
		this.userRepo.deleteById(id);
	}

	
	@Override
	public User convertUserDtoToUser(UserDto userDto) {
		
		return this.userConverter.convert(userDto);
	}

}
