package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Foyer;
import esprit.tn.projetspring1.entity.Universite;

import java.util.List;

public interface IUniversiteservice {


    //Universite affecteruniversiteAFoyer() ;


    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(Long idUniversite);

    public Foyer affecterfoyerAuniversite(long idFoyer, String nomUniversite);

    void removeUniversite(Long idUniversite);

    Universite affecteruniversiteAFoyer(long idUniversite, String nomFoyer);

    Universite desaffecteruniversiteAFoyer(long idUniversite);
}
