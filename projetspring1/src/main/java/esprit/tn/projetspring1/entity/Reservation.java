package esprit.tn.projetspring1.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Reservation")
public class Reservation {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    private Set<Etudiant> etudiants;


}
