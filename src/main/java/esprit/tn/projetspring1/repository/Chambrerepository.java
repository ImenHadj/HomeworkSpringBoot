package esprit.tn.projetspring1.repository;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Chambre;
import esprit.tn.projetspring1.entity.typeC;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Chambrerepository extends CrudRepository<Chambre,Long> {
    Chambre findByNumeroChambre(Long numero);
    List<Chambre> findByTypeChambreAndBlocIdBloc(typeC TypeChambre, Long idBloc );
}
