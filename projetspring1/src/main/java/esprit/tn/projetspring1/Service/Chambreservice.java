package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Chambre;
import esprit.tn.projetspring1.entity.typeC;
import esprit.tn.projetspring1.repository.Blocrepository;
import esprit.tn.projetspring1.repository.Chambrerepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static esprit.tn.projetspring1.entity.typeC.*;

@Slf4j
@Service
@AllArgsConstructor
public class Chambreservice implements IChambreservice {
    Chambrerepository chambrerepository;
    Blocrepository blocrepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambrerepository.findAll();
    }




    @Override
    public Chambre addChambre(Chambre c) {return (Chambre) chambrerepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambrerepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambrerepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambrerepository.deleteById(idChambre);


    }

    public Set<Chambre> getChambresParNomBloc( String nomBloc ){
        Bloc bloc =blocrepository.findBynomBloc(nomBloc);
        return bloc.getChambres();
    }
    public long nbChambreParTypeEtBloc(typeC typeChambre, Long idBloc ){
        List<Chambre> chambre =chambrerepository.findByTypeChambreAndBlocIdBloc(typeChambre,idBloc);

    return chambre.size();
    }

    @Scheduled(fixedRate = 60000)
    public void listeChambresParBloc(){
        blocrepository.findAll().
        forEach( ch ->{
            log.info("Bloc :"+ ch.getNomBloc()+"ayant une capacite de :"+ch.getCapaciteBloc());
            log.info("Listes des chambres de bloc "+ch.getNomBloc());
       Set<Chambre> chambre =ch.getChambres();
            chambre.forEach(cha->{
           log.info("chambre numero "+cha.getNumeroChambre()+"de type"+cha.getTypeChambre());
       });
        });

    }

    @Scheduled(fixedDelay = 10000)
    void pourcentageChambreParTypeChambre(){
        List<Chambre> chambres= (List<Chambre>) chambrerepository.findAll();
        long nbChambres = chambres.size();
        if(nbChambres!=0) {
            double nbSimple = (double) (chambrerepository.countByTypeChambre(SIMPLE) / nbChambres) * 100;
            double nbDouble = (double) (chambrerepository.countByTypeChambre(DOUBLE) / nbChambres) * 100;
            double nbTriple = (double) (chambrerepository.countByTypeChambre(TRIPLE) / nbChambres) * 100;

            log.info("nbTotaleChambres " + nbChambres);
            log.info("le pourcentage des chambres pour le type Simple est egale " + nbSimple + "%");
            log.info("le pourcentage des chambres pour le type DOUBLE est egale " + nbDouble + "%");
            log.info("le pourcentage des chambres pour le type TRIPLE est egale " + nbTriple + "%");

        }else{
            log.info("table vide ");
        }
    }







    }





