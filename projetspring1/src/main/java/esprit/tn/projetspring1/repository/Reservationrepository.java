package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Etudiant;
import esprit.tn.projetspring1.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface Reservationrepository extends CrudRepository<Reservation, Long> {
}
