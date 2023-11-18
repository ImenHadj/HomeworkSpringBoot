package esprit.tn.projetspring1.Controller;

import esprit.tn.projetspring1.Service.IUniversiteservice;
import esprit.tn.projetspring1.Service.UniversiteService;
import esprit.tn.projetspring1.entity.Universite;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
     IUniversiteservice UniversiteService;
     // http://localhost:8089/foyer/etudiant/retrieve-all-etudiants
     @GetMapping("/retrieve-all-Universites")
     public List<Universite> getUniversites() {
         List<Universite> listUniversites = UniversiteService.retrieveAllUniversites();
         return listUniversites;
     }// http://localhost:8089/foyer/etudiant/retrieve-etudiant/8
     @GetMapping("/retrieve-universite/{universite-id}")
     public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
         return UniversiteService.retrieveUniversite(universiteId);
     }
     @PostMapping("/add-universite")
     public Universite addUniversite(@RequestBody Universite u) {
         Universite universite = UniversiteService.addUniversite(u);
         return universite;
     }
     @DeleteMapping("/remove-universite/{universite-id}")
     public void removeUniversite(@PathVariable("universite-id") Long universiteId) {

         UniversiteService.removeUniversite(universiteId);
     }
     @PutMapping("/update-universite")
     public Universite updateUniversite(@RequestBody Universite u) {
         Universite universite= UniversiteService.updateUniversite(u);
         return universite;
     }
    //@PutMapping("/affecter/{idUniversite}/{nomFoyer}")
    //@ResponseBody
    //public Universite affecteruniversiteAFoyer(@PathVariable("idUniversite") long idUniversite,@PathVariable("nomFoyer")  String nomFoyer) {

      //  Universite universite = UniversiteService.affecteruniversiteAFoyer(idUniversite,nomFoyer);

        //return universite;
    //}




    @PutMapping("/affecter/{idUniversite}/{nomFoyer}")
    @ResponseBody
    public Universite affecteruniversiteAFoyer(@PathVariable("idUniversite") long idUniversite, @PathVariable("nomFoyer") String nomFoyer) {
        Universite universite = UniversiteService.affecteruniversiteAFoyer(idUniversite, nomFoyer);
        return universite;
    }
    @PutMapping("/desaffecter/{idUniversite}")
    @ResponseBody
    public Universite desaffecteruniversiteAFoyer(@PathVariable("idUniversite") long idUniversite) {
        Universite universite = UniversiteService.desaffecteruniversiteAFoyer(idUniversite);
        return universite;
    }
}

