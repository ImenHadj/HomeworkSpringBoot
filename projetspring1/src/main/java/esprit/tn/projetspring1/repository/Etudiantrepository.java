package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Etudiantrepository extends CrudRepository<Etudiant , Long> {
    // public interface Etudiantrepository extends PagingAndSortingRepository<Etudiant , Long>{}


}
