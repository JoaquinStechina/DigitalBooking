package DigitalHouse.ProyectoIntegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectoIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegradorApplication.class, args);
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/productos**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/reservas**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/categorias**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/ciudades**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/caracteristicas**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/imagenes**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
				registry.addMapping("/usuarios**").allowedOriginPatterns("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");
			}
		};
	}
}
