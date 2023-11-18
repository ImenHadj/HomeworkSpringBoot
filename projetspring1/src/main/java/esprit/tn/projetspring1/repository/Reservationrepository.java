package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Etudiant;
import esprit.tn.projetspring1.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface Reservationrepository extends CrudRepository<Reservation, String> {
     List<Reservation> findByAnneeUniversitaireBetween(Date dateDebut , Date dateFin );
}
