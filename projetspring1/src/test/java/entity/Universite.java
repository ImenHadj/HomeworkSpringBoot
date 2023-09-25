package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "Universite")
public class Universite {
    @Id
    Long idUniversite;
    String nomUniversite;
    String adresse;

}
