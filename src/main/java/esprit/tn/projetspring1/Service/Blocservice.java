package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.repository.Blocrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Blocservice implements IBlocservice {
    Blocrepository blocrepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return (List<Bloc>) blocrepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return (Bloc) blocrepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocrepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocrepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocrepository.deleteById(idBloc);

    }
}
