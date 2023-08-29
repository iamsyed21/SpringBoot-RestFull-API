package com.springboot.blog;

import com.springboot.blog.entity.Role;
import com.springboot.blog.repository.RoleRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring boot Blog App Rest APIs", description = "Spring boot blog app rest APIs documentation", version = "v1.0", contact = @Contact(name = "Syed Moin Ahmed", email = "syedmoinahmed01@gmail.com", url = "https://syedmoinahmed.dev/")), externalDocs = @ExternalDocumentation(description = "Spring boot blog app documentation", url = "https://github.com/iamsyed21/FullStack-Blog-App"))
public class SpringbootBlogRestApiApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		Role admin = new Role();
		admin.setName("ROLE_ADMIN");
		roleRepository.save(admin);

		Role user = new Role();
		user.setName("ROLE_USER?");
		roleRepository.save(user);
	}
}
