package eu.kijora.app.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "visits")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToOne
//    @JoinColumn(name = "doctor_id_for_visit") //Just the name of the column created IN VISITS to store the reference to Doctor.
//            //here by adding join column we kind of decided that Visit will be the class holding the reference I guess
//            //By having the JoinColumn here, we have made Visit an OWNING side of the relationship
//    Doctor conductingDoctor;

    @ManyToOne
    @JoinColumn(name = "doctor_id_for_visit") //Just the name of the column created IN VISITS to store the reference to Doctor.
    //here by adding join column we kind of decided that Visit will be the class holding the reference I guess
    //By having the JoinColumn here, we have made Visit an OWNED side of the relationship because it has to keep track of it's master
    Doctor conductingDoctor;

    public Visit(Doctor doctor) {
        this.conductingDoctor = doctor;
    }
}
