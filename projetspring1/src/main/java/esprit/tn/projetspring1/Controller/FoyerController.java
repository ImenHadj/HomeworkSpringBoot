package esprit.tn.projetspring1.Controller;

import esprit.tn.projetspring1.Service.IFoyerservice;
import esprit.tn.projetspring1.Service.IReservationservice;
import esprit.tn.projetspring1.entity.Foyer;
import esprit.tn.projetspring1.entity.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    IFoyerservice Foyerservice;
    // http://localhost:8089/foyer/reservation/retrieve-all-etudiants
    @GetMapping("/retrieve-all-Foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = Foyerservice.retrieveAllFoyers();
        return listFoyers;
    }// http://localhost:8089/foyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return Foyerservice.retrieveFoyer(foyerId);
    }
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = Foyerservice.addFoyer(f);
        return foyer;
    }
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {

        Foyerservice.removeFoyer(foyerId);
    }
    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
       Foyer foyer= Foyerservice.updateFoyer(f);
        return foyer;
    }
}
