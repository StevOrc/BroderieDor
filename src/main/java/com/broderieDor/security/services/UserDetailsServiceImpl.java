package com.broderieDor.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.broderieDor.model.user.User;
import com.broderieDor.repository.UserRepository;

//Classe qui charge les données spécifique de l'utilisateur
//Renvoi une erreur de type UsernameNotFoundException si non trouvée
//Si tout est OK elle renvoit un objet de type UserPrinciple qui implémente l'interface UserDetails
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User not found -> username or email : " + username));
 
		return UserPrinciple.build(user);
	}
}
