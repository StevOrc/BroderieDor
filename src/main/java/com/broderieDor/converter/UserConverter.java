package com.broderieDor.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.broderieDor.dto.UserDto;
import com.broderieDor.model.user.User;
import com.broderieDor.repository.UserRepository;

@Component
public class UserConverter implements Converter<UserDto, User> {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User convert(UserDto userDto) {
		
		User user;
		
		if(userDto.getIdUser() != 0) {
			user = this.userRepo.findByUsername(userDto.getUsername()).get();
			if(userDto.getFirstName() != null)
				user.setFirstName(userDto.getFirstName());
			if(userDto.getLastName() != null)
				user.setLastName(userDto.getLastName());
			if(userDto.getEmail() != null)
				user.setEmail(userDto.getEmail());
			if(userDto.getUsername() != null)
				user.setUsername(userDto.getUsername());
			if(userDto.getPhone() != null)
				user.setPhone(userDto.getPhone());
			return user;
		}
		else
			return null;
	}

}
