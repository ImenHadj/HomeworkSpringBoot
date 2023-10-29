package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Etudiant;
import esprit.tn.projetspring1.entity.Foyer;
import esprit.tn.projetspring1.repository.Foyerrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Foyerservice implements IFoyerservice{
    Foyerrepository foyerrepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {return (List<Foyer>) foyerrepository.findAll();

    }

    @Override
    public Foyer addFoyer(Foyer f) {return (Foyer) foyerrepository.save(f);

    }

    @Override
    public Foyer updateFoyer(Foyer f) {return foyerrepository.save(f);

    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {return foyerrepository.findById(idFoyer).get();

    }

    @Override
    public void removeFoyer(Long idFoyer) {foyerrepository.deleteById(idFoyer);

    }
}
