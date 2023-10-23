package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Bloc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Blocrepository extends CrudRepository<Bloc,Long> {
    List<Bloc>
    findByFoyerUniversiteUniversiteId(Long idUniversite) ;
}
