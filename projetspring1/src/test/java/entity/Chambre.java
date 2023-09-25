package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.util.QTypeContributor;

@Entity
@Table( name = "Chambre")
public class Chambre {
    @Id
    Long idChambre;
    Long numeroChambre;
    typeC TypeChambre;
}
