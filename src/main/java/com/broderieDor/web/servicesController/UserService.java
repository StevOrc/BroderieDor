package com.broderieDor.web.servicesController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broderieDor.service.IUserService;
import com.broderieDor.JSONresponse.JSONresponse;
import com.broderieDor.dto.UserDto;
import com.broderieDor.model.user.User;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserService {
	
	@Autowired
	IUserService userService;
	
	//@PreAuthorize("hasRole('USER')")
	@GetMapping("/getuser/{username}")
	public ResponseEntity<?> getUser(@PathVariable String username){
		
		User user;
		if((user = this.userService.getUserByUsername(username)) != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto){	
		
		User user = this.userService.convertUserDtoToUser(userDto);
		this.userService.updateUser(user);
		
		return new ResponseEntity<JSONresponse>(new JSONresponse("Vos données ont été modifiés avec succès"),HttpStatus.OK);
	}
}
