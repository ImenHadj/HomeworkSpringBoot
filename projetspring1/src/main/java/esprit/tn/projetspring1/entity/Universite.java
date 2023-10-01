package esprit.tn.projetspring1.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "Universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    @OneToOne
    private Foyer foyer;

}
