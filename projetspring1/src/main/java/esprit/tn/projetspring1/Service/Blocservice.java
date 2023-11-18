package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Chambre;
import esprit.tn.projetspring1.repository.Blocrepository;
import esprit.tn.projetspring1.repository.Chambrerepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Blocservice implements IBlocservice {
    Blocrepository blocrepository;
    Chambrerepository chambrerepository;
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
    @Override
    public Bloc affecterChambreABloc(List<Long> numeroChambre, String nomBloc) {
        Bloc bloc = blocrepository.findBynomBloc(nomBloc);
        for (Long numero : numeroChambre) {
            Chambre chambre = chambrerepository.findByNumeroChambre(numero);
            chambre.setBloc(bloc);
            chambrerepository.save(chambre);
        }

        return bloc;
    }

    @Override
    public Bloc desaffecterChambreDeBloc(List<Long> numeroChambre) {
        for (Long numero : numeroChambre) {
            Chambre chambre = chambrerepository.findByNumeroChambre(numero);
            if (chambre != null) {
                chambre.setBloc(null);
                chambrerepository.save(chambre);
            }
        }
        return null;
    }}

