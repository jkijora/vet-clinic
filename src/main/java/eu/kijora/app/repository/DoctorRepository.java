package eu.kijora.app.repository;

import eu.kijora.app.domain.Animal;
import eu.kijora.app.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByName(String name);
}
