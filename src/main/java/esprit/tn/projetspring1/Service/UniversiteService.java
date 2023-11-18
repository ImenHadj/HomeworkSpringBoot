package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Foyer;
import esprit.tn.projetspring1.entity.Universite;
import esprit.tn.projetspring1.repository.Foyerrepository;
import esprit.tn.projetspring1.repository.Universiterepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteservice {
    Universiterepository universiterepository;
    Foyerrepository foyerrepository;



    @Override
    public  List<Universite> retrieveAllUniversites() {return (List<Universite>) universiterepository.findAll();}

    @Override
    public  Universite addUniversite(Universite u) {return (Universite) universiterepository.save(u);}

    @Override
    public  Universite updateUniversite(Universite u) {
        return universiterepository.save(u);
    }


    @Override
    public Universite retrieveUniversite(Long idUniversite) {return universiterepository.findById(idUniversite).get();}

    @Override
    public Foyer affecterfoyerAuniversite(long idFoyer, String nomUniversite) {
        return null;
    }

    @Override
    public  void removeUniversite(Long idUniversite) {universiterepository.deleteById(idUniversite);}




    // public Universite affecteruniversiteAFoyer(long idUniversite, String nomFoyer) {
      // Universite universite = universiterepository.findById(idUniversite).get();
        //Foyer foyer = foyerrepository.findByNomFoyer(nomFoyer);
        //universiterepository.save(universite);
//return universite;
  // }


    /*public Universite affecteruniversiteAFoyer(long idUniversite, String nomFoyer) {
        Universite universite = universiterepository.findById(idUniversite).orElse(null);
        Foyer foyer = foyerrepository.findByNomFoyer(nomFoyer);

        if (universite != null && foyer != null) {
            // Associez l'université au foyer
            universite.setFoyer(foyer);

            // Sauvegardez les modifications dans la base de données
            universiterepository.save(universite);
        }

        return universite;
    }



    @Override
    public Universite desaffecteruniversiteAFoyer(long idUniversite) {
        return null;
    }*/

    public Universite affecteruniversiteAFoyer(long idUniversite, String nomFoyer) {
        Universite universite = universiterepository.findById(idUniversite).orElse(null);
        Foyer foyer = foyerrepository.findByNomFoyer(nomFoyer);
        universite.setFoyer(foyer);
        universiterepository.save(universite);
        return universite;
    }
    public Universite desaffecteruniversiteAFoyer(long idUniversite) {
        Universite universite  = universiterepository.findById(idUniversite).get();
        universite.setFoyer(null);
        universiterepository.save(universite);
        return universite;
    }


}