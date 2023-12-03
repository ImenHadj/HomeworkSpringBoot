package esprit.tn.projetspring1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table( name = "Chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private typeC typeChambre;
    @ManyToOne
    Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
