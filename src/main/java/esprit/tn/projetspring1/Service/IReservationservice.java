package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationservice {
    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    Reservation retrieveReservation(String idReservation);

    void removeReservation(String idReservation);

     List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin );
}


