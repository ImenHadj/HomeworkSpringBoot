package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Etudiant;
import esprit.tn.projetspring1.repository.Etudiantrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@AllArgsConstructor

public class Etudiantservice implements IEtudiantService{
   Etudiantrepository etudiantrepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantrepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return (Etudiant) etudiantrepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantrepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantrepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantrepository.deleteById(idEtudiant);

    }
}
