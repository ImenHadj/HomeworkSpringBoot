package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Etudiant;

import java.util.List;

public interface IEtudiantService  {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);
}
