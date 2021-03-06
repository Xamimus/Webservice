package com.b2dev.forum;

import com.b2dev.forum.entity.*;
import com.b2dev.forum.repository.*;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.*;

@SpringBootApplication
public class ForumApplication {

	static Logger LOGGER = LoggerFactory.getLogger(ForumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private ReportReasonRepository reportReasonRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Value(value = "${populatedb}")
	private boolean populatedb;

	@Value(value = "${usersToGenerate}")
	private int usersToGenerate;

	@Value(value = "${topicsToGenerate}")
	private int topicsToGenerate;

	@Value(value = "${minPostsPerTopicToGenerate}")
	private int minPostsPerTopicToGenerate;

	@Value(value = "${maxPostsPerTopicToGenerate}")
	private int maxPostsPerTopicToGenerate;

	@PostConstruct
	private void init() {
		if (populatedb) {
			LOGGER.info("About to populate database from generated data");
		} else {
			LOGGER.info("Populate database at startup is disabled");
			return;
		}


		Faker faker = new Faker(new Locale("fr"));

		// Cr??ation des roles
		LOGGER.info("Generating roles");
		List<Role> roles = new ArrayList<>();

		if (roleRepository.count() == 0) {
			for (EnumRole enumRole : EnumRole.values()) {
				Role role = new Role();
				role.setName(enumRole);
				roles.add(role);
			}
			roleRepository.saveAll(roles);
		}

		Role adminRole = roleRepository.findByName(EnumRole.ROLE_ADMIN).get();
		Role userRole = roleRepository.findByName(EnumRole.ROLE_USER).get();
		Role moderatorRole = roleRepository.findByName(EnumRole.ROLE_MODERATOR).get();
		Role anonymousRole = roleRepository.findByName(EnumRole.ROLE_ANONYMOUS).get();
		if (userRepository.count() == 0)
		{
			// Cr??ation d'un utilisateur sp??cial ayant le r??le d'Administrateur,
			// seule personne habilit??e ?? cr??er par la suite des entit??s comme Artist et Album
			User admin = new User();
			admin.setEmail("admin@test");
			admin.setPassword(encoder.encode("1234"));
			Set<Role> adminRoles = new HashSet<>();
			adminRoles.add(adminRole);
			admin.setRoles(adminRoles);
			userRepository.save(admin);

			// Cr??ation d'un utilisateur anonyme ?? des fins de test
			User anonymous = new User();
			anonymous.setEmail("anonymous@test");
			anonymous.setPassword(encoder.encode("1234"));


			Set<Role> anonymousRoles = new HashSet<>();
			anonymousRoles.add(anonymousRole);
			anonymous.setRoles(anonymousRoles);
			userRepository.save(anonymous);

			// Cr??ation d'un User ?? des fins de test
			User simpleUser = new User();
			simpleUser.setEmail("user@test");
			simpleUser.setPassword(encoder.encode("1234"));

			Role simpleUserRole = roleRepository.findByName(EnumRole.ROLE_USER).get();
			Set<Role> simpleUserRoles = new HashSet<>();
			simpleUserRoles.add(simpleUserRole);
			simpleUser.setRoles(simpleUserRoles);
			userRepository.save(simpleUser);

			//Cr??ation d'un mod??rateur ?? des fins de test
			User moderator = new User();
			moderator.setEmail("moderator@test");
			moderator.setPassword(encoder.encode("1234"));
			Set<Role> moderatorRoles = new HashSet<>();
			moderatorRoles.add(moderatorRole);
			moderator.setRoles(moderatorRoles);
			userRepository.save(moderator);
		}

		
		// Cr??ation des raisons de reports
		LOGGER.info("Generating report reasons");
		List<ReportReason> reasons = new ArrayList<>();
		if (reportReasonRepository.count() == 0) {
			for (EnumReportReason enumReason : EnumReportReason.values()) {
				ReportReason reason = new ReportReason();
				reason.setName(enumReason);
				reasons.add(reason);
			}
			reportReasonRepository.saveAll(reasons);
		}

		// Cr??ation des cat??gories
		LOGGER.info("Generating categories");
		List<Category> categories = new ArrayList<>();
		if (categoryRepository.count() == 0) {
			List<String> categoriesName = new ArrayList<String>();
			categoriesName.add("Hardware");
			categoriesName.add("Ordinateurs portables");
			categoriesName.add("Overclocking, Cooling & Modding");
			categoriesName.add("Technologies Mobiles");
			categoriesName.add("Apple");
			categoriesName.add("Video & Son");
			categoriesName.add("Photo num??rique");
			categoriesName.add("Jeux video");
			categoriesName.add("Windows & Software");

			for (String category : categoriesName) {
				Category newCategory = new Category();
				newCategory.setName(category);
				categories.add(newCategory);
			}
			categoryRepository.saveAll(categories);
		}

		LOGGER.info("Generating " + userRepository + "users");
		List<User> users = new ArrayList<>();
		for (int x = 0; x < usersToGenerate; x++) {
			User u = new User();
			u.setEmail(faker.internet().emailAddress());
			u.setPassword(encoder.encode(faker.bothify("??##??##")));
			Set<Role> userRoles = new HashSet<>();
			userRoles.add(userRole);
			u.setRoles(userRoles);
			users.add(u);
		}
		userRepository.saveAll(users);

		LOGGER.info("Generating " + topicsToGenerate + "topics");
		long totalCategories = categoryRepository.count();
		long totalUsers = userRepository.count();

		for (int x = 0; x < topicsToGenerate; x++) {

			Name name = faker.name();
			Topic t = new Topic();
			t.setTitle(name.title());
			t.setLocked(false);
			t.setCategory(categoryRepository.getById((long) (Math.random() * totalCategories) + 1));
			t.setAuthor(userRepository.getById((long) (Math.random() * totalUsers) + 1));
			Topic topic = topicRepository.save(t);

			LOGGER.info("Generating between " + minPostsPerTopicToGenerate + " and " + maxPostsPerTopicToGenerate + " posts");
			long totalReportReasons = reportReasonRepository.count();
			int numPosts = new Random().nextInt(maxPostsPerTopicToGenerate - minPostsPerTopicToGenerate) + minPostsPerTopicToGenerate;
			for (int i = 0; i < numPosts; i++) {
				Post p = new Post();
				p.setContent(faker.lorem().sentence(15));
				long randomAuthor = (long) (Math.random() * totalUsers) + 1;
				p.setAuthor(userRepository.getById(randomAuthor));
				Date start = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
				Date end = new GregorianCalendar(2021, Calendar.DECEMBER, 30).getTime();
				p.setCreatedAt(faker.date().between(start, end));
				p.setTopic(topic);

				// On ajoute de l'al??atoire sur la valeur de la date de mise ?? jour du post
				int random = (int) (Math.random() * 4);
				if (random == 1) {
					p.setUpdatedAt(faker.date().between(start, end));
				}
				postRepository.save(p);
				// On ajoute de l'al??atoire sur le nombre de report par Post
				List<Report> reports = new ArrayList<>();
				int randomReport = (int) (Math.random() * 4);
				for (int j = 0; j < randomReport; j++) {
					Report r = new Report();
					long randomAuthorReport = (long) (Math.random() * totalUsers) + 1;
					while (randomAuthor == randomAuthorReport) {
						randomAuthorReport = (long) (Math.random() * totalUsers) + 1;
					}
					r.setPost(p);
					r.setAuthor(userRepository.getById(randomAuthorReport));
					r.setReason(reportReasonRepository.getById((long) (Math.random() * totalReportReasons) + 1));
					r.setPost(p);
					reports.add(r);
				}
				reportRepository.saveAll(reports);
			}
		}
	}

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
