package eu.kijora.app;

import eu.kijora.app.domain.Animal;
import eu.kijora.app.domain.Doctor;
import eu.kijora.app.repository.AnimalRepository;
import eu.kijora.app.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AnimalRepository ar, DoctorRepository dr) {
		return (args) -> {
			Doctor doc = new Doctor("Maciej", List.of(), 5000);
			dr.save(doc);

			Animal animal1 = new Animal("jacek", LocalDateTime.now().minusDays(30), LocalDateTime.now(), 25, doc);
			// save a few customers
			ar.save(new Animal( "jacek", LocalDateTime.now().minusDays(30), LocalDateTime.now(), 25, doc));
			ar.save(new Animal( "jacek2", LocalDateTime.now().minusDays(31), LocalDateTime.now(), 5, doc));
			ar.save(new Animal( "jacek2", LocalDateTime.now().minusDays(31), LocalDateTime.now(), 5, doc));
			ar.save(new Animal( "jacek2", LocalDateTime.now().minusDays(31), LocalDateTime.now(), 5, doc));
			ar.save(new Animal( "jacek", LocalDateTime.now().minusDays(31), LocalDateTime.now(), 5, doc));
			ar.save(new Animal( "jacek2", LocalDateTime.now().minusDays(31), LocalDateTime.now(), 5, doc));

			Doctor doc2 = new Doctor("Maciejo", List.of(), 5000);

			dr.save(doc2);


			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
//			ar.findByName("jacek").forEach(jacek -> {
//				log.info(jacek.toString());
//			});
//
//			dr.findByName("Maciej").forEach(m -> {
//				log.info(m.toString());
//			});
		};
	}
}
