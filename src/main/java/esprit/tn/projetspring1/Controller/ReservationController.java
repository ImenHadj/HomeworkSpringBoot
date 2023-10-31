package esprit.tn.projetspring1.Controller;

import esprit.tn.projetspring1.Service.IReservationservice;
import esprit.tn.projetspring1.Service.IUniversiteservice;
import esprit.tn.projetspring1.entity.Reservation;
import esprit.tn.projetspring1.entity.Universite;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    IReservationservice ReservationService;
    // http://localhost:8089/foyer/reservation/retrieve-all-etudiants
    @GetMapping("/retrieve-all-Reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = ReservationService.retrieveAllReservations();
        return listReservations;
    }// http://localhost:8089/foyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        return ReservationService.retrieveReservation(reservationId);
    }
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = ReservationService.addReservation(r);
        return reservation;
    }
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {

        ReservationService.removeReservation(reservationId);
    }
    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        Reservation reservation= ReservationService.updateReservation(r);
        return reservation;
    }
}
