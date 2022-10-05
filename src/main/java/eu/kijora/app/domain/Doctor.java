package eu.kijora.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    int salary;

    @OneToMany(mappedBy="doctor", fetch = FetchType.EAGER) //mapped by gives bidirectional way,
    // value must be really the Doctor field name in the Animal class which should point on our Doctor class here.
    // We are saying here that One doctor has association to Many animals, but the animal has 1 doctor
    // and the animal KNOWS about it's doctor because of this mappedBy because relation to this doctor is
    // actually just stored in "doctor" field in Animal
            //Here doctor is an OWNING part of the relationship
    List<Animal> animals;

    @OneToMany(mappedBy="conductingDoctor", fetch = FetchType.EAGER)
    //Here similar thing doctor owns visits and visits have a conductingDoctor field to map.
    // Doctor does not have the fields regarding the animals - it is an owner and the owned ones must keep the references to owners.
    // Doctor just has to know what is the name of the field which OWNED part has to describe its OWNER
    List<Visit> visits;


    public Doctor(String name, List<Animal> animals, int salary) {
        this.name = name;
        this.animals = animals;
        this.salary = salary;
    }
}
