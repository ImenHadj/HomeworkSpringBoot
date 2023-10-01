package esprit.tn.projetspring1.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Etudiant")
public class Etudiant  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // Clé primaire
     private String nomEt;
     private String prenomEt;
     private Long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
     Date dateNaissance;

    @ManyToMany (cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}

