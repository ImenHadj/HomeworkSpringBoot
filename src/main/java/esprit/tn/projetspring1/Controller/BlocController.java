package esprit.tn.projetspring1.Controller;

import esprit.tn.projetspring1.Service.IBlocservice;
import esprit.tn.projetspring1.Service.IEtudiantService;
import esprit.tn.projetspring1.entity.Bloc;
import esprit.tn.projetspring1.entity.Chambre;
import esprit.tn.projetspring1.entity.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    IBlocservice blocservice;
    // http://localhost:8089/Foyer/Bloc/retrieve-all-Blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocservice.retrieveAllBlocs();
        return listBlocs;
    }// http://localhost:8089/Foyer/Bloc/retrieve-Bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocservice.retrieveBloc(blocId);
    }
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocservice.addBloc(b);
        return bloc;
    }
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocservice.removeBloc(blocId);
    }
    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc b) {
        Bloc bloc= blocservice.updateBloc(b);
        return bloc;
    }
    @PutMapping("/affecter/{nomBloc}")
    @ResponseBody
    public Bloc affecterChambreABloc(@RequestBody List<Long>numeroChambre,@PathVariable("nomBloc") String nomBloc ) {
        Bloc bloc = blocservice.affecterChambreABloc(numeroChambre,nomBloc);
        return bloc;
    }

    @PutMapping("/desaffecter/{numeroChambre}")
    @ResponseBody
    public Bloc desaffecterChambreDeBloc(@PathVariable("numeroChambre") List<Long> numeroChambre) {
        Bloc bloc = blocservice.desaffecterChambreDeBloc(numeroChambre);
        return bloc;
    }
}
