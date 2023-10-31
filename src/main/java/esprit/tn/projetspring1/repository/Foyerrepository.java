package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Foyer;
import esprit.tn.projetspring1.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface Foyerrepository extends CrudRepository<Foyer, Long> {
}
