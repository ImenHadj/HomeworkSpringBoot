package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "Foyer")
public class Foyer {
    @Id
    Long idFoyer;
    String nomFoyer;
    Long capaciteFoyer;

}
