package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.Controller.ReservationController;
import esprit.tn.projetspring1.entity.Reservation;
import esprit.tn.projetspring1.repository.Reservationrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationservice{
    Reservationrepository reservationrepository;
    @Override
    public List<Reservation> retrieveAllReservations() {return (List<Reservation>) reservationrepository.findAll();}

    @Override
    public  Reservation addReservation(Reservation r) {return (Reservation) reservationrepository.save(r);}

    @Override
    public  Reservation updateReservation(Reservation r) {return reservationrepository.save(r);
    }


    @Override
    public Reservation retrieveReservation(String idReservation) {return reservationrepository.findById(idReservation).get();}

    @Override
    public  void removeReservation(String idReservation) {reservationrepository.deleteById(idReservation);}

    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin ){
        List<Reservation> reservation=reservationrepository.findByAnneeUniversitaireBetween(dateDebut , dateFin );

        return reservation;

    }

}
