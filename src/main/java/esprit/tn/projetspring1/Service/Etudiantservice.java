package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Etudiant;
import esprit.tn.projetspring1.entity.Reservation;
import esprit.tn.projetspring1.repository.Etudiantrepository;
import esprit.tn.projetspring1.repository.Reservationrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class Etudiantservice implements IEtudiantService {
    Etudiantrepository etudiantrepository;
    Reservationrepository reservationrepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantrepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return (Etudiant) etudiantrepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantrepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantrepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantrepository.deleteById(idEtudiant);

    }
    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Reservation reservation = reservationrepository.findById(idReservation).get();
        Etudiant etudiant = etudiantrepository.findByNomEtAndPrenomEt( nomEt, prenomEt);
        ;
        Set<Reservation> Reservationmiseajour = new HashSet<>();
        if (etudiant.getReservations()!=null){
            Reservationmiseajour=etudiant.getReservations();
        }
        Reservationmiseajour.add(reservation);
        etudiant.setReservations(Reservationmiseajour);
        etudiantrepository.save(etudiant);
        return etudiant;



    }

}


