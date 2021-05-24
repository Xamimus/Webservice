package com.b2dev.forum;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Role;
import com.b2dev.forum.entity.User;
import com.b2dev.forum.repository.RoleRepository;
import com.b2dev.forum.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
  	PasswordEncoder encoder;

	@Value(value = "${populatedb}")
  	private boolean populatedb;

	@PostConstruct
  	private void init() {

		if (userRepository.count() < 1) {

			// Création des roles
			Role adminRole = roleRepository.save(new Role(EnumRole.ROLE_ADMIN));
			roleRepository.save(new Role(EnumRole.ROLE_USER));
		
			// Création d'un utilisateur spécial ayant le rôle d'Administrateur,
			// seule personne habilitée à créer par la suite des entités comme Artist et Album
			User admin = new User();
			admin.setEmail("admin@test");
			admin.setPassword(encoder.encode("1234"));
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			admin.setRoles(roles);
			userRepository.save(admin);
		}
		
	}

	/**
	 * Pour ce TP on autorise les requêtes cross domain car il est fort probable que le client REST tourne sur un autre
	 * port de la machine.
	 * 
	 * @return un filtrage CORS
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
