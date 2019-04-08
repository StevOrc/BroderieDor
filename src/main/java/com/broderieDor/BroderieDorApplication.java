package com.broderieDor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.model.user.Role;
import com.broderieDor.model.user.RoleName;
import com.broderieDor.model.user.User;
import com.broderieDor.repository.BasketRepository;
import com.broderieDor.repository.ProductRepository;
import com.broderieDor.repository.RoleRepository;
import com.broderieDor.repository.ThemeRepository;
import com.broderieDor.repository.UserRepository;

@SpringBootApplication
public class BroderieDorApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	ThemeRepository themeRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	BasketRepository basketRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BroderieDorApplication.class, args);
	}

	// This method will be run at first when the applicationn is launched
	@Override
	public void run(String... args) throws Exception {
		initRole();
		initTheme();
		initProduct();
		initBakset();
		initUser();
	}
	
	// This method will initiate Roles 
	public  void initRole() {
//		roleRepo.deleteAll();
		Role admin = new Role(RoleName.ROLE_ADMIN);
		Role user = new Role(RoleName.ROLE_USER);
		Role vip = new Role(RoleName.ROLE_VIP);
		roleRepo.save(admin); roleRepo.save(user); roleRepo.save(vip);
	}
	
	// This method will initiate theme
	public void initTheme() {
//		this.themeRepo.deleteAll();
		Theme naissance = new Theme("Naissance", "3 paniers pour bébé");
		Theme bapteme = new Theme("Baptême", "2 paniers pour baptême");
		Theme mariage = new Theme("Mariage", "2 paniers pour mariage");
		Theme solo = new Theme("Solo", "2 paniers pour solo");
		this.themeRepo.save(naissance); this.themeRepo.save(bapteme); this.themeRepo.save(mariage); this.themeRepo.save(solo); 
	}
	
	// This method will initiate product
	public void initProduct() {
//		this.productRepo.deleteAll();
		this.productRepo.save(new Product("Bavoir", 5f, 10, "bavoir"));
		this.productRepo.save(new Product("Body bebe", 6f, 10, "body_bebe"));
		this.productRepo.save(new Product("Bonnet bebe blanc", 7f, 10, "bonnet_bebe_blanc"));
		this.productRepo.save(new Product("Bonnet bebe rose", 7f, 10, "bonnet_bebe_rose"));
		this.productRepo.save(new Product("Cape de bain bleue", 18f, 10, "cape_de_bain_bleue"));
		this.productRepo.save(new Product("Cape de bain + gant roses", 11f, 10, "cape_de_bain_gant_roses"));
		this.productRepo.save(new Product("Cape de bain rose", 12f, 10, "cape_de_bain_rose"));
		this.productRepo.save(new Product("Chaussons blancs bébé", 13f, 10, "chaussons_blancs_bebe"));
		this.productRepo.save(new Product("Chaussons roses bébé", 13f, 10, "Chaussons_roses_bebe"));
		this.productRepo.save(new Product("Doudou beige", 9f, 10, "doudou_beige"));
		this.productRepo.save(new Product("Doudou blanc", 9f, 10, "doudou_blanc"));
		this.productRepo.save(new Product("Doudou bleu", 9f, 10, "doudou_bleu"));
		this.productRepo.save(new Product("Doudou rose", 9f, 10, "doudou_rose"));
		this.productRepo.save(new Product("Ensemble capes de bain gants", 9f, 10, "ensemble_capes_de_bain_gants"));
		this.productRepo.save(new Product("Ensemble doudous", 9f, 10, "ensemble_doudous"));
		this.productRepo.save(new Product("Ensemble nounours", 9f, 10, "ensemble_nounours"));
		this.productRepo.save(new Product("Fleur de douche", 9f, 10, "fleur_de_douche"));
		this.productRepo.save(new Product("Gant blanc", 9f, 10, "gant_blanc"));
		this.productRepo.save(new Product("Gant bleu", 9f, 10, "gant_bleu"));
		this.productRepo.save(new Product("Gant_rose", 9f, 10, "gant_rose"));
		this.productRepo.save(new Product("Grand nounours", 9f, 10, "grand_nounours"));
		this.productRepo.save(new Product("Lange bebe", 9f, 10, "lange_bebe"));
		this.productRepo.save(new Product("Nounours beige", 9f, 10, "nounours_beige"));
		this.productRepo.save(new Product("Nounours bleu", 9f, 10, "nounours_bleu"));
		this.productRepo.save(new Product("Nounours rose", 9f, 10, "nounours_rose"));
		this.productRepo.save(new Product("Peignoir blanc", 9f, 10, "peignoir_blanc"));
		this.productRepo.save(new Product("Peignoir gris", 9f, 10, "peignoir_gris"));
		this.productRepo.save(new Product("Peignoirs maries", 9f, 10, "peignoirs_maries"));
		this.productRepo.save(new Product("Plaid bebe blanc", 9f, 10, "plaid_bebe_blanc"));
		this.productRepo.save(new Product("Plaid bebe bleu", 9f, 10, "plaid_bebe_bleu"));
		this.productRepo.save(new Product("Plaid bebe rose", 9f, 10, "plaid_bebe_rose"));
		this.productRepo.save(new Product("Pyjama bebe", 9f, 10, "pyjama_bebe"));		
	}
	
	// This method will initiate product
	public void initBakset() {
//		this.basketRepo.deleteAll();
		this.basketRepo.save(new Basket("Bronze", 49, this.themeRepo.findByName("naissance"),"naissance_bronze"));
		this.basketRepo.save(new Basket("argent", 89, this.themeRepo.findByName("naissance"),"naissance_argent"));
		this.basketRepo.save(new Basket("or", 109, this.themeRepo.findByName("naissance"),"naissance_or"));
		
		this.basketRepo.save(new Basket("Avant", 49, this.themeRepo.findByName("baptême"),"bapteme_avant"));
		this.basketRepo.save(new Basket("Après", 49, this.themeRepo.findByName("baptême"),"bapteme_apres"));
		
		this.basketRepo.save(new Basket("Argent", 89, this.themeRepo.findByName("mariage"),"mariage_argent"));
		this.basketRepo.save(new Basket("or", 149, this.themeRepo.findByName("mariage"),"mariage_or"));
		
		this.basketRepo.save(new Basket("Argent", 69, this.themeRepo.findByName("solo"),"solo_argent"));
		this.basketRepo.save(new Basket("or", 109, this.themeRepo.findByName("solo"),"solo_or"));
		
	}
	
	// This method will initiate product
		public void initUser() {
//			this.userRepo.deleteAll();
			User admin = new User("Orcun", "Steven", "stev1@gmail.com", "0695875045", "stev1", encoder.encode("012345"));
			Role adminRole = roleRepo.findByName(RoleName.ROLE_ADMIN).get();
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			admin.setRoles(roles);
			userRepo.save(admin);
		}
}

