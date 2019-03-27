package com.broderieDor.controllerAuth;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broderieDor.model.user.User;
import com.broderieDor.model.user.Role;
import com.broderieDor.model.user.RoleName;
import com.broderieDor.registration.request.LoginForm;
import com.broderieDor.registration.request.SignupForm;
import com.broderieDor.registration.response.JwtResponse;
import com.broderieDor.registration.response.ResponseMessage;
import com.broderieDor.repository.RoleRepository;
import com.broderieDor.repository.UserRepository;
import com.broderieDor.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
	
	@Autowired
	AuthenticationManager authenticationManager;
 
	@Autowired
	UserRepository userRepository;
 
	@Autowired
	RoleRepository roleRepository;
 
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
		SecurityContextHolder.getContext().setAuthentication(authentication);
 
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(),userDetails.getAuthorities()));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Erreur -> le pseudo est déjà utilisé !"),
					HttpStatus.BAD_REQUEST);
		}
 
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Erreur -> l'email est déjà utilisé !"),
					HttpStatus.BAD_REQUEST);
		}
 
		// Creating user's account
		User user = new User(signUpRequest.getLastName(),signUpRequest.getFirstName(), signUpRequest.getEmail(), signUpRequest.getPhone(),
				signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()));
 
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
 
		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);
 
				break;
			case "vip":
				Role vipRole = roleRepository.findByName(RoleName.ROLE_VIP)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(vipRole);
 
				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});
 
		user.setRoles(roles);
		user.setValid(false);
		userRepository.save(user);
 
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}
