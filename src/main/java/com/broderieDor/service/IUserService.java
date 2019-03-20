package com.broderieDor.service;

import com.broderieDor.dto.UserDto;
import com.broderieDor.model.user.User;

public interface IUserService {
	
	public User getUserByUsername(String username);
	public User updateUser(User user);
	public void deleteAccount(long id);
	
	//Convertter
	public User convertUserDtoToUser(UserDto userDto);
}
