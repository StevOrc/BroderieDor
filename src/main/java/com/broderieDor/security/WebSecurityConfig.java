package com.broderieDor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.broderieDor.security.jwt.JwtAuthEntryPoint;
import com.broderieDor.security.jwt.JwtAuthTokenFilter;
import com.broderieDor.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	    @Autowired
	    UserDetailsServiceImpl userDetailsService;
	 
	    // Classe utilisée pour envoyer un message d'erreur si il y a erreur lors de l'authentification
	    @Autowired
	    private JwtAuthEntryPoint unauthorizedHandler;
	 
	    @Bean
	    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
	        return new JwtAuthTokenFilter();
	    }
	 
	    @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        authenticationManagerBuilder
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	    
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

    //Permet de crypter le passsword lors du login
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and().csrf().disable().
	                authorizeRequests()
	                .antMatchers("/api/auth/**").permitAll() // authorisation d'accéder à toute les ressources de "api/auth/**"
	                .antMatchers("/api/**").permitAll() // accès autorisé pour les ressources /api/**
	                .anyRequest().authenticated() // Pour toute les autres ressources, il faut être authentifié
	                .and()
	                //Si il y erreur lors de l'authenfication => une erreur est envoyé dans la response 401
	                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        //Ajout de notre filtre personalisé
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
}
