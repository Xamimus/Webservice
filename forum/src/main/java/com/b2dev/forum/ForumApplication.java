package com.b2dev.forum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.b2dev.forum.entity.Category;
import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Post;
import com.b2dev.forum.entity.Role;
import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.entity.User;
import com.b2dev.forum.repository.CategoryRepository;
import com.b2dev.forum.repository.PostRepository;
import com.b2dev.forum.repository.RoleRepository;
import com.b2dev.forum.repository.TopicRepository;
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
	private TopicRepository topicRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
  	PasswordEncoder encoder;

	@Value(value = "${populatedb}")
  	private boolean populatedb;

	@PostConstruct
  	private void init() {

		User admin = new User();
		admin.setEmail("admin@test");
		admin.setPassword(encoder.encode("1234"));

		if (userRepository.count() == 0) {

			// Création des roles
			Role adminRole = roleRepository.save(new Role(EnumRole.ROLE_ADMIN));
			roleRepository.save(new Role(EnumRole.ROLE_USER));
		
			// Création d'un utilisateur spécial ayant le rôle d'Administrateur,
			// seule personne habilitée à créer par la suite des entités comme Artist et Album
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			admin.setRoles(roles);
			userRepository.save(admin);
		}

		//Création de la première catégorie
		Category category = new Category();
		category.setName("Divers");

		if (categoryRepository.count() == 0){	
			categoryRepository.save(category);
		}

		


		Topic topic = new Topic();
			topic.setAuthor(admin);
			topic.setCategory(category);
			topic.setLocked(false);
			topic.setTitle("Premier Topic");
		//Création du premier topic
		if (topicRepository.count() == 0) {
			
			topicRepository.save(topic);
		}

		//Création du post
		Post post = new Post();
		post.setAuthor(admin);
		post.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
		post.setContent("Voilà le premier post");
		post.setTopic(topic);
		
		if (postRepository.count() == 0){
			postRepository.save(post);
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
