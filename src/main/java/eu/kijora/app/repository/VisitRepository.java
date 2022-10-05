package eu.kijora.app.repository;

import eu.kijora.app.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

//    List<Visit> findByName(String name);
}
