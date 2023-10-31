package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Etudiant;
import esprit.tn.projetspring1.entity.Foyer;

import java.util.List;

public interface IFoyerservice {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(Long idFoyer);

    void removeFoyer(Long idFoyer);

}
