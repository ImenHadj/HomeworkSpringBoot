package esprit.tn.projetspring1.Controller;

import esprit.tn.projetspring1.Service.IChambreservice;
import esprit.tn.projetspring1.Service.IEtudiantService;
import esprit.tn.projetspring1.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreservice chambreservice;

    // http://localhost:8089/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreservice.retrieveAllChambres();
        return listChambres;
    }// http://localhost:8089/chambre/retrieve-chambre/8

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId) {
        return chambreservice.retrieveChambre(chambreId);
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreservice.addChambre(c);
        return chambre;
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chambreId) {
        chambreservice.removeChambre(chambreId);
    }

    @PutMapping("/update-chambre")
    public Chambre updateEtudiant(@RequestBody Chambre c) {
        Chambre chambre = chambreservice.updateChambre(c);
        return chambre;
    }

    @GetMapping("/nbChambreParTypeEtBloc/{TypeChambre}/{idBloc}")
    public long nbChambreParTypeEtBloc(@PathVariable  ("TypeChambre") typeC TypeChambre, @PathVariable("idBloc") Long idBloc){

        return chambreservice.nbChambreParTypeEtBloc(TypeChambre, idBloc);

    }}