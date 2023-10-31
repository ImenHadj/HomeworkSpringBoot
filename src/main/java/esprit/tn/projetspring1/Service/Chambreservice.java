package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Chambre;
import esprit.tn.projetspring1.repository.Blocrepository;
import esprit.tn.projetspring1.repository.Chambrerepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Chambreservice implements IChambreservice {
    Chambrerepository chambrerepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambrerepository.findAll();
    }




    @Override
    public Chambre addChambre(Chambre c) {return (Chambre) chambrerepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambrerepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambrerepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambrerepository.deleteById(idChambre);

    }
}
