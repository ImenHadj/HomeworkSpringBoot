package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Universite;
import esprit.tn.projetspring1.repository.Universiterepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteservice {
    Universiterepository universiterepository;
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
    public  void removeUniversite(Long idUniversite) {universiterepository.deleteById(idUniversite);}}