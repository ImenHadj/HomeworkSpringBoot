package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Chambre;
import org.springframework.data.repository.CrudRepository;

public interface Chambrerepository extends CrudRepository<Chambre,Long> {
}
