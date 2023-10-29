package esprit.tn.projetspring1.Service;

import esprit.tn.projetspring1.entity.Reservation;

import java.util.List;

public interface IReservationservice {
    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    Reservation retrieveReservation(Long idReservation);

    void removeReservation(Long idReservation);
}


