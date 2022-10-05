package eu.kijora.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Entity
@Table(name = "doctorsSuperExtra")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorid;
    String name;
    @OneToMany(mappedBy="doctor", fetch = FetchType.EAGER) //mapped by gives bidirectional way,
    // value must be really the Doctor field name in the Animal class which should point on our Doctor class here.
    // We are saying here that One doctor has association to Many animals, but the animal has 1 doctor
    // and the animal KNOWS about it's doctor because of this mappedBy because relation to this doctor is
    // actually just stored in "doctor" field in Animal
    List<Animal> animals;
    int salary;

    public Doctor(String name, List<Animal> animals, int salary) {
        this.name = name;
        this.animals = animals;
        this.salary = salary;
    }
}
