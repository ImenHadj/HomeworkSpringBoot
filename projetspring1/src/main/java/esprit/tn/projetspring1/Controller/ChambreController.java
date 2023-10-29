package esprit.tn.projetspring1.Controller;

import esprit.tn.projetspring1.Service.IChambreservice;
import esprit.tn.projetspring1.Service.IEtudiantService;
import esprit.tn.projetspring1.entity.Chambre;
import esprit.tn.projetspring1.entity.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreservice chambreservice;
    // http://localhost:8089/foyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreservice.retrieveAllChambres();
        return listChambres;
    }// http://localhost:8089/foyer/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId) {
        return chambreservice.retrieveChambre(chambreId);
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreservice.addChambre(c);
        return chambre;
    }
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chambreId) {
        chambreservice.removeChambre(chambreId);
    }
    @PutMapping("/update-chambre")
    public Chambre updateEtudiant(@RequestBody Chambre c) {
        Chambre chambre= chambreservice.updateChambre(c);
        return chambre;
    }
}
