package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Universite;

import java.util.List;

public interface IUniversiteservice {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(Long idUniversite);

    void removeUniversite(Long idUniversite);
}
