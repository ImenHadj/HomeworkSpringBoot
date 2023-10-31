package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Etudiant;
import lombok.AllArgsConstructor;

import java.util.List;



public interface IBlocservice {
    List<Bloc> retrieveAllBlocs();
   Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(Long idBloc);

    void removeBloc(Long idBloc);


}

