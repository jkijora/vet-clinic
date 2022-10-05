package eu.kijora.app.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "animalsSuperPets")
public class Animal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    LocalDateTime birthday;
    LocalDateTime registrationDate;
    int weight;
    @ManyToOne
    @JoinColumn(name="doctor_doctorid") //just the name of the newly produced column to store associations,
    //so it does not have to be identical like in the ID in Doctor class
    Doctor doctor;

    public Animal(String name, LocalDateTime birthday, LocalDateTime registrationDate, int weight, Doctor doctor) {
        this.name = name;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
        this.weight = weight;
        this.doctor = doctor;
    }
}
